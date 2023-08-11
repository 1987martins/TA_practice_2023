package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    private WebDriver driver;
    private WebElement element;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By paymentNameOnCard = By.cssSelector("input[name='name_on_card']");
    public final By paymentCardNumber = By.cssSelector("input[name='card_number']");
    public final By paymentCVCNumber = By.cssSelector("input[name='cvc']");
    public final By paymentMonthOfExpiration = By.cssSelector("input[name='expiry_month']");
    public final By paymentYearOfExpiration = By.cssSelector("input[name='expiry_year']");
    public final By payAndConfirmOrderButton = By.cssSelector("button#submit");
    public final By paymentSuccessMessage = By.cssSelector("div#success_message > .alert.alert-success");



    public WebElement getPaymentNameOnCard() {
        return driver.findElement(paymentNameOnCard);
    }

    public void setPaymentNameOnCard(String value) {
         driver.findElement(paymentNameOnCard).sendKeys();
    }

    public void setPaymentCardNumber(String value) {
         driver.findElement(paymentCardNumber).sendKeys(value);
    }

    public WebElement getPaymentCardNumber() {
        return driver.findElement(paymentCardNumber);
    }

    public void setPaymentCVCNumber(String value) {
         driver.findElement(paymentCVCNumber).sendKeys(value);
    }

    public WebElement getPaymentCVCNumber() {
        return driver.findElement(paymentCVCNumber);
    }

    public void setPaymentMonthOfExpiration(String value) {
         driver.findElement(paymentMonthOfExpiration).sendKeys(value);
    }

    public WebElement getPaymentMonthOfExpiration() {
        return driver.findElement(paymentMonthOfExpiration);
    }

    public void setPaymentYearOfExpiration(String value) {
         driver.findElement(paymentYearOfExpiration).sendKeys(value);
    }

    public WebElement getPaymentYearOfExpiration() {
        return driver.findElement(paymentYearOfExpiration);
    }

   public void clickOnPayAndConfirmOrderButton() {
        element = driver.findElement(payAndConfirmOrderButton);
        element.click();
   }

   public WebElement getPaymentSuccessMessage() {
        return driver.findElement(paymentSuccessMessage);
   }


}
