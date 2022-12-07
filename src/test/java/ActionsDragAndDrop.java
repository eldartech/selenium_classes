import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsDragAndDrop {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void simpleDragAndDropTest(){
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
//        actions.dragAndDrop(sourceElement,targetElement).perform();
        Point targetLocation = targetElement.getLocation();
//       actions.dragAndDropBy(sourceElement, targetLocation.getX(), targetLocation.getY()).perform();
//        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().perform();
//        actions.clickAndHold(sourceElement).moveByOffset(targetLocation.getX(), targetLocation.getY()).release().perform();
        actions.clickAndHold(sourceElement).release(targetElement).perform();
        Assert.assertEquals(targetElement.getCssValue("background-color"),"rgba(70, 130, 180, 1)");
        WebElement dropMessage = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']/p"));
        final String expectedMessage = "Dropped!";
        Assert.assertEquals(expectedMessage,dropMessage.getText());
    }
}
