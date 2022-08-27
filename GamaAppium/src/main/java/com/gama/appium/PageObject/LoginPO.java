package com.gama.appium.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPO {

    private AppiumDriver driver;
    private MobileElement botaoInsertUsuario;
    private MobileElement botaoSenha;
    private MobileElement botaoLogar;

    public LoginPO(AppiumDriver driver) {
        this.driver = driver;
    }

   public void LoginCampos(){
       botaoInsertUsuario = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
       botaoSenha = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
   }

    public void PreencheCamposLogin(String usuario, String senhaUsuario){
        botaoInsertUsuario.sendKeys(usuario);
        botaoSenha.sendKeys(senhaUsuario);
    }

   public void Logar(){
       botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
       botaoLogar.click();
   }
}
