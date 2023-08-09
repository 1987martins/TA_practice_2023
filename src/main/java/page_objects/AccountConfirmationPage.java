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
    private final By popUpWindow = By.xpath("//*[@id=\"card\"]");
    private final By popUpWindowCloseButton1 = By.xpath("//*[@id=\"dismiss-button\"]");
    private final By popUpWindowCloseButton2 = By.xpath("//*[@id=\"dismiss-button\"]");
    public WebElement getAccountCreatedTitle() {
        return driver.findElement(accountCreatedTitle);
    }

    public void clickOnContinueButton() {
        element = driver.findElement(continueButton);
        element.click();
    }

    public WebElement getPopUpWindow() {
        return driver.findElement(popUpWindow);
    }

    public void clickOnPopUpWindowClosingButton1() {
        element = driver.findElement(popUpWindowCloseButton1);
        element.click();
    }

    public void clickOnPopUpWindowClosingButton2() {
        element = driver.findElement(popUpWindowCloseButton2);
        element.click();
    }
}
