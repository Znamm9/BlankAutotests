package tests;

import org.testng.annotations.Test;
import pageObjects.BlankPage;

public class TestExample extends TestInit {

    @Test
    public void testRun(){
        for (int a = 0; a<40; a++){
            wait(1);
            System.out.println("test 1");
        }
    }
}