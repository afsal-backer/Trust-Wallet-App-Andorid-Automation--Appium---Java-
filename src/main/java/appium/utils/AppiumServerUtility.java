package appium.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerUtility {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .usingAnyFreePort()
            .withArgument(GeneralServerFlag.RELAXED_SECURITY);

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium server started at: " + service.getUrl());
    }

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }

    public static String getServiceUrl() {
        if (service != null) {
            return service.getUrl().toString();
        }
        return null;
    }
}
