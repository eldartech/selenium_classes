import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Alert_HTML {
    @Test
    void formyAlertTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement openModalButton = driver.findElement(By.id("modal-button"));
        openModalButton.click();
        WebElement modalTitle = driver.findElement(By.xpath("//h5[contains(@class,'modal-title')]"));
        WebElement modalBody = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
        WebElement closeCross = driver.findElement(By.xpath("//button[contains(@class,'close')]"));
        List<WebElement> modalButtons = driver.findElements(By.xpath("//div[contains(@class,'modal-footer')]//button"));
        Assert.assertEquals(modalTitle.getText(),"Modal title");
        Assert.assertEquals(modalBody.getText(),"Some text here");
        Assert.assertTrue(closeCross.isEnabled());
        Assert.assertTrue(modalButtons.get(0).isEnabled());
        Assert.assertTrue(modalButtons.get(1).isEnabled());
//        modalButtons.stream().filter(e-> e.getText().equals("Close")).forEach(WebElement::click);
        closeCross.click();



    }
}
