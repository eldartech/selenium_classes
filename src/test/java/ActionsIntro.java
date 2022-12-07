import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsIntro {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }


    @Test
    void rightClickAction(){
            actions.contextClick(driver.findElement(By.tagName("h3"))).perform();
    }


    @Test
    void hoverOverTest(){
        WebElement user1 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(user1).perform();
        WebElement viewProfile1 = driver.findElement(By.cssSelector("a[href='/users/1']"));
        Assert.assertTrue(viewProfile1.isEnabled());
        Assert.assertTrue(viewProfile1.isDisplayed());


    }

    @Test
    void hoverOverAllProfilesTest(){
        List<WebElement> allProfiles = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> allNames = driver.findElements(By.tagName("h5"));
        List<WebElement> allViewProfiles = driver.findElements(By.xpath("//a[text()='View profile']"));
       for (int i=0;i<allViewProfiles.size();i++){
           actions.moveToElement(allProfiles.get(i)).perform();
//           String profile = allNames.get(i).getText().replaceAll("[^\\d]","");
           Assert.assertTrue(allNames.get(i).isDisplayed());
           Assert.assertTrue(allViewProfiles.get(i).isEnabled());

       }


    }



}
