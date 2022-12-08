import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSUtils {

    public static void jsNavigate(String url, WebDriver driver){
        //navigates to URL alternative to get() or navigate().to()
        ((JavascriptExecutor) driver).executeScript("window.location = '"+url+"'");
    }
}
