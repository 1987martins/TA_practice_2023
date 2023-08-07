package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDeletePage {

    private WebDriver driver;
    private WebElement element;

    public AccountDeletePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountDeleteTitle = By.cssSelector(".text-center.title > b");
    private final By continueButton = By.cssSelector(".btn.btn-primary");


    public WebElement getAccountDeleteTitle() {
        return driver.findElement(accountDeleteTitle);
    }

    public void clickOnContinueButton() {
        element = driver.findElement(continueButton);
        element.click();
    }
}
