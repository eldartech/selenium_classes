import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelerikChooseDateTestWait {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    void pickADateTest(){
        wait = new WebDriverWait(driver,15);
        int pickedDay = 15;
        selectDay(pickedDay).click();
        WebElement dateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceholder1_Label1")));
        Assert.assertTrue(dateLabel.getText().contains(Integer.toString(pickedDay)));
    }
    WebElement selectDay(int day){
        return driver.findElement(By.xpath("//a[text()='"+day+"']"));

    }
}
