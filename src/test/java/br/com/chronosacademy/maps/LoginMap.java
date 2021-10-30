package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {

    @FindBy(css = "#menuUser")
    public WebElement btnLogin;

    @FindBy(css = ".loginPopUpCloseBtn")
    public WebElement btnFechar;

    @FindBy(css = ".PopUp")
    public WebElement divFecharModal;

    @FindBy(css = "[name='username']")
    public WebElement inpUserName;

    @FindBy(css = "[name='password']")
    public WebElement inpPassword;

    @FindBy(css = "[name='remember_me']")
    public WebElement inpRemember;

    @FindBy(id = "sign_in_btnundefined")
    public WebElement btnSignIn;

    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount;

}