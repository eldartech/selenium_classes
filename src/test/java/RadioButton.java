import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {
    @Test
    void defaultViewForRadioButtonTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        WebElement javaRadio = webDriver.findElement(By.cssSelector("#java1"));
        WebElement phpRadio = webDriver.findElement(By.cssSelector("input[id='php1'][type='radio']"));
        Assert.assertFalse(javaRadio.isSelected(),"Java Radio Button is selected.");
        Assert.assertFalse(phpRadio.isSelected(),"PHP Radio Button is selected.");
        WebElement saveButton = webDriver.findElement(By.cssSelector("button[id='demo']"));
        Assert.assertTrue(saveButton.isDisplayed(),"Save button is not displayed.");
        webDriver.quit();
    }

    @Test
    void javaRadioButtonTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        WebElement javaRadio = webDriver.findElement(By.cssSelector("#java1"));
        javaRadio.click();
        WebElement phpRadio = webDriver.findElement(By.cssSelector("input[id='php1'][type='radio']"));
        Assert.assertTrue(javaRadio.isSelected(),"Java Radio Button is not selected.");
        Assert.assertFalse(phpRadio.isSelected(),"PHP Radio Button is selected.");
        WebElement saveButton = webDriver.findElement(By.cssSelector("button[id='demo']"));
        Assert.assertTrue(saveButton.isDisplayed(),"Save button is not displayed.");
        webDriver.quit();
    }

    @Test
    void phpRadioButtonTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        WebElement javaRadio = webDriver.findElement(By.cssSelector("#java1"));
        WebElement phpRadio = webDriver.findElement(By.cssSelector("input[id='php1'][type='radio']"));
        phpRadio.click();
        Assert.assertFalse(javaRadio.isSelected(),"Java Radio Button is selected.");
        Assert.assertTrue(phpRadio.isSelected(),"PHP Radio Button is not selected.");
        WebElement saveButton = webDriver.findElement(By.cssSelector("button[id='demo']"));
        Assert.assertTrue(saveButton.isDisplayed(),"Save button is not displayed.");
        webDriver.quit();
    }

    @Test
    void phpAndJavaRadioButtonTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        webDriver.navigate().to(url);
        WebElement javaRadio = webDriver.findElement(By.cssSelector("#java1"));
        WebElement phpRadio = webDriver.findElement(By.cssSelector("input[id='php1'][type='radio']"));
        javaRadio.click();
        Assert.assertTrue(javaRadio.isSelected(),"Java Radio Button is not selected.");
        Assert.assertFalse(phpRadio.isSelected(),"PHP Radio Button is selected.");
        phpRadio.click();
        Assert.assertFalse(javaRadio.isSelected(),"Java Radio Button is selected.");
        Assert.assertTrue(phpRadio.isSelected(),"PHP Radio Button is not selected.");
        WebElement saveButton = webDriver.findElement(By.cssSelector("button[id='demo']"));
        Assert.assertTrue(saveButton.isDisplayed(),"Save button is not displayed.");
        Assert.assertFalse(saveButton.isEnabled(), "Save button is enabled");
        webDriver.quit();
    }
}
