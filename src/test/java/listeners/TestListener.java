package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Reports.ExtentReportManager;
import baseTest.BaseTest;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        extent = ExtentReportManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());

        // Get WebDriver from the failed test class
        WebDriver driver =
                ((BaseTest) result.getInstance()).driver;

        // Take Screenshot
        String screenshotPath =
                takeScreenshot(
                        driver,
                        result.getMethod().getMethodName()
                );

        // Attach Screenshot to Extent Report
        try {

            test.addScreenCaptureFromPath(
                    screenshotPath
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }

    public String takeScreenshot(
            WebDriver driver,
            String testName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE
                            );

            String destination =
                    "test-output/screenshots/"
                            + testName
                            + ".png";

            File finalDestination =
                    new File(destination);

            FileUtils.copyFile(
                    source,
                    finalDestination
            );

            return destination;

        } catch (IOException e) {

            e.printStackTrace();

            return null;
        }
    }
}