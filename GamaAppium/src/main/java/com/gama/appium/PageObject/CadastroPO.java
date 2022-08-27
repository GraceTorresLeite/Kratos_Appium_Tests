package com.gama.appium.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPO {

    private AppiumDriver driver;
    private MobileElement insertNome;
    private MobileElement insertSenha;
    private MobileElement insertSenhaConfirma;
    private MobileElement botaoCadastroUsuario;
    private MobileElement botaoFazerCadastro;
    private MobileElement erroCadastro;

    public CadastroPO(AppiumDriver driver) {
        this.driver = driver;
    }

    public void BuscarCamposCadastro(){
        insertNome = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        insertSenha = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        insertSenhaConfirma = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastroUsuario = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public void PreencheCamposCadastro(String nome, String senha, String confirmaSenha){
        insertNome.sendKeys(nome);
        insertSenha.sendKeys(senha);
        insertSenhaConfirma.setValue(confirmaSenha);
    }

    public void Cadastrar(){
        botaoCadastroUsuario.click();
    }

    public void EntrarFormularioCadastro(){
        botaoFazerCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoFazerCadastro.click();
    }

    public String MensagemErroTelaCadastro(){
        By erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(erroId));

        erroCadastro = (MobileElement) driver.findElement(erroId);
        return erroCadastro.getText();
    }
}
