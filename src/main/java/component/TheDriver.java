package component;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TheDriver {
    private WebDriver webDriver;

    public TheDriver(@Value("${browser}") String browser) {

        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--headless=new");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                webDriver = WebDriverManager.firefoxdriver().clearDriverCache().capabilities(firefoxOptions).create();
                break;
            default:
                ChromeOptions chromeOptionsDef = new ChromeOptions();
//        chromeOptions.addArguments("--headless=new");
                chromeOptionsDef.addArguments("--start-maximized");
                chromeOptionsDef.setPageLoadStrategy(PageLoadStrategy.NONE);
                webDriver = WebDriverManager.chromedriver().clearDriverCache().capabilities(chromeOptionsDef).create();
                break;
        }

    }


    public WebDriver getDriver() {
        return webDriver;
    }


}