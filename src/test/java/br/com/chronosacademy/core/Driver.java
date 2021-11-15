package br.com.chronosacademy.core;

import br.com.chronosacademy.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static boolean headless;

    public Driver(Browser navegador) {
        switch (navegador){
            case IE:
                startIE();
                break;
            case FIREFOX:
                startFirefox();
                break;
            case EDGE:
                startEdge();
                break;
            case CHROME:
                startChrome();
                break;
        }
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }

    private void startIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private void startEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        headless = Boolean.parseBoolean(System.getProperty("headless"));
        firefoxOptions.setHeadless(headless);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().setSize(new Dimension(1280,720));
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280,720));
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

    public static void aguardarOptions(Select select){
        for (int i = 0; i < 6; i++) {
            if(select.getOptions().size() > 1){
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}