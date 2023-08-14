package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountConfirmationPage {

    private WebDriver driver;
    private WebElement element;

    public AccountConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountCreatedTitle = By.cssSelector(".text-center.title > b");
    private final By continueButton = By.xpath("/html//section[@id='form']/div[@class='container']//a[@href='/']");

    public WebElement getAccountCreatedTitle() {
        return driver.findElement(accountCreatedTitle);
    }

    public void clickOnContinueButton() {
        element = driver.findElement(continueButton);
        element.click();
    }
}
