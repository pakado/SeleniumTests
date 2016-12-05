package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by pkdo10 on 12/4/2016.
 */
public class IE11Brwoser implements Browsers {

    public WebDriver getWebDriver() {

        //For IE11
        /*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);*/
        System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
}
