package tests;

import org.testng.annotations.Test;

public class TestExample2 extends TestInit {

    @Test
    public void testExample(){
        for (int a = 0; a<40; a++){
            wait(1);
            System.out.println("test 2");
        }
    }
}
