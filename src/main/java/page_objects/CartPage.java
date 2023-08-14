package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;
    private WebElement element;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cartSubscriptionField = By.xpath("/html//input[@id='susbscribe_email']");
    private final By cartSubscribeButton = By.xpath("/html//button[@id='subscribe']");
    private final By cartSubscriptionSuccessMessage = By.cssSelector("div#success-subscribe > .alert.alert-success");
    private final By cartBluTopTitle = By.cssSelector("tr:nth-of-type(1)  h4 > a");
    private final By cartBlueTopProductPrice = By.cssSelector("tr:nth-of-type(1) > .cart_price > p");
    private final By cartBlueTopProductQuantity = By.cssSelector("tbody tr:nth-of-type(1) button");
    private final By cartBlueTopTotalPrice = By.cssSelector("tr:nth-of-type(1)  .cart_total_price");
    private final By cartMenTshirtTitle = By.cssSelector("tr:nth-of-type(2)  h4 > a");
    private final By cartMenTshirtProductPrice = By.cssSelector("tr:nth-of-type(2) > .cart_price > p");
    private final By cartMenTshirtTotalPrice = By.cssSelector("tr:nth-of-type(2)  .cart_total_price");
    private final By cartMenTshirtProductQuantity = By.cssSelector("tbody tr:nth-of-type(2) button");
    private final By cartSleevelessDressTitle = By.cssSelector("[href='\\/product_details\\/3']");
    private final By cartSleevelessDressQuantity = By.cssSelector("tr#product-3 > .cart_quantity");
    private final By cartProceedToCheckoutButton = By.cssSelector(".btn.btn-default.check_out");
    private final By cartRegisterLoginLink = By.xpath("/html//div[@id='checkoutModal']//a[@href='/login']/u[.='Register / Login']");
    private final By cartDeleteProductFromCartButton1 = By.cssSelector("tr:nth-of-type(1)  .cart_quantity_delete");
    private final By cartDeleteProductFromCartButton2 = By.cssSelector("tr:nth-of-type(2)  .cart_quantity_delete");
    private final By cartEmptyCartMessageText = By.cssSelector("span#empty_cart");

    public WebElement getCartSubscriptionField() {
        return driver.findElement(cartSubscriptionField);
    }

    public void setCartSubscriptionField(String value) {
        driver.findElement(cartSubscriptionField).sendKeys(value);
    }

    public void clickOnCartSubscribeButton() {
        element = driver.findElement(cartSubscribeButton);
        element.click();
    }

    public WebElement getCartSubscriptionSuccessMessage() {
        return driver.findElement(cartSubscriptionSuccessMessage);
    }

    public WebElement getCartBluTopTitle() {
        return driver.findElement(cartBluTopTitle);
    }

    public WebElement getCartBlueTopProductQuantity() {
        return driver.findElement(cartBlueTopProductQuantity);
    }

    public WebElement getCartBlueTopTotalPrice() {
        return driver.findElement(cartBlueTopTotalPrice);
    }

    public WebElement getCartBlueTopProductPrice() {
        return driver.findElement(cartBlueTopProductPrice);
    }

    public WebElement getCartMenTshirtTitle() {
        return driver.findElement(cartMenTshirtTitle);
    }

    public WebElement getCartMenTshirtProductPrice() {
        return driver.findElement(cartMenTshirtProductPrice);
    }

    public WebElement getCartMenTshirtProductQuantity() {
        return driver.findElement(cartMenTshirtProductQuantity);
    }

    public WebElement getCartMenTshirtTotalPrice() {
        return driver.findElement(cartMenTshirtTotalPrice);
    }

    public WebElement getCartSleevelessDressTitle() {
        return driver.findElement(cartSleevelessDressTitle);
    }

    public WebElement getCartSleevelessDressQuantity() {
        return driver.findElement(cartSleevelessDressQuantity);
    }

    public void clickOnCartProceedToCheckout() {
        element = driver.findElement(cartProceedToCheckoutButton);
        element.click();
    }

    public WebElement getCartRegisterLoginLink() {
        return driver.findElement(cartRegisterLoginLink);
    }

    public void clickOnCartRegisterLoginLink() {
        element = driver.findElement(cartRegisterLoginLink);
        element.click();
    }

    public void clickOnDeleteProductFromCartButton1() {
        element = driver.findElement(cartDeleteProductFromCartButton1);
        element.click();
    }

    public void clickOnDeleteProductFromCartButton2() {
        element = driver.findElement(cartDeleteProductFromCartButton2);
        element.click();
    }

    public WebElement getCartEmptyCartMessageText() {
        return driver.findElement(cartEmptyCartMessageText);
    }
}
