package prova.ultima;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import prova.ultima.Base.BasePage;
import prova.ultima.Pages.AccountActivity;
import prova.ultima.Pages.AccountCreation;
import prova.ultima.Pages.AccountOverview;
import prova.ultima.Pages.HomePage;
import prova.ultima.Pages.RegisterForm;
import prova.ultima.Pages.TransferPage;

import static org.junit.Assert.assertTrue;

public class TestFrontEnd {
    private static WebDriver driver;

    @Before
    public void setUp() {
        BasePage basePage = new BasePage();
        basePage.openSite();
        driver = basePage.getDriver();
    }

    @Test
    public void testTheWholeShebang() throws InterruptedException {
         HomePage home = new HomePage();
         home.btnRegister();
         Thread.sleep(1000);

         RegisterForm register = new RegisterForm();
         register.enterPersonalInfo("Jonas", "Antunes", "rua do cão", "lugar nenhum",
         "condado zuado", "15435432",
         "334524532", "345254325", "us3rn4m3", "p455w0rd");
         Thread.sleep(1000);
         register.confirmRegistration();
         Thread.sleep(1000);

         String confirmationMessage = register.confirmRegistrationSuccess();
         Thread.sleep(1000);
         assertTrue(confirmationMessage.contains("Your account was created successfully. You are now logged in."));

        AccountCreation create = new AccountCreation();
        create.login("us3rn4m3", "p455w0rd");
        Thread.sleep(1000);
        create.OpenNewAccount();
        Thread.sleep(1000);
        create.enterSavingsOption();
        Thread.sleep(1000);
        create.confirmOpenNewAccount();
        Thread.sleep(1000);

        String message = create.checkAccountCreationSuccess();
        Thread.sleep(1000);
        assertTrue(message.contains("Congratulations, your account is now open."));

        AccountOverview overview = new AccountOverview();
        overview.overviewPage();
        Thread.sleep(1000);

        String msg = overview.checkBalance();
        Thread.sleep(1000);
        assertTrue(msg.contains("*Balance includes deposits that may be subject to holds"));

        TransferPage transfer = new TransferPage();
        transfer.fundsPage();
        Thread.sleep(1000);
        transfer.checkPage();
        Thread.sleep(1000);
        transfer.fillAmount();
        Thread.sleep(1000);
        transfer.senderAccount();
        Thread.sleep(1000);
        transfer.receiverAccount();
        Thread.sleep(1000);
        transfer.confirmTransfer();
        Thread.sleep(1000);

        String msgTrasnfer = transfer.checkTransferSuccess();
        Thread.sleep(1000);
        assertTrue(msgTrasnfer.contains("Transfer Complete!"));

        AccountActivity activity = new AccountActivity();
        activity.overviewPage();
        Thread.sleep(1000);
        activity.activityPage();
        Thread.sleep(1000);
        activity.checkAccountDetails();
        Thread.sleep(1000);
        activity.clickGoBtn();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
