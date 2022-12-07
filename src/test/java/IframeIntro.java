import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class IframeIntro {


    WebDriver driver;
    Actions actions;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @Test
    void techtorialAppTest() throws InterruptedException {
        driver.get("file:///Users/techtorialacademy/Desktop/techtorialApp/TechtorialApp.html");
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());
        //driver.switchTo().frame(0);//Index
        //driver.switchTo().frame("starlink");//Name
        //driver.switchTo().frame("star001");//ID
        //1. WebElement:
//        WebElement iframe = driver.findElement(By.tagName("iframe"));
//        driver.switchTo().frame(iframe);
        //2. WebElement:
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='starlink']")));//WebElement
        Thread.sleep(1000);

        driver.findElement(By.className("avatar")).click();
        List<WebElement> menuOptions = driver.findElements(By.xpath("//div[contains(@class,'sidemenu-option')]//a/span"));
        List<String> actualMenuOptions = new ArrayList<>();

        for (WebElement option: menuOptions){
            actualMenuOptions.add(option.getAttribute("innerText"));
        }
        System.out.println(actualMenuOptions);
        Assert.assertEquals(Arrays.asList("Residential", "Business", "RV", "Maritime", "Aviation", "IoT", "Technology", "Support","MAP", "RESOURCES","SPECIFICATIONS"),actualMenuOptions);
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement countries = driver.findElement(By.id("country"));
        Select countrySelect = new Select(countries);
        //index, visible text, value
        countrySelect.selectByValue("BY");
        Assert.assertEquals("Belarus",countrySelect.getFirstSelectedOption().getText());

    }

    @Test
    void elonMuskTest(){
        driver.get("file:///Users/techtorialacademy/Desktop/html/main.html");
        List<WebElement> iframesOfMain = driver.findElements(By.tagName("iframe"));
        System.out.println("Amount of <iframe> tag in main: "+iframesOfMain.size());

        driver.switchTo().frame(0);
        System.out.println("Iframe for Techtorial");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Techtorial']")).isDisplayed());
        driver.switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
         driver.switchTo().frame("demoqa");
        System.out.println("Switched to DemoQA");
        WebElement toolsQAImage = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        Assert.assertTrue(toolsQAImage.isDisplayed());
        Assert.assertEquals(toolsQAImage.getCssValue("line-height"),"24px");


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'sampleiframe')]")));
        System.out.println("Switched to frame1");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(),"Parent frame");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[srcdoc*='Child']")));
        System.out.println("Switched to child frame");
        WebElement childFrameParagraph = driver.findElement(By.tagName("p"));
        Assert.assertEquals(childFrameParagraph.getText(),"Child Iframe");
        driver.switchTo().parentFrame();
        System.out.println("switched one step back in frames");
        driver.switchTo().parentFrame();
        System.out.println("switched two steps back in frames");
        List<WebElement> headerTextsWE = driver.findElements(By.className("header-text"));
        Assert.assertEquals(getTexts(headerTextsWE),Arrays.asList("Elements","Forms","Alerts, Frame & Windows","Widgets","Interactions","Book Store Application"));
        driver.switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_UP).perform();
        WebElement teslaHyperLink = driver.findElement(By.xpath("//a[.='Tesla']"));
        teslaHyperLink.click();
        String mainWindowID = driver.getWindowHandle();
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id: allWindowIDs){
            if (!mainWindowID.equals(id)){
                driver.switchTo().window(id);
                List<WebElement> menuOptions = driver.findElements(By.className("tds-site-nav-item-text"));
                List<String> actualMenu = getTexts(menuOptions);
                List<String> expectedMenu = Arrays.asList("Model S", "Model 3", "Model X", "Model Y", "Solar Roof", "Solar Panels", "Shop", "Account", "Menu");
                System.out.println(actualMenu);
                Assert.assertEquals(actualMenu, expectedMenu);
               break;
            }
        }
        if (driver.getTitle().equals("Elon Musk | Tesla")){
            driver.close();
            driver.switchTo().window(mainWindowID);
        }
        Assert.assertEquals(driver.getTitle(),"My Profile");





    }

    List<String> getTexts(List<WebElement> elements){
        List<String> result = new ArrayList<>();
        for (WebElement element:elements){
            result.add(element.getText());
        }
        return result;
    }
}
