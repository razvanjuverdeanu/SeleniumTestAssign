package pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {
    @Autowired
    BasePage basePage;

    private By loginBtn = By.xpath("//span[text()='Login']");
    private By rejectCookies = By.id("onetrust-reject-all-handler");

    public void openUrlLink(String url) throws InterruptedException {
        basePage.openUrl(url);
        Thread.sleep(7000);
    }

    public void pressOnLogin() {
        basePage.waitForElementToBeDisplayed(loginBtn);
        basePage.scrollToElement(loginBtn);
        basePage.clickElement(loginBtn);
    }

    public void switchToLoginTab(){
        basePage.switchToWindow("/auth");
    }

    public void closeCookies(){
//        try{

            basePage.waitForElementToBeDisplayed(rejectCookies);
            if(basePage.isElementDisplayed(rejectCookies)){
                basePage.clickElement(rejectCookies);
//            }

//        }catch (Exception e){
//            System.out.println("Cookies are not displayed");
        }
    }



}
