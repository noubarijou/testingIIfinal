package prova.ultima.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import prova.ultima.Base.BasePage;

public class AccountActivity extends BasePage{
    
    protected static final String overviewAcct = "//*[@id=\"leftPanel\"]/ul/li[2]/a"; 
    protected static final String firstOptionAcct = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"; 
    protected static final String accountDetails = "//*[@id=\"rightPanel\"]/div/div[1]/h1"; 
    protected static final String goBtn = "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input"; 


    public void overviewPage() {
        WebElement overviewAccount = getWebElement(By.xpath(overviewAcct));
        overviewAccount.click();
    }

    public void activityPage() {
        WebElement firstOptionAccount = getWebElement(By.xpath(firstOptionAcct));
        firstOptionAccount.click();
    }

    public String checkAccountDetails() {
        WebElement accountDetailsText = getWebElement(By.xpath(accountDetails));
        return accountDetailsText.getText();
    }

    public void clickGoBtn() {
        WebElement goButton = getWebElement(By.xpath(goBtn));
        goButton.click();
    }

}
