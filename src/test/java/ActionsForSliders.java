import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ActionsForSliders {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    void testHerokuAppSlider1() throws MalformedURLException {
        URL url = new URL("https://the-internet.herokuapp.com/horizontal_slider");
        driver.get(String.valueOf(url));
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        System.out.println(slider.getLocation().getX());
        ;
        Assert.assertEquals(range.getText(),"0");
       actions.clickAndHold(slider).moveByOffset(35,0).release().perform();
       //actions.dragAndDropBy(slider,55,0).perform();
//        actions.click(slider).sendKeys(Keys.UP).perform();
//        actions.dragAndDrop(slider,range).perform();
        Assert.assertEquals(range.getText(),"5");
    }


    @Test
    void testHerokuAppSliderStepByStep() throws MalformedURLException {
        URL url = new URL("https://the-internet.herokuapp.com/horizontal_slider");
        driver.get(String.valueOf(url));
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        int xOffset = -45;
        double expectedRange = 0.5;
        while (!range.getText().equals("5")){
            actions.clickAndHold(slider).moveByOffset(xOffset,0).release().perform();
            xOffset+=10;
            String actualRange = range.getText().contains(".")? range.getText() : range.getText().concat(".0");
            if (xOffset==35){
                expectedRange=4.0;
            }
            Assert.assertEquals(actualRange,Double.toString(expectedRange));
            expectedRange+=0.5;
            if (expectedRange==2.5){
                xOffset=0;
            }
        }



    }

    @Test
    void telerikHorizontalVerticalSliderTest(){
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");
        WebElement hSlider = driver.findElement(By.xpath("//span[@class='k-draghandle' and not(@aria-orientation='vertical')]"));
        WebElement vSlider = driver.findElement(By.xpath("//span[@aria-orientation='vertical']"));
        List<WebElement> hTicks = driver.findElements(By.xpath("//div[contains(@class,'vertical')]//li"));
        List<WebElement> vTicks = driver.findElements(By.xpath("//div[contains(@class,'horizontal')]//li"));
        actions.clickAndHold(vSlider).moveByOffset(0,-95).release().perform();

        actions.clickAndHold(hSlider).moveByOffset(95,0).release().perform();
        WebElement pic = driver.findElement(By.xpath("//img[contains(@src,'foods')]"));
        Assert.assertEquals(pic.getCssValue("width"),"150px");
        Assert.assertEquals(pic.getCssValue("height"),"150px");



    }


}
