import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Appium {

    private URL url;
    private AppiumDriver appiumDriver;
    private static Appium appium = new Appium();

    private Appium() {}

    public void initAppium(String deviceName,
                            String deviceId,
                            String platformName,
                            String platformVersion,
                            String appPackage,
                            String appActivity) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", deviceId);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver<MobileElement>(url, capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public void setAppiumDriver(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public static Appium getInstance() {
        return appium;
    }

    public static AppiumDriver getDriver() {
        return appium.getAppiumDriver();
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
