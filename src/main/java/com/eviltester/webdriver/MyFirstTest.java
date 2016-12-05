package com.eviltester.webdriver;
import Browsers.Browsers;
import Browsers.RandomBrwoser;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by pkdo10 on 11/17/2016.
 */
public class MyFirstTest {

    @Test
    public void startApp(){

        WebDriver driver = RandomBrwoser.getBrowser();
        waitFor(2000);

        driver.get("https://utest.aternity.com");
        Assert.assertEquals("https://utest.aternity.com/login/", driver.getCurrentUrl());
        waitFor(2000);

        if(true){
            driver.findElement(By.xpath(("//div[@ng-click='loginCtrl.unsupportedBrowser=false']"))).click();
        }
        driver.findElement(By.xpath("//*[@ng-model='loginCtrl.username']")).sendKeys("pakado.abera@aternity.com");
        waitFor(2000);
        driver.findElement(By.xpath("//*[@ng-model='loginCtrl.password']")).sendKeys("MosheQ!2");
        waitFor(2000);
        driver.findElement(By.xpath("//*[@ng-click='loginCtrl.onSubmit()']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        waitFor(7000);
        Assert.assertEquals("https://utest.aternity.com/#/view/monitorEnterprise?BACCT=3", driver.getCurrentUrl());
        /*driver.get("http://www.tutorialspoint.com/selenium/selenium_environment_setup.htm");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        waitFor(2000);

        driver.navigate().to("https://www.youtube.com");
        waitFor(2000);
        Assert.assertEquals("https://www.youtube.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id='masthead-search-term']")).sendKeys("selenium");
        waitFor(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
        waitFor(2000);
        Assert.assertEquals("https://www.youtube.com/results?search_query=selenium",driver.getCurrentUrl());
        */
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
