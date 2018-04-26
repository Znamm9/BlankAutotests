package tests;

import org.junit.Test;
import pageObjects.BlankPage;

public class TestExample extends TestInit {

    @Test
    public void testRun(){
        BlankPage home = new BlankPage(driver);
        home.goToGoogle();
    }
}