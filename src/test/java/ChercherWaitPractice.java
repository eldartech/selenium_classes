import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChercherWaitPractice {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");


    }

    @Test
    void chercherAlertTest(){
        driver.findElement(By.id("alert")).click();
        wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I got opened after 5 secods");
        alert.accept();

    }
}
