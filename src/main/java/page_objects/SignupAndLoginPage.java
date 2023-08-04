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

    public WebElement getSignUpTextElement(){
        return driver.findElement(signUpText);
    }

    public WebElement getSignUpNameField(){
        return driver.findElement(signUpNameField);
    }

    public void setSignUpNameField(String value) {
        driver.findElement(signUpNameField).sendKeys(value);
    }

    public WebElement getSignUpEmailField(){
        return driver.findElement(signUpEmailField);
    }

    public void setSignUpEmailField(String value) {
        driver.findElement(signUpEmailField).sendKeys(value);
    }

    public void clickOnSignUpButton() {
        element = driver.findElement(signUpButton);
        element.click();
    }

}
