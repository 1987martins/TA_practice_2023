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
}
