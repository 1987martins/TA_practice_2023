package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductBrandPage {
    private WebDriver driver;

    public ProductBrandPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productBrandPageTitle = By.cssSelector(".text-center.title");

    public WebElement getProductBrandPageTitle() {
        return driver.findElement(productBrandPageTitle);
    }
}





