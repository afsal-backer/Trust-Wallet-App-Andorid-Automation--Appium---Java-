package appium.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumDriverManager {
    private static final String APP_PATH = System.getProperty("user.dir") + "/src/test/app/v8.7.1_release.apk";
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();

    public static void createAndroidDriver() throws MalformedURLException {
        AppiumServerUtility.startServer();
       
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 API 33")
               .setAutomationName("UiAutomator2")
               .setApp(APP_PATH);
       
               String sURL = AppiumServerUtility.getServiceUrl();
        var serverUrl = URI.create(sURL).toURL();
        AndroidDriver driver = new AndroidDriver(serverUrl, options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        setDriver(driver);
    }

    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitSession() {
        if (null != getDriver()) {
            getDriver().quit();
            DRIVER.remove();
        }
        // Stop the Appium server
        AppiumServerUtility.stopServer();
    }

    private static void setDriver(AndroidDriver driver) {
        DRIVER.set(driver);
    }


}
