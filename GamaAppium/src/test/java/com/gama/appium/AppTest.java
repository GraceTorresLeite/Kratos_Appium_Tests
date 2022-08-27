package com.gama.appium;

import com.gama.appium.PageObject.CadastroPO;
import com.gama.appium.PageObject.LoginPO;
import com.gama.appium.PageObject.LogoutPO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class AppTest
{
    AppiumDriver driver;
    CadastroPO cadastroPo;
    LoginPO loginPo;
    LogoutPO logoutPo;

    @Test
    public void cadastro_invalido() {
        driver = AppiumConfig.Instance().driver;
        cadastroPo = new CadastroPO(driver);

        cadastroPo.EntrarFormularioCadastro();

        cadastroPo.BuscarCamposCadastro();
        cadastroPo.PreencheCamposCadastro("Kratos", "123","321");

        cadastroPo.Cadastrar();

        Assert.assertEquals("Senhas não conferem",cadastroPo.MensagemErroTelaCadastro());
        driver.navigate().back();
    }

    @Test
    public void cadastro_valido_com_login() throws NoSuchElementException, InterruptedException {
        driver = AppiumConfig.Instance().driver;
        cadastroPo = new CadastroPO(driver);

        cadastroPo.EntrarFormularioCadastro();
        cadastroPo.BuscarCamposCadastro();
        cadastroPo.PreencheCamposCadastro("Kratos", "123","123");

        cadastroPo.Cadastrar();
        Thread.sleep(2000);

        loginPo = new LoginPO(driver);
        loginPo.LoginCampos();
        loginPo.PreencheCamposLogin("Kratos", "123");
        loginPo.Logar();

        MobileElement iconeProdutos =
                (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/largeLabel");

        String verificaTelaProduto = iconeProdutos.getText();

        Assert.assertEquals("Produtos",verificaTelaProduto);

        logoutPo = new LogoutPO(driver);
        logoutPo.Deslogar();
    }

    @Test
    public void cadastro_ja_existente() throws NoSuchElementException, InterruptedException {
        driver = AppiumConfig.Instance().driver;
        cadastroPo = new CadastroPO(driver);

        cadastroPo.EntrarFormularioCadastro();

        cadastroPo.BuscarCamposCadastro();
        cadastroPo.PreencheCamposCadastro("Kratos", "123","123");

        cadastroPo.Cadastrar();

        Assert.assertEquals("Usuario já Cadastrado",cadastroPo.MensagemErroTelaCadastro());
        driver.navigate().back();
    }
}
