package prova.ultima.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import prova.ultima.Base.BasePage;

public class RegisterForm extends BasePage{
    protected static final String name = "customer.firstName";
    protected static final String surName = "customer.lastName";
    protected static final String addy = "customer.address.street";
    protected static final String city = "customer.address.city";
    protected static final String state = "customer.address.state";
    protected static final String zipCode = "customer.address.zipCode";
    protected static final String phoneNumber = "customer.phoneNumber";
    protected static final String ssn = "customer.ssn";
    protected static final String username = "customer.username";
    protected static final String password = "customer.password";
    protected static final String confirmPassword = "repeatedPassword";
    protected static final String registerBtn = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"; 
    protected static final String confirmMessage = "//*[@id=\"rightPanel\"]/p"; 

    


    public void enterPersonalInfo(String firstName, 
    String lastName, 
    String address,
    String cityInfo,
    String stateInfo,
    String zipCodeInfo,
    String phoneNumberInfo,
    String ssnInfo,
    String usernameInfo,
    String passwordInfo
    ) throws InterruptedException {
        WebElement firstNameInput = getWebElement(By.id(name));
        firstNameInput.sendKeys(firstName);
        Thread.sleep(1500);
        WebElement lastNameInput = getWebElement(By.id(surName));
        lastNameInput.sendKeys(lastName);
        Thread.sleep(1500);
        WebElement addressInput = getWebElement(By.id(addy));
        addressInput.sendKeys(address);
        Thread.sleep(1500);
        WebElement cityInput = getWebElement(By.id(city));
        cityInput.sendKeys(cityInfo);
        Thread.sleep(1500);
        WebElement stateInput = getWebElement(By.id(state));
        stateInput.sendKeys(stateInfo);
        Thread.sleep(1500);
        WebElement zipCodeInput = getWebElement(By.id(zipCode));
        zipCodeInput.sendKeys(zipCodeInfo);
        Thread.sleep(1500);
        WebElement phoneNumberInput = getWebElement(By.id(phoneNumber));
        phoneNumberInput.sendKeys(phoneNumberInfo);
        Thread.sleep(1500);
        WebElement ssnInput = getWebElement(By.id(ssn));
        ssnInput.sendKeys(ssnInfo);
        Thread.sleep(1500);
        WebElement usernameInput = getWebElement(By.id(username));
        usernameInput.sendKeys(usernameInfo);
        Thread.sleep(1500);
        WebElement passwordInput = getWebElement(By.id(password));
        passwordInput.sendKeys(passwordInfo);
        Thread.sleep(1500);
        WebElement passwordConfInput = getWebElement(By.id(confirmPassword));
        passwordConfInput.sendKeys(passwordInfo);
        Thread.sleep(1500);
        Thread.sleep(1500);
    }

    public void confirmRegistration() {
        WebElement registerButton = getWebElement(By.xpath(registerBtn));
        registerButton.click();
    }
    public String confirmRegistrationSuccess() throws InterruptedException {
        WebElement confirmationMessage = getWebElement(By.xpath(confirmMessage));
        return confirmationMessage.getText();
    }
}
