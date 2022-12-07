import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPractice {
    @Test
    void defaultViewTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "https://demoqa.com/radio-button";
        webDriver.navigate().to(url);
        WebElement yesRadio = webDriver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = webDriver.findElement(By.cssSelector("#impressiveRadio"));
        WebElement noRadio = webDriver.findElement(By.xpath("//input[@id='noRadio']"));
        Assert.assertFalse(yesRadio.isSelected(),"Yes Radio button is selected");
        Assert.assertFalse(impressiveRadio.isSelected(),"Impressive Radio button is selected");
        Assert.assertFalse(noRadio.isEnabled(),"No Radio button is enabled");
        WebElement noRadioLabel = webDriver.findElement(By.cssSelector("label[for='noRadio']"));
        Assert.assertTrue(noRadioLabel.getAttribute("class").endsWith("disabled"),"No Radio button is enabled.");
        webDriver.quit();
    }


    @Test
    void yesRadioSelectionTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "https://demoqa.com/radio-button";
        webDriver.navigate().to(url);
        WebElement yesRadio = webDriver.findElement(By.xpath("//label[text()='Yes']"));
        WebElement impressiveRadio = webDriver.findElement(By.cssSelector("#impressiveRadio"));
        WebElement noRadio = webDriver.findElement(By.xpath("//input[@id='noRadio']"));
        yesRadio.click();
        Thread.sleep(2000);
        WebElement successText = webDriver.findElement(By.className("text-success"));
        Assert.assertEquals("Yes",successText.getText(),"'Yes' Radio button is not selected");
        Assert.assertEquals("rgba(40, 167, 69, 1)",successText.getCssValue("color"),"Success text color is not GREEN.");
        Assert.assertFalse(impressiveRadio.isSelected(),"Impressive Radio button is selected");
        Assert.assertFalse(noRadio.isEnabled(),"No Radio button is enabled");
        WebElement noRadioLabel = webDriver.findElement(By.cssSelector("label[for='noRadio']"));
        Assert.assertTrue(noRadioLabel.getAttribute("class").endsWith("disabled"),"No Radio button is enabled.");
        webDriver.quit();
    }

    @Test
    void impressiveRadioSelectionTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String url = "https://demoqa.com/radio-button";
        webDriver.get(url);
        WebElement yesRadio = webDriver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = webDriver.findElement(By.xpath("//label[text()='Impressive']"));
        WebElement noRadio = webDriver.findElement(By.xpath("//input[@id='noRadio']"));
        impressiveRadio.click();
        WebElement successText = webDriver.findElement(By.className("text-success"));
        Assert.assertEquals("Impressive",successText.getText(),"'Impressive' Radio button is not selected");
        Assert.assertEquals("rgba(40, 167, 69, 1)",successText.getCssValue("color"),"Success text color is not GREEN.");
        Assert.assertFalse(yesRadio.isSelected(),"Yes Radio button is selected" );
        Assert.assertFalse(noRadio.isEnabled(),"No Radio button is enabled");
        WebElement noRadioLabel = webDriver.findElement(By.cssSelector("label[for='noRadio']"));
        Assert.assertTrue(noRadioLabel.getAttribute("class").endsWith("disabled"),"No Radio button is enabled.");
        webDriver.quit();
    }
}
