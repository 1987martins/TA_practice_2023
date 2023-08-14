package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupAndLoginPage {

    private WebDriver driver;
    private WebElement element;

    public SignupAndLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signUpText = By.cssSelector(".signup-form > h2");
    private final By signUpNameField = By.cssSelector("[type='text']");
    private final By signUpEmailField = By.cssSelector("[action='\\/signup'] [type='email']");
    private final By signUpButton = By.cssSelector("[action='\\/signup'] .btn-default");
    private final By loginText = By.cssSelector(".login-form > h2");
    private final By loginEmailAdressField = By.cssSelector("[action='\\/login'] [type='email']");
    private final By loginPasswordField = By.cssSelector("[type='password']");
    private final By loginButton = By.cssSelector("[action='\\/login'] .btn-default");
    private final By errorMessage1 = By.cssSelector(".login-form > form[method='post'] > p");
    private final By errorMessage2 = By.cssSelector(".signup-form > form[method='post'] > p");

    public WebElement getSignUpTextElement() {
        return driver.findElement(signUpText);
    }

    public WebElement getSignUpNameField() {
        return driver.findElement(signUpNameField);
    }

    public void setSignUpNameField(String value) {
        driver.findElement(signUpNameField).sendKeys(value);
    }

    public WebElement getSignUpEmailField() {
        return driver.findElement(signUpEmailField);
    }

    public void setSignUpEmailField(String value) {
        driver.findElement(signUpEmailField).sendKeys(value);
    }

    public void clickOnSignUpButton() {
        element = driver.findElement(signUpButton);
        element.click();
    }

    public WebElement getLoginText() {
        return driver.findElement(loginText);
    }

    public WebElement getLoginEmailAddressField() {
        return driver.findElement(loginEmailAdressField);
    }

    public void setLoginEmailAddressField(String value) {
        driver.findElement(loginEmailAdressField).sendKeys(value);
    }

    public WebElement getLoginPasswordField() {
        return driver.findElement(loginPasswordField);
    }

    public void setLoginPasswordField(String value) {
        driver.findElement(loginPasswordField);
    }

    public void clickOnLoginButton() {
        element = driver.findElement(loginButton);
        element.click();
    }

    public WebElement getErrorMessageText1() {
        return driver.findElement(errorMessage1);
    }

    public void clearEmailAddressField() {
        element = driver.findElement(loginEmailAdressField);
        element.clear();
    }

    public void clearPasswordField() {
        element = driver.findElement(loginPasswordField);
        element.clear();
    }

    public WebElement getErrorMessageText2() {
        return driver.findElement(errorMessage2);
    }
}
