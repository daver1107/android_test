package logic;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Init {
    protected AndroidDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";

    @Before
    void setUp() throws MalformedURLException {
        URL URL = new URL(APPIUM_URL);
        this.driver = new AndroidDriver<>(URL, this.getAndroidDesiredCapabilities());
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("Pixel 2 API 29","ver10");

        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","D:\\mobile_automation\\android\\org-wikipedia.apk");
        return capabilities;
    }

}
