package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(),loginMap);
    }

    public void clickBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        aguardarLoader();
        loginMap.btnLogin.click();
    }

    public void clickBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
        aguardarLoader();
        loginMap.btnFechar.click();
    }

    public void divFecharModal(){
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username){
        if(username != null) {
            loginMap.inpUserName.sendKeys(username);
        }
    }

    public void setInpPassword(String password){
        if(password != null){
            loginMap.inpPassword.sendKeys(password);
        }
    }

    public void clickInpRemember(){
        aguardarLoader();
        loginMap.inpRemember.click();
    }

    public void clicklinkCreateAccount(){
        Driver.visibilityOf(loginMap.linkCreateAccount);
        aguardarLoader();
        loginMap.linkCreateAccount.click();
    }

    public void clickBtnSignIn(){
        aguardarLoader();
        loginMap.btnSignIn.click();
    }

    public boolean isBtnSignIn(){
        return loginMap.btnSignIn.isEnabled();
    }

    public void visibilyOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
        aguardarLoader();
    }

    public void invisibilityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.btnFechar);
    }

    public void aguardarLoader(){
        Driver.attributeChange(loginMap.divLoader,"display","none");
    }

    public String getUsuarioLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }

    public String getErroLogin(){
        Driver.visibilityOf(loginMap.textErroLogin);
        return loginMap.textErroLogin.getText();
    }

}