package junit;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeEach
    void beforEach(){
        System.out.println("        This method @BeforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("        This method @AfterEach");
    }
    @Test
    void firstTest(){
        System.out.println("        This is Test");
        Assertions.assertTrue(3>2);

    }
    @Test
    void secondTest() {
        System.out.println("            This is secondTest()");
        Assertions.assertTrue(3 > 2);
    }
}
