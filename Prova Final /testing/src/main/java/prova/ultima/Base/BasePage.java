package prova.ultima.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;
    public static final String URL = "https://parabank.parasoft.com/parabank/index.htm";
    public BasePage(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void openSite(){
        driver.get(URL);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebElement getWebElement(By locator){
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Element not found");
            System.out.println("Error message: " + e);
        }
        return element;
    }

}
//*[@id="loginPanel"]/p[2]/a