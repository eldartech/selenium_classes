import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoQAFormSubmission {
    @Test
    void demoQACheckRequiredFields() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        for (int i=20;i>0;i--){
            actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
        }
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        List<WebElement> requiredFields = driver.findElements(By.cssSelector("input[required]"));
        Thread.sleep(5000);
        for (WebElement field: requiredFields){
            if (field.getAttribute("type").equals("radio")){
                Assert.assertEquals(field.getCssValue("color"),"rgb(220, 53, 69)");
            }else {
                System.out.println(field.getCssValue("color"));
                Assert.assertEquals(field.getCssValue("border-color"),"rgb(206, 212, 218)");

            }
        }


    }
}
