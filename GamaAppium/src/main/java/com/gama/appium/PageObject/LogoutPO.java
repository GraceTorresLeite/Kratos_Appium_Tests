package com.gama.appium.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogoutPO {

    private AppiumDriver driver;
    private MobileElement botaoDeslogar;

    public LogoutPO(AppiumDriver driver) {
        this.driver = driver;
    }

    public void Deslogar(){
        botaoDeslogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        botaoDeslogar.click();
    }
}
