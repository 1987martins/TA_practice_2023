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
    private final By signUpLogin = By.cssSelector(".nav.navbar-nav > li:nth-of-type(4) > a");

    public WebElement getLogoElement() {
        return driver.findElement(logo);
    }

    public WebElement getSignUpLoginElement() {
        return driver.findElement(signUpLogin);
    }

}
