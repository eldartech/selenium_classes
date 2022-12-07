import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClicks {
    WebDriver driver;
    Actions actions;

    @Test
    void doubleClickTest() throws InterruptedException {
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.moveToElement(doubleClickBtn).doubleClick().perform();
        Thread.sleep(2000);
        //line 18 is a alternative way for line 20
//        actions.doubleClick(doubleClickBtn).perform();
        final  String expectedMessage = "You have done a double click";
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertEquals(expectedMessage,doubleClickMessage.getText());
    }

    @Test
    void rightClickTest() throws InterruptedException {
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
         actions.moveToElement(rightClickBtn).contextClick().perform();
        Thread.sleep(2000);
        //line 28 is a alternative way for line 30
//        actions.contextClick(rightClickBtn).perform();
        final  String expectedMessage = "You have done a right click";
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals(expectedMessage,rightClickMessage.getText());
    }

    @Test
    void dynamicClickTest() {
        WebElement clickBtn = driver.findElement(By.id("tU2Lq"));
        // actions.moveToElement(clickBtn).click().perform();
        //line 40 is a alternative way for line 42
        actions.click(clickBtn).perform();
        final  String expectedMessage = "You have done a dynamic click";
        WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(expectedMessage,clickMessage.getText());

    }

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
