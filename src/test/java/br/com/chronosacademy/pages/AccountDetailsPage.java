package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.AccountDetailsMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountDetailsPage {
    AccountDetailsMap accountDetailsMap;

    public AccountDetailsPage() {
        accountDetailsMap = new AccountDetailsMap();
        PageFactory.initElements(Driver.getDriver(),accountDetailsMap);
    }

    public void setInpFirstName(String firstName){
        Driver.visibilityOf(accountDetailsMap.inpFirstName);
        accountDetailsMap.inpFirstName.clear();
        //aguardando carregar o options para dar tempo de habilitar o botão salvar
        Driver.aguardarOptions(new Select(accountDetailsMap.slcCountry));
        accountDetailsMap.inpFirstName.sendKeys(firstName);
    }

    public void setInpLastName(String lastName){
        accountDetailsMap.inpLastName.clear();
        accountDetailsMap.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSave(){
        accountDetailsMap.btnSave.click();
    }

}