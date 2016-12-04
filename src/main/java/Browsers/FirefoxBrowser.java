package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author pakadoa
 * @since 2016-12-04
 */
public class FirefoxBrowser implements Browsers {

    public WebDriver getWebDriver() {

        //For Firefox
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
