package holder;

import org.openqa.selenium.WebElement;

public interface ActionsForBrowser {

    WebElement getElementByXpath(String xpath);

    WebElement getElementByXpath(String xpath, int waitSeconds);

    WebElement getClickableElement(String xpath);

    WebElement getClickableElement(String xpath, int waitSeconds);

    boolean isElementAbsent(String xpath);

    boolean isElementAbsentDuringTime(String xpath, int seconds);

    boolean isElementExitsInDOM(String xpath);

    void waitForPageLoad();

    void sleepForMilesec(int miliSec);

    void sleepForSec(int sec);
}
