import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tutorialShut {
    WebDriver driver;

    @BeforeMethod
    void setDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    void reply(){
        JavascriptExecutor js = (JavascriptExecutor) driver;



    }
}
