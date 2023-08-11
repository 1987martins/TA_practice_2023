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

    public final By deliveryAddressFieldClientName = By.cssSelector("#address_delivery .address_firstname");
    public final By deliveryAddressFieldClientAddress1 = By.xpath("//ul[@id='address_delivery']/li[4]");
    public final By deliveryAddressFieldClientAddress2 = By.xpath("//ul[@id='address_delivery']/li[6]");
    public final By deliveryAddressFieldClientCountry = By.cssSelector("#address_delivery .address_country_name");
    public final By deliveryAddressFieldClientPhoneNumber = By.cssSelector("#address_delivery .address_phone");
    public final By invoiceAddressFieldClientName = By.cssSelector("#address_invoice .address_firstname");
    public final By invoiceAddressFieldClientAddress1 = By.xpath("//ul[@id='address_invoice']/li[4]");
    public final By invoiceAddressFieldClientAddress2 = By.xpath("//ul[@id='address_invoice']/li[6]");
    public final By invoiceAddressFieldClientCountry = By.cssSelector("#address_invoice .address_country_name");
    public final By invoiceAddressFieldClientPhoneNumber = By.cssSelector("#address_invoice .address_phone");
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
    public WebElement getDeliveryAddressFieldClientName() {
        return driver.findElement(deliveryAddressFieldClientName);
    }

    public WebElement getDeliveryAddressFieldClientAddress1() {
        return driver.findElement(deliveryAddressFieldClientAddress1);
    }

    public WebElement getDeliveryAddressFieldClientAddress2() {
        return driver.findElement(deliveryAddressFieldClientAddress2);
    }

    public WebElement getDeliveryAddressFieldClientCountry() {
        return driver.findElement(deliveryAddressFieldClientCountry);
    }

    public WebElement getDeliveryAddressFieldClientPhoneNumber() {
        return driver.findElement(deliveryAddressFieldClientPhoneNumber);
    }

    public WebElement getInvoiceAddressFieldClientName() {
        return driver.findElement(invoiceAddressFieldClientName);
    }

    public WebElement getInvoiceAddressFieldClientAddress1() {
        return driver.findElement(invoiceAddressFieldClientAddress1);
    }

    public WebElement getInvoiceAddressFieldClientAddress2() {
        return driver.findElement(invoiceAddressFieldClientAddress2);
    }

    public WebElement getInvoiceAddressFieldClientCountry() {
        return driver.findElement(invoiceAddressFieldClientCountry);
    }

    public WebElement getInvoiceAddressFieldClientPhoneNumber() {
        return driver.findElement(invoiceAddressFieldClientPhoneNumber);
    }

    public WebElement getCheckoutLeaveCommentField() {
        return driver.findElement(checkoutLeaveCommentField);
    }

    public void setCheckoutLeaveCommentField(String value) {
        driver.findElement(checkoutLeaveCommentField).sendKeys(value);
    }

    public void clickOnPlaceOrderButton() {
        element =  driver.findElement(placeOrderButton);
        element.click();
    }

    public WebElement getCheckoutMenTshirtTitle() {
        return driver.findElement(checkoutMenTshirtTitle);
    }
}
