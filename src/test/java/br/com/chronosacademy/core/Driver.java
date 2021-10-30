package br.com.chronosacademy.core;

import br.com.chronosacademy.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
                FirefoxOptions handSSL = new FirefoxOptions();
                handSSL.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(handSSL);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions handlingSSL = new ChromeOptions();
                handlingSSL.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(handlingSSL);
                break;
        }
        wait = new WebDriverWait(driver,10);
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
}