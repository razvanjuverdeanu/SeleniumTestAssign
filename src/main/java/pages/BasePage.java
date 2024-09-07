package pages;

import component.TheDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.WaitUtils;

import java.time.Duration;
import java.util.Set;

@Component
public class BasePage {

    @Autowired
    TheDriver driver;

    @Autowired
    WaitUtils waitUtils;

    public void openUrl(String url) throws InterruptedException {
        driver.getDriver().get(url);
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitForElementToBeDisplayed(By locator) {

        waitUtils.waitUntilElementIsVisible(() -> driver.getDriver().findElement(locator).isDisplayed());
    }

    public boolean isElementDisplayed(By locator) {

        return driver.getDriver().findElement(locator).isDisplayed();
    }

    public void waitUntilTextIsVisible(By locator, String text) {

        waitUtils.waitUntilElementIsVisible(() -> driver.getDriver().findElement(locator).getText().equalsIgnoreCase(text));
    }

    public void clickElement(By locator) {
        waitForElementToBeDisplayed(locator);
        driver.getDriver().findElement(locator).click();
    }

    public void typeValueInTextBox(By locator, String text) {
        waitForElementToBeDisplayed(locator);
        driver.getDriver().findElement(locator).sendKeys(text);
    }

    public String getElementText(By locator) {
        waitForElementToBeDisplayed(locator);
        return driver.getDriver().findElement(locator).getText();
    }

    public void selectDropDownValue(By locator, String value) {
        waitForElementToBeDisplayed(locator);
        Select select = new Select(driver.getDriver().findElement(locator));
        select.selectByValue(value);
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", driver.getDriver().findElement(locator));
    }

    public String getCurrentWindow(){
        return driver.getDriver().getWindowHandle();
    }

    public void switchToWindow(String partialLink){
        Set<String> windows =  driver.getDriver().getWindowHandles();
        for(String url: windows){
            driver.getDriver().switchTo().window(url);
            if (driver.getDriver().getCurrentUrl().contains(partialLink)){
                break;
            }

        }
    }
}