package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author pakadoa
 * @since 2016-12-04
 */
public class ChromeBrowser implements Browsers {


    public WebDriver getWebDriver() {
        //For chrome
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
