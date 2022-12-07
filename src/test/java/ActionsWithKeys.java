import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsWithKeys {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    void tearDown() {
      //  driver.quit();
    }
    @Test
    void keysTest(){
        WebElement target = driver.findElement(By.id("target"));
        actions.moveToElement(target).sendKeys(Keys.TAB).perform();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You entered: TAB");
    }


    @Test
    void keysDownTest(){
        driver.get("https://demoqa.com/text-box");
        WebElement target = driver.findElement(By.id("currentAddress"));
        target.sendKeys("currentAddress");
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("x").keyUp(Keys.COMMAND).perform();
        WebElement perAdd = driver.findElement(By.id("permanentAddress"));

        actions.click(perAdd).keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

    }
}
