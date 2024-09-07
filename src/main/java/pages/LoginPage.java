package pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @Autowired
    BasePage basePage;

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginButton");
    private By alert = By.id("alertText");

    public void setUsername(String user) {
        basePage.waitForElementToBeDisplayed(username);
        basePage.typeValueInTextBox(username, user);
    }

    public void setPassword(String pass) {
        basePage.waitForElementToBeDisplayed(password);
        basePage.typeValueInTextBox(password, pass);
    }

    public void pressLoginButton() {
        basePage.waitForElementToBeDisplayed(loginButton);
        basePage.clickElement(loginButton);
    }

    public String getAlertText() {
        basePage.waitForElementToBeDisplayed(alert);
        return basePage.getElementText(alert);
    }
}
