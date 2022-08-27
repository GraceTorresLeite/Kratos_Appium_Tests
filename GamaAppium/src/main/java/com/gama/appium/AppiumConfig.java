package com.gama.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    public final AppiumDriver driver;
    private static AppiumConfig _instance;

    public static AppiumConfig Instance() {
        if(AppiumConfig._instance == null){
            AppiumConfig._instance = new AppiumConfig();
        }
        return AppiumConfig._instance;
    }

    public AppiumConfig() {
        File apk = new File("D:\\Users\\grace\\Intellij\\GamaAppium\\src\\main\\resources\\alura_esporte.apk");

        DesiredCapabilities configura = new DesiredCapabilities();
        configura.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());

        configura.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configura.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL conexao = null;
        try {
            conexao = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(conexao, configura);
    }
}
