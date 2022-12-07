import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PracticeIframeWindowHandle {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");
    }

    @Test(description = "Window Handle Testing for Pavilion.")
    void pavilionTest() {
        WebElement pavilion = driver.findElement(By.xpath("//a[text() = 'Pavilion']"));
        pavilion.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        driver.close();
        driver.switchTo().window(mainID);
        Assert.assertTrue(pavilion.isDisplayed());
    }

    @Test
    void bloggerTest() {
        WebElement blogger = driver.findElement(By.xpath("//a[text() = 'Blogger']"));
        blogger.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        WebElement aboutMe = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(aboutMe.getText(),"About me");
        driver.close();
        driver.switchTo().window(mainID);
        Assert.assertTrue(blogger.isDisplayed());

    }

    @Test(description = "Category 1 test for iframe and window handle")
    void category1_Test() {
        driver.switchTo().frame("Framename1");
        WebElement category1 = driver.findElement(By.xpath("//a[text() = 'Category1']"));
        List<WebElement> allTexts = driver.findElements(By.xpath("//body//*[text()]"));
        List<String>  expectedFrame1Texts = Arrays.asList("Category1", "I am inside Frame", "Category2");
        Assert.assertEquals(getTexts(allTexts),expectedFrame1Texts);
        category1.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        List<WebElement> primaryMenu = driver.findElements(By.xpath("//ul[@id='primary-menu']//span[@class='menu-text']"));
        List<String> expectedPrimaryMenuTexts = Arrays.asList("HOME", "Selenium", "Appium", "WebdriverIO", "JavaForQA", "More", "Training");
        Assert.assertEquals(getTexts(primaryMenu), expectedPrimaryMenuTexts);
    }

    @Test
    void category2_Test() {
        driver.switchTo().frame("Framename1");
        WebElement category2 = driver.findElement(By.xpath("//a[text() = 'Category2']"));
        List<WebElement> allTexts = driver.findElements(By.xpath("//body//*[text()]"));
        List<String>  expectedFrame1Texts = Arrays.asList("Category1", "I am inside Frame", "Category2");
        Assert.assertEquals(getTexts(allTexts),expectedFrame1Texts);
        category2.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        List<WebElement> primaryMenu = driver.findElements(By.xpath("//ul[@id='primary-menu']//span[@class='menu-text']"));
        List<String> expectedPrimaryMenuTexts = Arrays.asList("HOME", "Selenium", "Appium", "WebdriverIO", "JavaForQA", "More", "Training");
        Assert.assertEquals(getTexts(primaryMenu), expectedPrimaryMenuTexts);

    }

    @Test(description = "Category 3 window and iframe testing")
    void category3_Test() {

        driver.switchTo().frame(1);
        WebElement category3 = driver.findElement(By.xpath("//a[text() = 'Category3']"));
        List<WebElement> allTexts = driver.findElements(By.xpath("//body//*[text()]"));
        List<String>  expectedFrame1Texts = Arrays.asList("Category1", "I am inside Frame", "Category2");
        Assert.assertEquals(getTexts(allTexts),expectedFrame1Texts);
        category3.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        List<WebElement> primaryMenu = driver.findElements(By.xpath("//ul[@id='primary-menu']//span[@class='menu-text']"));
        List<String> expectedPrimaryMenuTexts = Arrays.asList("HOME", "Selenium", "Appium", "WebdriverIO", "JavaForQA", "More", "Training");
        Assert.assertEquals(getTexts(primaryMenu), expectedPrimaryMenuTexts);

    }

    @Test
    void skpatroHyperLinksTest(){
        WebElement pavilion = driver.findElement(By.xpath("//a[text() = 'Pavilion']"));
        pavilion.click();
        String mainID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!mainID.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> menuTexts = driver.findElements(By.xpath("//div[@class='left-widgets mini-widgets']//span[@class='menu-text']"));
        List<String> expectedMenuTexts = Arrays.asList("Contact me", "About me", "Demo", "DemoForm", "TechStuff");
        Assert.assertEquals(getTexts(menuTexts), expectedMenuTexts);
        driver.close();
        driver.switchTo().window(mainID);
        WebElement blogger = driver.findElement(By.xpath("//a[text() = 'Blogger']"));
        blogger.click();
        String mainID2 = driver.getWindowHandle();
        Set<String> ids2 = driver.getWindowHandles();
        for (String id : ids2) {
            if (!mainID2.equals(id))
                driver.switchTo().window(id);
        }
        WebElement aboutMe = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(aboutMe.getText(),"About me");
        driver.close();
        driver.switchTo().window(mainID2);
        driver.switchTo().frame("Framename1");
        WebElement category1 = driver.findElement(By.xpath("//a[text() = 'Category1']"));
        List<WebElement> allTexts = driver.findElements(By.xpath("//body//*[text()]"));
        List<String>  expectedFrame1Texts = Arrays.asList("Category1", "I am inside Frame", "Category2");
        Assert.assertEquals(getTexts(allTexts),expectedFrame1Texts);
        category1.click();
        String mainID3 = driver.getWindowHandle();
        Set<String> ids3 = driver.getWindowHandles();
        for (String id : ids3) {
            if (!mainID3.equals(id))
                driver.switchTo().window(id);
        }
        List<WebElement> primaryMenu = driver.findElements(By.xpath("//ul[@id='primary-menu']//span[@class='menu-text']"));
        List<String> expectedPrimaryMenuTexts = Arrays.asList("HOME", "Selenium", "Appium", "WebdriverIO", "JavaForQA", "More", "Training");
        Assert.assertEquals(getTexts(primaryMenu), expectedPrimaryMenuTexts);
        driver.close();
        driver.switchTo().window(mainID3);

    }

    List<String> getTexts(List<WebElement> elements) {
        List<String> result = new LinkedList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()){
                result.add(element.getText());
            }

        }
        return result;
    }


    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
