package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    private WebDriver driver;
    private WebElement element;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    private final By logo = By.cssSelector("img[alt='Website for automation practice']");
    private final By signUpLoginLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(4) > a");
    private final By loggedInAsUser = By.cssSelector("li:nth-of-type(10) > a");
    private final By deleteAccountLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(5) > a");
    private final By logoutUserLink  = By.cssSelector(".nav.navbar-nav > li:nth-of-type(4) > a");

    public WebElement getLogoElement() {
        return driver.findElement(logo);
    }
    public void clickOnSignUpLoginLink(){
        element = driver.findElement(signUpLoginLink);
        element.click();
    }

    public WebElement getLoggedInAsUser(){
        return driver.findElement(loggedInAsUser);
    }

    public void clickOnDeleteAccountLink(){
        element = driver.findElement(deleteAccountLink);
        element.click();
    }

    public void clickOnLogoutUserLink(){
        element = driver.findElement(logoutUserLink);
        element.click();
    }


}
