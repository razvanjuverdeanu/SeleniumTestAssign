package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @Autowired
    HomePage homePage;


    @Given("I Open Basler Kantonalbank main page")
    public void openBkb() throws InterruptedException {
        homePage.openUrlLink("https://www.bkb.ch/de");
        homePage.closeCookies();

    }

    @When("I press login page")
    public void iSearchFor() {
        homePage.pressOnLogin();
        homePage.switchToLoginTab();
    }

    @When("I enter username {string}")
    public void setUser(String user) {
        loginPage.setUsername(user);
    }

    @When("I enter password {string}")
    public void setPass(String pass) {
        loginPage.setPassword(pass);
    }

    @When("I click on login button")
    public void clickLoginButton(){
        loginPage.pressLoginButton();
    }

    @When("I receive an error which contains {string}")
    public void checkError(String text){

        String alertMessage = loginPage.getAlertText();
        System.out.println("msg: " + alertMessage);
        assertTrue("Alert message doesn't contain expected text", alertMessage.contains(text));
    }
}
