package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Util;
import br.com.chronosacademy.pages.AccountDetailsPage;
import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class AccountDetailsSteps {
    MyAccountPage myAccountPage = new MyAccountPage();
    AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
    Map<String,String> mapDadosUser;

    @Dado("que esteja na pagina accountDetails")
    public void queEstejaNaPaginaAccountDetails() {
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
        myAccountPage.clickLinkEdit();
    }

    @Quando("sao alterados os seguintes campos")
    public void saoAlteradosOsSeguintesCampos(Map<String,String> map) {
        mapDadosUser = map;
        accountDetailsPage.setInpFirstName(map.get("firstName"));
        accountDetailsPage.setInpLastName(map.get("lastName"));
    }

    @Quando("for realizado o clique em save")
    public void forRealizadoOCliqueEmSave() {
        accountDetailsPage.clickBtnSave();
    }

    @Entao("a alteracao deve ser exibida na pagina myAccount")
    public void aAlteracaoDeveSerExibidaNaPaginaMyAccount() throws Exception {
        String nomeUsuario = mapDadosUser.get("firstName") + " " + mapDadosUser.get("lastName");
        Assert.assertEquals(nomeUsuario,myAccountPage.getTextUsuario());
        Util.printScreen("Nome do usuario foi alterado");
    }

}