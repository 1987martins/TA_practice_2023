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

    private final By listingPageProductsName = By.cssSelector(".product-information > h2");
    private final By listingPageProductsCategory = By.cssSelector(".product-information p:nth-child(3)");
    private final By listingPageProductPrice = By.cssSelector(".product-information span:nth-child(5) span");
    private final By listingPageProductsAvailability = By.cssSelector(".product-information p:nth-child(6)");
    private final By listingPageProductsCondition = By.cssSelector(".product-information p:nth-child(7)");
    private final By listingPageProductsBrand = By.cssSelector(".product-information p:nth-child(8)");

    public WebElement getListingPageProductsName() {
        return driver.findElement(listingPageProductsName);
    }

    public WebElement getListingPageProductsCategory() {
        return driver.findElement(listingPageProductsCategory);
    }

    public WebElement getListingPageProductsPrice() {
        return driver.findElement(listingPageProductPrice);
    }

    public WebElement getListingPageProductsAvailability() {
        return driver.findElement(listingPageProductsAvailability);
    }

    public WebElement getListingPageProductsCondition() {
        return driver.findElement(listingPageProductsCondition);
    }

    public WebElement getListingPageProductsBrand() {
        return driver.findElement(listingPageProductsBrand);
    }
}
