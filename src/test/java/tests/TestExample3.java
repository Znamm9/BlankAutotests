package tests;

import org.testng.annotations.Test;

public class TestExample3 extends TestInit{

    @Test
    public void exemple(){
        for (int a = 0; a<40; a++){
            wait(1);
            System.out.println("test 3");
        }
    }
}
