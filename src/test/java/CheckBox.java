import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckBox {
    @Test
    void defaultCheckBoxSelectionTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        URL url = new URL("http://www.testdiary.com/training/selenium/selenium-test-page/");
        webDriver.navigate().to(url);
        Assert.assertTrue(webDriver.getTitle().contains("Selenium Test Page"));
        WebElement restAPICheckBox = webDriver.findElement(By.id("restapibox"));
        Assert.assertTrue(restAPICheckBox.isSelected(),"Rest API is not Checked");
        WebElement seleniumCheckBox = webDriver.findElement(By.cssSelector("#seleniumbox"));
        Assert.assertFalse(seleniumCheckBox.isSelected(),"Selenium is Checked");
        WebElement checkBoxRadioHeader = webDriver.findElement(By.xpath("//div[contains(text(),'Check Boxes')]"));
        Assert.assertTrue(checkBoxRadioHeader.isDisplayed(),"Check Boxes & Radio Buttons is not displayed.");
        webDriver.quit();
    }

    @Test
    void selectionOfSeleniumCheckBoxTest()  {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        Assert.assertTrue(webDriver.getTitle().contains("Selenium Test Page"),"Title is not matching.");
        WebElement checkBoxRadioHeader = webDriver.findElement(By.xpath("//div[contains(text(),'Check Boxes')]"));
        Assert.assertTrue(checkBoxRadioHeader.isDisplayed(),"Check Boxes & Radio Buttons is not displayed.");
        WebElement seleniumCheckBox = webDriver.findElement(By.cssSelector("#seleniumbox"));
        seleniumCheckBox.click();
        Assert.assertTrue(seleniumCheckBox.isSelected(),"Selenium is not Checked");
        WebElement restAPICheckBox = webDriver.findElement(By.id("restapibox"));
        Assert.assertTrue(restAPICheckBox.isSelected(),"Rest API is not Checked");
        webDriver.close();
    }

    @Test
    void selectionOfSeleniumDeselectingRestAPICheckBoxTest()  {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        Assert.assertTrue(webDriver.getTitle().contains("Selenium Test Page"),"Title is not matching.");
        WebElement checkBoxRadioHeader = webDriver.findElement(By.xpath("//div[contains(text(),'Check Boxes')]"));
        Assert.assertTrue(checkBoxRadioHeader.isDisplayed(),"Check Boxes & Radio Buttons is not displayed.");
        WebElement seleniumCheckBox = webDriver.findElement(By.cssSelector("#seleniumbox"));
        seleniumCheckBox.click();
        Assert.assertTrue(seleniumCheckBox.isSelected(),"Selenium is not Checked");
        WebElement restAPICheckBox = webDriver.findElement(By.id("restapibox"));
        restAPICheckBox.click();
        Assert.assertFalse(restAPICheckBox.isSelected(),"Rest API is Checked");
        webDriver.quit();
    }

    @Test
    void unselectingRestAPICheckBoxTest()  {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        Assert.assertTrue(webDriver.getTitle().contains("Selenium Test Page"),"Title is not matching.");
        WebElement checkBoxRadioHeader = webDriver.findElement(By.xpath("//div[contains(text(),'Check Boxes')]"));
        Assert.assertTrue(checkBoxRadioHeader.isDisplayed(),"Check Boxes & Radio Buttons is not displayed.");
        WebElement seleniumCheckBox = webDriver.findElement(By.cssSelector("#seleniumbox"));
        Assert.assertFalse(seleniumCheckBox.isSelected(),"Selenium is Checked");
        WebElement restAPICheckBox = webDriver.findElement(By.id("restapibox"));
        restAPICheckBox.click();
        Assert.assertFalse(restAPICheckBox.isSelected(),"Rest API is Checked");
        webDriver.quit();
    }
}
