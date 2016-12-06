package com.eviltester.webdriver;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*import library.Utility;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitle
{

    ExtentReports report;
    ExtentTest logger;
    WebDriver driver;


    @Test
    public void verifyBlogTitle()
    {
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

        report = new ExtentReports("C:\\Report\\LearnAutomation.html");

        logger = report.startTest("VerifyBlogTitle");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        logger.log(LogStatus.INFO, "Browser started ");

        driver.get("http://www.learn-automation.com");

        logger.log(LogStatus.INFO, "Application is up and running");

        String title = driver.getTitle();

        Assert.assertTrue(title.contains("WebDriver"));

        logger.log(LogStatus.PASS, "Title verified");
    }


   /* @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenshot_path = Utility.captureScreenshot(driver, result.getName());
            String image = logger.addScreenCapture(screenshot_path);
            logger.log(LogStatus.FAIL, "Title verification", image);
        }

        report.endTest(logger);
        report.flush();

        driver.get("C:\\Report\\LearnAutomation.html");
    }*/


}