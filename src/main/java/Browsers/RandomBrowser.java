package Browsers;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pkdo10 on 12/4/2016.
 */
public abstract class RandomBrowser {

   private static String browser;
   public static WebDriver getBrowser(){
       Random random = new Random();
       ArrayList<String> browsers = new ArrayList<String>();
       browsers.add("firefox");
       browsers.add("chrome");
       browsers.add("ie11");

       int index = random.nextInt(browsers.size());
       browser = browsers.get(index);
       Browsers browser = BrowsersFactory.getBrowserType(browsers.get(index));
       WebDriver driver = browser.getWebDriver();
       return driver;
   }

   public static String getBrowserType() {
        return browser;
   }
}
