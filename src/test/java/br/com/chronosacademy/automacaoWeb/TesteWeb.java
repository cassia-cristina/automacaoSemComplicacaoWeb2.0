package br.com.chronosacademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteWeb {
    ChromeDriver driver;

    @Before
    public void inicializaTeste(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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