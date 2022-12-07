import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;

public class FileUpload {
   WebDriver driver;
    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Herokuapp file upload testing")
    void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        final String path = "/Users/techtorialacademy/IdeaProjects/selenium-testng/src/test/java/testResources/sample.txt";
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        WebElement header = driver.findElement(By.tagName("h3"));
        final String expectedHeader = "File Uploaded!";
        Assert.assertEquals(header.getText(),expectedHeader);
        WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(path.endsWith(uploadedFileName.getText()));
    }

    @Test
    void fileUploadGuru99Test() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        final String path = "/Users/techtorialacademy/IdeaProjects/selenium-testng/src/test/java/testResources/sample.txt";
        driver.findElement(By.id("uploadfile_0")).sendKeys(path);
        WebElement terms = driver.findElement(By.id("terms"));
        terms.click();
        driver.findElement(By.id("submitbutton")).click();
        WebElement actualMessage = driver.findElement(By.tagName("h3"));
        sleep(1000);
        Assert.assertEquals(actualMessage.getText(),"1 file\nhas been successfully uploaded.");
        Assert.assertTrue(terms.isSelected());

    }

    @Test(description = "File download test herokuapp")
    void fileDownloadTest(){
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> files = driver.findElements(By.xpath("//h3[text()='File Downloader']/following-sibling::a"));
        int fileNum = 2;
        files.get(fileNum).click();
        String expectedFileName = files.get(fileNum).getText();
        Assert.assertTrue(new FileUtils().isDownloaded(expectedFileName));
    }


}
