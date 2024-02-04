package appium.tests;

import appium.utils.AppiumDriverManager;
import appium.utils.Utils;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class Base extends Utils {

    @BeforeClass(alwaysRun = true)
    public void testSetup() throws MalformedURLException {
        AppiumDriverManager.createAndroidDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        AppiumDriverManager.quitSession();
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                // Take screenshot
                takeScreenshot(result.getName(), AppiumDriverManager.getDriver());
    
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
