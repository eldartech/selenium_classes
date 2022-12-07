import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectClass {
    @Test
    void selectShirtByVisibleTextTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement shirtsSelect = driver.findElement(By.id("Shirts"));
        Select selectShirt = new Select(shirtsSelect);
        final String defaultShirt = "Blue Shirt";
        Assert.assertEquals(defaultShirt,selectShirt.getFirstSelectedOption().getText());
        final String yellowShirt = "Yellow Shirt";
        selectShirt.selectByVisibleText(yellowShirt);
        Assert.assertEquals(yellowShirt,selectShirt.getFirstSelectedOption().getText());
        selectShirt.selectByVisibleText(yellowShirt);
        final String redShirt = "Red Shirt";
        selectShirt.selectByVisibleText(redShirt);
        Assert.assertEquals(redShirt,selectShirt.getFirstSelectedOption().getText());
    }

    @Test
    void selectSkirtByIndexTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement skirtsSelect = driver.findElement(By.id("Skirts"));
        Select selectSkirt = new Select(skirtsSelect);
        final String defaultSkirt = "Blue Skirt";
        Assert.assertEquals(defaultSkirt,selectSkirt.getFirstSelectedOption().getText());
        final String yellowSkirt = "Yellow Skirt";
        selectSkirt.selectByIndex(2);
        Assert.assertEquals(yellowSkirt,selectSkirt.getFirstSelectedOption().getText());
        selectSkirt.selectByIndex(1);
        final String redSkirt = "Red Skirt";
        Assert.assertEquals(redSkirt,selectSkirt.getFirstSelectedOption().getText());
    }


    @Test
    void selectCountryByValueTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorialacademy/Desktop/techtorialApp/TechtorialApp.html");
        WebElement country = driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        final String defaultSelection = "select country";
        Assert.assertEquals(defaultSelection,countrySelect.getFirstSelectedOption().getText());
        countrySelect.selectByValue("ZW");
        final String expectedSelection = "Zimbabwe";
        Assert.assertEquals(expectedSelection,countrySelect.getFirstSelectedOption().getText());
        List<WebElement> allOptions =  countrySelect.getOptions();
        Set<String> expectedOption = new HashSet<>();
        for (WebElement option: allOptions){
            expectedOption.add(option.getText());
        }
        Assert.assertEquals(allOptions.size(),expectedOption.size());

    }



}
