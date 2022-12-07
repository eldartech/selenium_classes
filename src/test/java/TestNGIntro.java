import org.testng.annotations.Test;

public class TestNGIntro {

    @Test
    void positiveLogInTest(){
        System.out.println("test 003");
    }

    @Test
    void negativeLogInTest1(){
        System.out.println("test 004");
    }

    @Test
    void negativeLogInTest1(String value){
        System.out.println("test 004");
    }


    @Test
    void test002(){
        System.out.println("test 002");
    }

    @Test
    void test001(){
        System.out.println("test 001");
    }


}
