package config;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileProvider implements WebDriverProvider {

    public static URL getAppium(){
        try {
            return new URL("http://127.0.0.1:8201/wd/hub/");
        }
        catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
    @NotNull
    @Override
    public WebDriver createDriver(@NotNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setCapability("platformName", "Android");
        options.setCapability("appium:deviceName", "Pixel 6 Pro");
        return new AndroidDriver(getAppium(), options);
    }
}
