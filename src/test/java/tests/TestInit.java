package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInit {

    WebDriver driver;

    @Before
    public void setUp(){
        setupDriverExecutable();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    private void setupDriverExecutable(){
        if (System.getProperty("os.name").contains("Win")){
            System.setProperty("webdriver.chrome.driver", "src/chromedriver_win.exe");
            System.setProperty("webdriver.gecko.driver","src/geckodriver_win.exe");
        }else if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "chromedriver_mac");
            System.setProperty("webdriver.gecko.driver","geckodriver_mac");
        }
    }
}
