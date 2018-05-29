package tests;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TestInit {

    public static final Logger logger = LogManager.getLogger(TestInit.class);
    private String directoryForScreenshots = "target/failureScreenshots";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        setupDriverExecutable();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    private void setupDriverExecutable(){
//        Mac
        if (System.getProperty("os.name").contains("Win")){
            System.setProperty("webdriver.chrome.driver", "src/chromedriver_win.exe");
            System.setProperty("webdriver.gecko.driver","src/geckodriver_win.exe");
//        Windows
        }else if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "chromedriver_mac");
            System.setProperty("webdriver.gecko.driver","geckodriver_mac");
//        Linux
        }else {

        }
    }

    private void closeChromeDriverProcesses() {
        try {
            java.lang.Runtime rt = java.lang.Runtime.getRuntime();
            java.lang.Process p = rt.exec("kill -9 $(ps aux | grep -e chromedriver | awk '{ print $2 }')");
            p.waitFor();
            System.out.println("Process exited with code = " + p.exitValue());
        } catch (Exception e) {
            logger.info(e);
        }
    }

    public void takeScreenshot(String name){
        String baseFileName = name;
        StringBuilder fileName = new StringBuilder(baseFileName);
        fileName.append(".png");
        File file = new File(directoryForScreenshots, fileName.toString());
        try {
            file.getCanonicalFile().getParentFile().mkdirs();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
