import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    @Test(groups = "group1")
    void test4() {
        System.out.println("test 4 body");
    }

    @Test(groups = "group1")
    void test2() {
        System.out.println("test 2 body");
    }


    @Test
    void test3() {
        System.out.println("test 3 body");
    }

    @Test
    void test1() {
        System.out.println("test 1 body");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before method body");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After method body");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("before class body");
    }

    @AfterClass
    void afterClass() {
        System.out.println("after class body");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("before test body");
    }

    @AfterTest
    void afterTest() {
        System.out.println("after test body");
    }

    @BeforeGroups("group1")
    void beforeGroups(){
        System.out.println("before groups body");
    }

    @AfterGroups("group1")
    void afterGroups(){
        System.out.println("after groups body");
    }

    @BeforeSuite
    void  beforeSuite(){
        System.out.println("before suite body");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after suite body");
    }

}
