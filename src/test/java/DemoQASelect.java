import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoQASelect {

    @Test
    void demoQANotSelectDropDown(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        WebElement selectValue = driver.findElement(By.xpath("//div[text()='Select Option']"));
        selectValue.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).build().perform();
//List<WebElement> options = driver.findElements(By.xpath("//*[@id='withOptGroup']/div[2]//*"));
//        System.out.println(options);
//options.get(2).click();
    }

    @Test
    void demoQASelectDropDown(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        WebElement selectValue = driver.findElement(By.id("oldSelectMenu"));
        Select colorSelect = new Select(selectValue);
        List<WebElement>  colorOptions = colorSelect.getOptions();
        List<String> actualOptions = getElementsText(colorOptions);

        List<String> expectedColorOptions = Arrays.asList("Red",
                "Blue",
                "Green",
                "Yellow",
                "Purple",
                "Black",
                "White",
                "Voilet",
                "Indigo",
                "Magenta",
                "Aqua");
        final  String defaultValue = "Red";
        Assert.assertEquals(defaultValue,colorSelect.getFirstSelectedOption());
        Assert.assertEquals(1,colorSelect.getAllSelectedOptions().size());

        //by index
        colorSelect.selectByIndex(3);
        Assert.assertEquals("Yellow",colorSelect.getFirstSelectedOption());

        //by value
        colorSelect.selectByValue("6");
        Assert.assertEquals("White",colorSelect.getFirstSelectedOption());

        //by visible text
        colorSelect.selectByVisibleText("Purple");
        Assert.assertEquals("Purple",colorSelect.getFirstSelectedOption());
        Assert.assertFalse(colorSelect.isMultiple());
        Assert.assertEquals(expectedColorOptions,actualOptions);



        driver.close();
    }


    @Test
    void demoQAMultipleSelectDropDown() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement cars = driver.findElement(By.id("cars"));

        Select carSelect = new Select(cars);
        Assert.assertEquals(0,carSelect.getAllSelectedOptions().size());
        Assert.assertTrue(getElementsText(carSelect.getAllSelectedOptions()).isEmpty());
        if (carSelect.isMultiple()){
            carSelect.selectByIndex(0);
            carSelect.selectByValue("opel");
            carSelect.selectByVisibleText("Audi");
            Assert.assertTrue(carSelect.getAllSelectedOptions().size()>0);
            List<String> expectedCars = Arrays.asList("Volvo", "Opel", "Audi");
            Assert.assertEquals(expectedCars,getElementsText(carSelect.getAllSelectedOptions()));
        }



    }


    @Test
    void demoQADeselectDropDown() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement cars = driver.findElement(By.id("cars"));

        Select carSelect = new Select(cars);
        Assert.assertEquals(0,carSelect.getAllSelectedOptions().size());
        Assert.assertTrue(getElementsText(carSelect.getAllSelectedOptions()).isEmpty());
        if (carSelect.isMultiple()){
            carSelect.selectByIndex(0);
            carSelect.selectByValue("opel");
            carSelect.selectByVisibleText("Audi");
            Assert.assertTrue(carSelect.getAllSelectedOptions().size()>0);
            List<String> expectedCars = Arrays.asList("Volvo", "Opel", "Audi");
            Assert.assertEquals(expectedCars,getElementsText(carSelect.getAllSelectedOptions()));
        }
        carSelect.deselectByIndex(0);
        Assert.assertEquals(Arrays.asList( "Opel", "Audi"),getElementsText(carSelect.getAllSelectedOptions()));
        carSelect.deselectByValue("audi");
        Assert.assertEquals(Arrays.asList( "Opel"),getElementsText(carSelect.getAllSelectedOptions()));
        carSelect.deselectByVisibleText("Opel");
        Assert.assertTrue(getElementsText(carSelect.getAllSelectedOptions()).isEmpty());



    }


    @Test
    void demoQADeselectAllDropDown() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement cars = driver.findElement(By.id("cars"));

        Select carSelect = new Select(cars);
        for (WebElement option:carSelect.getOptions()){
            carSelect.selectByValue(option.getAttribute("value"));
        }
        List<String> expectedCars = Arrays.asList("Volvo","Saab", "Opel", "Audi");
        Assert.assertEquals(expectedCars,getElementsText(carSelect.getAllSelectedOptions()));
        carSelect.deselectAll();
        Assert.assertTrue(getElementsText(carSelect.getAllSelectedOptions()).isEmpty());


    }

    @Test
    void demoQAMultiSelectDropDown() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement colors = driver.findElement(By.xpath("//b[contains(text(),'Multiselect')]/ancestor::p/following-sibling::div"));
        colors.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'qy-menu')]/div/*"));

        options.get(3).click();


    }


    public List<String> getElementsText(List<WebElement> elements){
        List<String> result = new ArrayList<>();
        for(int i=0;i<elements.size();i++){
            result.add(elements.get(i).getText());
        }


        return result;
    }


}
