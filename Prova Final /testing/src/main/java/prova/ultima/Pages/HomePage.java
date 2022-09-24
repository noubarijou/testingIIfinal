package prova.ultima.Pages;
import org.openqa.selenium.WebElement;
import prova.ultima.Base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    protected static final String registerBtn = "Register";

    public void btnRegister() throws InterruptedException{
        WebElement registerButton = getWebElement(By.partialLinkText(registerBtn));
        registerButton.click();
        Thread.sleep(1000);
    }
}
