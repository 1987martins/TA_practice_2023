package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCategoryPage {
    private WebDriver driver;
    private WebElement element;

    public ProductCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productCategoryPageTitle = By.cssSelector(".text-center.title");

    public WebElement getProductCategoryPageTitle() {
        return driver.findElement(productCategoryPageTitle);
    }
}





