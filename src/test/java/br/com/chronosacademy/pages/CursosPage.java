package br.com.chronosacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CursosPage {
    private WebDriver driver;

    public CursosPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitulo2() {
        String xpathTitulo = "//section[2]//h2";
        WebElement h2Titulo = driver.findElement(By.xpath(xpathTitulo));
        return h2Titulo.getText();
    }
}
