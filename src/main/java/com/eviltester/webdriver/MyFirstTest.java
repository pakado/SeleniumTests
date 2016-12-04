package com.eviltester.webdriver;
import Browsers.Browsers;
import Browsers.BrowsersFactory;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by pkdo10 on 11/17/2016.
 */
public class MyFirstTest {

    @Test
    public void startApp(){
        Random random = new Random();
        ArrayList<String> browsers = new ArrayList<String>();
        browsers.add("firefox");
        browsers.add("chrome");

        int index = random.nextInt(browsers.size());
        Browsers browser = BrowsersFactory.getBrowserType(browsers.get(index));
        WebDriver driver = browser.getWebDriver();

        driver.navigate().to("https://www.youtube.com");
        waitFor(2000);
        Assert.assertEquals("https://www.youtube.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\'masthead-search-term\']")).sendKeys("selenium");
        waitFor(2000);
        driver.findElement(By.xpath("//*[@id=\'search-btn\']/span")).click();
        waitFor(5000);
        Assert.assertEquals("https://www.youtube.com/results?search_query=selenium",driver.getCurrentUrl());

        driver.close();
        driver.quit();
    }

    public void waitFor(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
