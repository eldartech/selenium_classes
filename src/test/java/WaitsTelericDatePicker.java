import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.concurrent.TimeUnit;

public class WaitsTelericDatePicker {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    void datePickerTest(){
        wait = new WebDriverWait(driver,10);
        int pickedDay = 15;
        selectDay(pickedDay).click();
        WebElement dateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceholder1_Label1")));
       // Assert.assertTrue(dateLabel.getText().contains(Integer.toString(pickedDay)));
        Assert.assertEquals(dateLabel.getText(),getExpectedDate(pickedDay));


    }

    WebElement selectDay(int day){
        return driver.findElement(By.xpath("//a[text()='"+day+"']"));
    }

    String getExpectedDate(int day){
        LocalDate currentDate = LocalDate.now();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();
        DayOfWeek dayOfWeek = LocalDate.of(year,month,day).getDayOfWeek();
        //Thursday, December 15, 2022
        return String.format("%s, %s %d, %d",dayOfWeek,month,day,year);


    }
}
