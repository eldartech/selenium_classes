import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AlertJS {
    List<String> testData = new ArrayList<>();
    WebDriver driver;
    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

    }

    @Test(description = "Demo QA - Simple Alert Test")
    void simpleAlertTest() throws InterruptedException {
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You clicked a button");
        Thread.sleep(2000);
        alert.accept();
    }

    @Test(description = "Demo QA -  Simple Alert Time Delay Test")
    void timerAlertButtonTest(){
        driver.findElement(By.id("timerAlertButton")).click();
        sleep(6000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This alert appeared after 5 seconds");
        alert.accept();
    }

    @Test(description = "Confirmation Alert Test  - Cancel")
    void confirmCancelButtonTest(){
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Do you confirm action?");
        alert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult")) ;
        Assert.assertEquals(confirmResult.getText(),"You selected Cancel");
    }

    @Test(description = "Confirmation Alert Test  - OK")
    void confirmOKButtonTest(){
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Do you confirm action?");
        alert.accept();
        WebElement confirmResult = driver.findElement(By.id("confirmResult")) ;
        Assert.assertEquals(confirmResult.getText(),"You selected Ok");
    }

    @Test(description = "Prompt Alert Test", groups = "group1")
    void promptButton(){
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Please enter your name");
        final String message = "Test Prompt Alert";
        alert.sendKeys(message);
        alert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promptResult.getText(),"You entered "+message);

    }


    @AfterMethod
    void quitDriver(){

        driver.quit();
        testData.clear();
    }

    void sleep(int nanoSeconds){
        try {
            Thread.sleep(nanoSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
