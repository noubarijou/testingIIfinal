package prova.ultima.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import prova.ultima.Base.BasePage;

public class AccountCreation extends BasePage{
    protected static final String openNewAcc = "//*[@id=\"leftPanel\"]/ul/li[1]/a"; 
    protected static final String savings = "//*[@id=\"type\"]/option[2]"; 
    protected static final String newAccountBtn = "//*[@id=\"rightPanel\"]/div/div/form/div/input";
    protected static final String confirmMessage = "//*[@id=\"rightPanel\"]/div/div/p[1]"; 
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[1]/input"; 
    protected static final String pwd = "//*[@id=\"loginPanel\"]/form/div[2]/input"; 
    protected static final String loginBtn = "//*[@id=\"loginPanel\"]/form/div[3]/input"; 

    public void OpenNewAccount () {
        WebElement NewAccountLink = getWebElement(By.xpath(openNewAcc));
        NewAccountLink.click();
    }

    public void enterSavingsOption() {
        WebElement optionSavings = getWebElement(By.xpath(savings));
        optionSavings.click();
    }

    public void confirmOpenNewAccount() {
        WebElement newAccountButton = getWebElement(By.xpath(newAccountBtn));
        newAccountButton.click();
    }

    public String checkAccountCreationSuccess() {
        WebElement confirmationMessage = getWebElement(By.xpath(confirmMessage));
        return confirmationMessage.getText();
    }

    public void login(String loginInfo, String pwdInfo) throws InterruptedException {
        WebElement loginInput = getWebElement(By.xpath(login));
        loginInput.sendKeys(loginInfo);
        Thread.sleep(1500);
        WebElement passwordInput = getWebElement(By.xpath(pwd));
        passwordInput.sendKeys(pwdInfo);
        Thread.sleep(1500);
        WebElement loginButton = getWebElement(By.xpath(loginBtn));
        loginButton.click();
        Thread.sleep(1500);
    }
}

