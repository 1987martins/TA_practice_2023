package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private WebElement element;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By checkoutLeaveCommentField = By.cssSelector("div#ordermsg > textarea[name='message']");
    public final By placeOrderButton = By.cssSelector(".btn.btn-default.check_out");
    public final By deliveryAddressField = By.cssSelector("ul#address_delivery");
    public final By invoiceAddressField = By.cssSelector("ul#address_invoice");
    private final By checkoutMenTshirtTitle = By.cssSelector("[href='\\/product_details\\/2']");

    public WebElement getDeliveryAddressField() {
        return driver.findElement(deliveryAddressField);
    }

    public WebElement getInvoiceAddressField() {
        return driver.findElement(invoiceAddressField);
    }

    public WebElement getCheckoutLeaveCommentField() {
        return driver.findElement(checkoutLeaveCommentField);
    }

    public void setCheckoutLeaveCommentField(String value) {
        driver.findElement(checkoutLeaveCommentField).sendKeys(value);
    }

    public void clickOnPlaceOrderButton() {
        element = driver.findElement(placeOrderButton);
        element.click();
    }

    public WebElement getCheckoutMenTshirtTitle() {
        return driver.findElement(checkoutMenTshirtTitle);
    }
}
