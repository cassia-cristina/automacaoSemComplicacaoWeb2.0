package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Util;
import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class MyAccountSteps {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Dado("que esteja na pagina myAccount")
    public void queEstejaNaPaginaMyAccount() {
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
    }

    @Quando("for realizado o clique em Delete Account e em yes")
    public void forRealizadoOCliqueEmDeleteAccountEEmYes() {
        myAccountPage.clickBtnDelete();
        myAccountPage.clickBtnYes();
    }

    @Entao("exibe a mensagem de conta deletada com sucesso")
    public void exibeAMensagemDeContaDeletadaComSucesso() throws Exception {
        Assert.assertEquals("Account deleted successfully",myAccountPage.getTextContaDeletada());
        Util.printScreen("Conta deletada");
    }

}