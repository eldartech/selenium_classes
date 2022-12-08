import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorIntro {
    WebDriver driver;
    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    void jsNavigateTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //navigates to URL alternative to get() or navigate().to()
        js.executeScript("window.location = 'https://amazon.com/'");
        // Fetching the URL of the site. Tostring() change object to name | alternative to getCurrentURL()
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = "+url);
        // Fetching the Domain Name of the site. Tostring() change object to name.
        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site = "+domainName);
        // Method document.title fetch the Title name of the site. Tostring() change object to name
        //alternative to getTitle()
        String titleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = "+titleName);
        // To generate Alert window using JavascriptExecutor. Display the alert message
       // js.executeScript("alert('Welcome to Alert From JS');");

        WebElement emailIDSearch = driver.findElement(By.id("twotabsearchtextbox"));
        //Highlighting the element
        String script = "arguments[0].style.border='2px solid red'";
        js.executeScript(script,emailIDSearch);

        // Perform Click | alternative to click()
        js.executeScript("arguments[0].click();",emailIDSearch);
        // To type Text in Selenium WebDriver without using sendKeys() method
        // alternative to sendKeys()
        //js.executeScript("arguments[0].value='hi techtorial'", emailIDSearch);
        js.executeScript("document.getElementById('twotabsearchtextbox').value='techtorial';");
        driver.findElement(By.xpath("//a[text()='Epic Deals']")).click();
        //WebElement deals = driver.findElement(By.id("swm-link"));
        // to get the text out of web element
		// String dealsText = (String) js.executeScript("return arguments[0].value", deals);
       // System.out.println(dealsText);
//		 js.executeScript("return document.getElementById('valueOfID').value");
        String sText =  js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(sText);
        //wait for 1000 nano seconds alternative to Thread.sleep()
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        // To scroll till the bottom of the page
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        js.executeScript("arguments[0].scrollIntoView(true);",logo);

    }
}
