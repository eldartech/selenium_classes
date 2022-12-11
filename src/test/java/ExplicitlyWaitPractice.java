import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitlyWaitPractice {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        wait = new WebDriverWait(driver,6);
    }
   @Test


}
