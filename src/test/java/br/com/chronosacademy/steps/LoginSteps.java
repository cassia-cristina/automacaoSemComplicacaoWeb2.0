package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.core.Util;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    String username;

    @Before
    public void iniciaNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Util.setNomeCenario(cenario.getName());
        Util.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws Exception {
        if (cenario.isFailed()) {
            Util.printScreen("Erro no cenario");
        }
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilyOfBtnFechar();
    }

    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.divFecharModal();
    }

    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        } catch (Exception e) {
            throw new Exception("A janela modal não foi fechada");
        }
    }

    @Quando("for realizado um clique no icone de fechar a modal")
    public void forRealizadoUmCliqueNoIconeDeFecharAModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clicklinkCreateAccount();
    }

    @Entao("a pagina Create New Account deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() throws Exception {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextCreateAccount());
        Util.printScreen("Abrindo a pagina Create New Account");
    }

    @Quando("os campos de login forem preenchidos da seguinte forma")
    public void osCamposDeLoginForemPreenchidosDaSeguinteForma(Map<String, String> map) throws Exception {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));
        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);
        if (remember) loginPage.clickInpRemember();
        Util.printScreen("Preenchimento dos campos de login");
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws Exception {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
        Util.printScreen("Logado no sistema");
    }

    @Entao("o sistema deve exibir uma mensagem de erro")
    public void oSistemaDeveExibirUmaMensagemDeErro() throws Exception {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());
        Util.printScreen("Usuario invalido ou inexistente");
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() throws Exception {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
        Util.printScreen("Sign In desabilitado");
    }

    @Dado("que esteja logado no sistema com")
    public void queEstejaLogadoNoSistemaCom(Map<String,String> map) throws Exception {
        queAModalEstejaSendoExibida();
        osCamposDeLoginForemPreenchidosDaSeguinteForma(map);
        forRealizadoOCliqueNoBotaoSignIn();
        deveSerPossivelLogarNoSistema();
    }

}