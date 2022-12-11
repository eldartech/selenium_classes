import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotVisibleException.class);
//        wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver d) {
//                return d.findElement(By.xpath("//button[@id='easy02']"));
//            }
//        });

        WebElement twoButton = fluentWait.until(d->d.findElement(By.xpath("//button[@id='easy02']")));
        twoButton.click();
        WebElement threeButton = driver.findElement(By.id("easy03"));
        threeButton.click();
        WebElement easyButtonMessage = driver.findElement(By.id("easybuttonmessage"));
        Assert.assertEquals(easyButtonMessage.getText(),"All Buttons Clicked");


    }
}
