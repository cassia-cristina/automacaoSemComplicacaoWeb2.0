package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.MyAccountMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    MyAccountMap myAccountMap;

    public MyAccountPage() {
        myAccountMap = new MyAccountMap();
        PageFactory.initElements(Driver.getDriver(), myAccountMap);
    }

    public void clickComVisibility(WebElement element){
        Driver.visibilityOf(element);
        element.click();
    }

    public void clickLinkUser(){
        clickComVisibility(myAccountMap.linkUser);
    }

    public void clickLinkMyAccount(){
        clickComVisibility(myAccountMap.linkMyAccount);
    }

    public void clickLinkEdit(){
        clickComVisibility(myAccountMap.linkEdit);
    }

    public String getTextUsuario(){
        Driver.visibilityOf(myAccountMap.textUsuario);
        return myAccountMap.textUsuario.getText();
    }

    public void clickBtnDelete(){
        clickComVisibility(myAccountMap.btnDelete);
    }

    public void clickBtnYes(){
        clickComVisibility(myAccountMap.btnYes);
    }

    public String getTextContaDeletada(){
        Driver.visibilityOf(myAccountMap.txtContaDeletada);
        return myAccountMap.txtContaDeletada.getText();
    }

}