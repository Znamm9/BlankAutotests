package pageObjects;

import holder.DriverHolder;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends DriverHolder{

    public AbstractPage(WebDriver driver) {
        super(driver);
    }
}
