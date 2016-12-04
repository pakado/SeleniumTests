package Browsers;

/**
 * @author pakadoa
 * @since 2016-12-04
 */
public class BrowsersFactory {

    public static Browsers getBrowserType(String browser){

        if(browser.equals("chrome")){
            return new ChromeBrowser();
        }
        else if(browser.equals("firefox")){
            return new FirefoxBrowser();
        }
        else if(browser.equals("ie11")){
            return new IE11Brwoser();
        }
        else{
            return null;
        }
    }
}
