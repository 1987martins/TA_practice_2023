package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsListingPage {

    private WebDriver driver;
    private WebElement element;

    public ProductsListingPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productsListingPageTitle = By.cssSelector(".text-center.title");
    private final By productsList = By.xpath("//body/section[2]/div[@class='container']//div[@class='features_items']");
    private final By blueTopViewProductButton = By.cssSelector("[href='\\/product_details\\/1']");
    private final By searchInputField = By.cssSelector("input#search_product");
    private final By searchButton = By.xpath("/html//button[@id='submit_search']");
    private final By blueTopAddToCartButton = By.cssSelector(".features_items [class='col-sm-4']:nth-child(3) .text-center .add-to-cart");
    private final By menTshirtAddToCartButton = By.cssSelector(".features_items [class='col-sm-4']:nth-child(4) .text-center .add-to-cart");
    private final By continueShoppingButton = By.cssSelector(".btn.btn-block.btn-success.close-modal");
    private final By viewCartLink = By.cssSelector(".modal-confirm.modal-dialog a");

    public WebElement getProductsListingPageTitle() {
        return driver.findElement(productsListingPageTitle);
    }

    public WebElement getProductsList() {
        return driver.findElement(productsList);
    }

    public void clickOnBlueTopViewProductButton() {
        element = driver.findElement(blueTopViewProductButton);
        element.click();
    }

    public WebElement getSearchInputField(){
        return driver.findElement(searchInputField);
    }

    public void setSearchInputField(String value){
        driver.findElement(searchInputField).sendKeys(value);
    }

    public void clickOnSearchButton() {
        element = driver.findElement(searchButton);
        element.click();
    }

    public void clickOnBlueTopAddToCartButton() {
        element = driver.findElement(blueTopAddToCartButton);
        element.click();
    }

    public void clickOnMenTshirtAddToCartButton() {
        element = driver.findElement(menTshirtAddToCartButton);
        element.click();
    }

    public void clickOnContinueShoppingButton() {
        element = driver.findElement(continueShoppingButton);
        element.click();
    }

    public void clickOnViewCartLink() {
        element = driver.findElement(viewCartLink);
        element.click();
    }
}
