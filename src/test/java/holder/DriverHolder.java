package holder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHolder implements ActionsForBrowser {
    final int WAITFORELEMENT = 15;

    public static final Logger logger = LogManager.getLogger(DriverHolder.class);
    protected WebDriver driver;

    public DriverHolder(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElementByXpath(String xpath){
        try {
            return (new WebDriverWait(driver, WAITFORELEMENT))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (NoSuchElementException noEl){
            logger.info("there is no element with xpath " + xpath);
            noEl.printStackTrace();
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElementByXpath(String xpath, int waitSeconds){
        return (new WebDriverWait(driver, waitSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getClickableElement(String xpath){
        try {
            return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (NoSuchElementException noE){
            logger.info("There is no clickable element with xpath " + xpath );
            noE.printStackTrace();
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getClickableElement(String xpath, int waitSeconds) {
        try {
            return new WebDriverWait(driver, waitSeconds).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (NoSuchElementException noE){
            logger.info("There is no clickable element with xpath " + xpath );
            noE.printStackTrace();
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isElementAbsent(String xpath) {
        try {
            if (driver.findElement(By.xpath(xpath)).isDisplayed()==true){
                return false;
            }else {
                return true;
            }
        } catch (NoSuchElementException noElem) {
            return true;
        }
    }

    public boolean isElementAbsentDuringTime(String xpath, int seconds) {
        for (int i = 0; i<seconds; i++){
            if (driver.findElements(By.xpath(xpath)).size()>0){

            }
        }
        return false;
    }

    @Override
    public boolean isElementExitsInDOM(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void waitForPageLoad() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Override
    public void sleepForMilesec(int miliSec) {
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sleepForSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
