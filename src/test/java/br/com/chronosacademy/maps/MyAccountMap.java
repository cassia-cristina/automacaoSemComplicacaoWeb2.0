package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountMap {

    @FindBy(css = "#menuUserLink")
    public WebElement linkUser;

    @FindBy(css = "#loginMiniTitle > label[translate='My_account']")
    public WebElement linkMyAccount;

    @FindBy(css = "a[href='#/accountDetails']")
    public WebElement linkEdit;

    @FindBy(xpath = "//*[@id=\"myAccountContainer\"]/div[1]/div/div[1]/label")
    public WebElement textUsuario;

    @FindBy(css = ".deleteBtnText")
    public WebElement btnDelete;

    @FindBy(css = ".deleteRed")
    public WebElement btnYes;

    @FindBy(css = ".modificationTwo > p")
    public WebElement txtContaDeletada;

}
