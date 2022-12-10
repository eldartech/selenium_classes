import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
         wait = new WebDriverWait(driver,6);

    }

    @Test(description = "dynamic controls herokuapp  - visibility of message")
    void dynamicControlsTest(){
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/p")));
        Assert.assertEquals(message.getText(),"It's gone!");
    }

    @Test(description = "dynamic controls herokuapp  - invisibility of loader")
    void dynamicControlsInvisibilityTest(){
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        WebElement message= driver.findElement(By.xpath("//form[@id='checkbox-example']/p"));
        Assert.assertEquals(message.getText(),"It's gone!");
    }
    @Test(description = "dynamic controls herokuapp  - Enable/disable")
    void dynamicControlsEnableDisableTest() {
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@type='text']")));

    }

}
