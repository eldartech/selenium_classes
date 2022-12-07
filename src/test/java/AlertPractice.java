import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AlertPractice {
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(description = "Sweet Alert Test - JavaScript Alert")
    void sweetAlertTest(){
        Reporter.log("Chrome session started");
        driver.get("https://sweetalert.js.org/");
        Reporter.log("Navigated to sweetalert.js.org");
        WebElement alertPreview = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        alertPreview.click();
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        final String expectedAlertMessage = "Oops, something went wrong!";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        alert.accept();
    }

    @Test(description = "Sweet Alert Test - HTML Alert")
    void sweetSwalAlertTest(){
        Reporter.log("Chrome session started");
        driver.get("https://sweetalert.js.org/");
        Reporter.log("Navigated to sweetalert.js.org");
        WebElement alertPreview = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        alertPreview.click();
        List<WebElement> texts = driver.findElements(By.xpath("//div[@class='swal-title' or @class='swal-text']"));
        String actualAlertMessage="";
        for (WebElement text : texts) {
            actualAlertMessage+=text.getText()+" ";
        }
        final String expectedAlertMessage = "Oops Something went wrong!";
        Assert.assertEquals(actualAlertMessage.trim(),expectedAlertMessage);
        driver.findElement(By.xpath("//div[@class='swal-modal']//button[contains(@class,'swal-button--confirm')]")).click();
    }
}
