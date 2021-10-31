package br.com.chronosacademy.core;

import br.com.chronosacademy.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public Driver(Browser navegador) {
        switch (navegador){
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                //ChromeOptions handlingSSL = new ChromeOptions(); handlingSSL.setAcceptInsecureCerts(true);
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void visibilityOf(WebElement element ){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibilityOf(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void attributeChange(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(element,attribute,value));
    }
}