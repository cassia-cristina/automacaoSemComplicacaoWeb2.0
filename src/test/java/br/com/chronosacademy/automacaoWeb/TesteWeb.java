package br.com.chronosacademy.automacaoWeb;

import br.com.chronosacademy.core.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteWeb {
    WebDriver driver;
    Driver driverWeb;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("http://www.chronosacademy.com.br");
    }

    @Test
    public void primeiroTeste(){
        WebElement txtTitulo = driver.findElement(By.xpath("//section[2]//h4"));
        String titulo = txtTitulo.getText();
        Assert.assertEquals("Porque Tempo É Conhecimento",titulo);
    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }

}