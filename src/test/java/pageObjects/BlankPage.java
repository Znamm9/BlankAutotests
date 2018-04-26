package pageObjects;

import org.openqa.selenium.WebDriver;

public class BlankPage extends AbstractPage{

    public BlankPage(WebDriver driver) {
        super(driver);
    }

    public void goToGoogle(){
        driver.get("https://google.com");
    }
}
