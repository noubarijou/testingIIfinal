package prova.ultima.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import prova.ultima.Base.BasePage;

public class AccountOverview extends BasePage{
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[1]/input"; 
    protected static final String pwd = "//*[@id=\"loginPanel\"]/form/div[2]/input"; 
    protected static final String loginBtn = "//*[@id=\"loginPanel\"]/form/div[3]/input"; 
    protected static final String overview = "//*[@id=\"leftPanel\"]/ul/li[2]/a"; 
    protected static final String balance = "//*[@id=\"accountTable\"]/tfoot/tr/td"; 

    public void overviewPage() {
        WebElement overviewLink = getWebElement(By.xpath(overview));
        overviewLink.click();
    }

    public String checkBalance() {
        WebElement textBalance = getWebElement(By.xpath(balance));
        return textBalance.getText();
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
