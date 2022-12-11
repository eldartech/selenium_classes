import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitEvilTest {
    WebDriver driver;

    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eviltester.github.io/synchole/buttons.html");
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
    }

    @Test
    void eviltestButtonWaitTest(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement startButton = driver.findElement(By.id("easy00"));
        startButton.click();
        WebElement oneButton = driver.findElement(By.id("easy01"));
        oneButton.click();
        WebElement twoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='easy02']")));
        twoButton.click();
        WebElement threeButton = driver.findElement(By.id("easy03"));
        threeButton.click();
        WebElement easyButtonMessage = driver.findElement(By.id("easybuttonmessage"));
        Assert.assertEquals(easyButtonMessage.getText(),"All Buttons Clicked");
    }
}
