import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitHerokuApp {
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    }

    @Test(description = "dynamic controls herokuapp  - visibility of message")
    void dynamicControlsTest(){
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        WebElement message= WaitUtils.fluentWait(driver,20,2,By.xpath("//form[@id='checkbox-example']/p"));
        Assert.assertEquals(message.getText(),"It's gone!");
    }
}
