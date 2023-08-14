package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsDetailsPage {
    private WebDriver driver;
    private WebElement element;

    public ProductsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By detailPageProductsName = By.cssSelector(".product-information > h2");
    private final By detailPageProductsCategory = By.cssSelector(".product-information p:nth-child(3)");
    private final By detailPageProductPrice = By.cssSelector(".product-information span:nth-child(5) span");
    private final By detailPageProductsAvailability = By.cssSelector(".product-information p:nth-child(6)");
    private final By detailPageProductsCondition = By.cssSelector(".product-information p:nth-child(7)");
    private final By detailPageProductsBrand = By.cssSelector(".product-information p:nth-child(8)");
    private final By detailPageProductsQuantity = By.xpath("/html//input[@id='quantity']");
    private final By detailPageAddToCartButton = By.cssSelector(".btn.btn-default.cart");
    private final By detailPageViewCartLink = By.cssSelector(".modal-confirm.modal-dialog a");

    public WebElement getDetailPageProductsName() {
        return driver.findElement(detailPageProductsName);
    }

    public WebElement getDetailPageProductsCategory() {
        return driver.findElement(detailPageProductsCategory);
    }

    public WebElement getDetailPageProductsPrice() {
        return driver.findElement(detailPageProductPrice);
    }

    public WebElement getDetailPageProductsAvailability() {
        return driver.findElement(detailPageProductsAvailability);
    }

    public WebElement getDetailPageProductsCondition() {
        return driver.findElement(detailPageProductsCondition);
    }

    public WebElement getDetailPageProductsBrand() {
        return driver.findElement(detailPageProductsBrand);
    }

    public WebElement getDetailPageProductsQuantity() {
        return driver.findElement(detailPageProductsQuantity);
    }

    public void setDetailPageProductsQuantity(String value) {
        driver.findElement(detailPageProductsQuantity).sendKeys(value);
    }

    public void clearDetailPageProductsQuantity() {
        element = driver.findElement(detailPageProductsQuantity);
        element.clear();
    }

    public void clickOnDetailPageAddToCartButton() {
        element = driver.findElement(detailPageAddToCartButton);
        element.click();
    }

    public void clickOnDetailPageViewCartLink() {
        element = driver.findElement(detailPageViewCartLink);
        element.click();
    }
}
