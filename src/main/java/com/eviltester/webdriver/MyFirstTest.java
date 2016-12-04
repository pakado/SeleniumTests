package com.eviltester.webdriver;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pkdo10 on 11/17/2016.
 */
public class MyFirstTest {

    @Test
    public void startApp(){
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver1 = new ChromeDriver();

        driver.navigate().to("https://www.youtube.com");
        waitFor(2000);
        Assert.assertEquals("https://www.youtube.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\'masthead-search-term\']")).sendKeys("selenium");
        waitFor(2000);
        driver.findElement(By.xpath("//*[@id=\'search-btn\']/span")).click();
        waitFor(15000);
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
