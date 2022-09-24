package prova.ultima.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import prova.ultima.Base.BasePage;

public class TransferPage extends BasePage{
    
    protected static final String funds = "//*[@id=\"leftPanel\"]/ul/li[3]/a"; 
    protected static final String title = "//*[@id=\"rightPanel\"]/div/div/h1"; 
    protected static final String amount = "amount"; 
    protected static final String firstOption = "//*[@id=\"fromAccountId\"]/option[1]";
    protected static final String secondOption = "//*[@id=\"fromAccountId\"]/option[2]";
    protected static final String transferBtn = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input"; 
    protected static final String resultTitle = "//*[@id=\"rightPanel\"]/div/div/h1"; 
    protected static final String amountInfo = "77";

    public void fundsPage() {
        WebElement fundsLink = getWebElement(By.xpath(funds));
        fundsLink.click();
    }

    public String checkPage() {
        WebElement fundsTitle = getWebElement(By.xpath(title));
        return fundsTitle.getText();
    }

    public void fillAmount() {
        WebElement amountInput = getWebElement(By.id(amount));
        amountInput.sendKeys(amountInfo);
    }

    public void senderAccount() {
        WebElement firstOptionAccount = getWebElement(By.xpath(firstOption));
        firstOptionAccount.click();
    }

    public void receiverAccount() {
        WebElement secondOptionAccount = getWebElement(By.xpath(secondOption));
        secondOptionAccount.click();
    }

    public void confirmTransfer() {
        WebElement transferButton = getWebElement(By.xpath(transferBtn));
        transferButton.click();
    }

    public String checkTransferSuccess() {
        WebElement result = getWebElement(By.xpath(resultTitle));
        return result.getText();
    }

}
