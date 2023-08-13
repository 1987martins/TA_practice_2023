package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    private WebDriver driver;
    private WebElement element;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    private final By logo = By.cssSelector("img[alt='Website for automation practice']");
    private final By signUpLoginLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(4) > a");
    private final By loggedInAsUser = By.cssSelector("li:nth-of-type(10) > a");
    private final By deleteAccountLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(5) > a");
    private final By logoutUserLink  = By.cssSelector(".nav.navbar-nav > li:nth-of-type(4) > a");
    private final By contactUsLink  = By.cssSelector("li:nth-of-type(8) > a");
    private final By productsLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(2) > a");
    private final By homepageSubscriptionField = By.xpath("/html//input[@id='susbscribe_email']");
    private final By homepageSubscribeButton = By.xpath("/html//button[@id='subscribe']");
    private final By homepageSubscriptionSuccessMessage = By.cssSelector("div#success-subscribe > .alert.alert-success");
    private final By cartLink = By.cssSelector(".nav.navbar-nav > li:nth-of-type(3) > a");
    private final By homepageSleevelessDressViewProductLink = By.cssSelector("[href='\\/product_details\\/3']");
    private final By homepageMenTshirtAddToCartButton = By.cssSelector(".features_items [class='col-sm-4']:nth-child(4) .text-center .add-to-cart");
    private final By homepageViewCartLink = By.xpath("/html//div[@id='cartModal']//a[@href='/view_cart']/u[.='View Cart']");
    private final By homepageContinueShoppingButton = By.cssSelector(".btn.btn-block.btn-success.close-modal");
    private final By homepageSleevelessDressAddToCart = By.cssSelector(".features_items [class='col-sm-4']:nth-child(5) .text-center .add-to-cart");


    public WebElement getLogoElement() {
        return driver.findElement(logo);
    }
    public void clickOnSignUpLoginLink(){
        element = driver.findElement(signUpLoginLink);
        element.click();
    }

    public WebElement getLoggedInAsUser(){
        return driver.findElement(loggedInAsUser);
    }

    public void clickOnDeleteAccountLink(){
        element = driver.findElement(deleteAccountLink);
        element.click();
    }

    public void clickOnLogoutUserLink(){
        element = driver.findElement(logoutUserLink);
        element.click();
    }

    public void clickOnContactUsLink() {
        element = driver.findElement(contactUsLink);
        element.click();
    }

    public void clickOnProductsLink() {
        element = driver.findElement(productsLink);
        element.click();
    }

    public WebElement getHomepageSubscriptionField() {
        return driver.findElement(homepageSubscriptionField);
    }

    public void setHomepageSubscriptionField(String value) {
        driver.findElement(homepageSubscriptionField).sendKeys(value);
    }

    public void clickOnHomepageSubscribeButton(){
        element = driver.findElement(homepageSubscribeButton);
        element.click();
    }

    public WebElement getHomepageSubscriptionSusccessMessage(){
        return driver.findElement(homepageSubscriptionSuccessMessage);
    }

    public void clickOnCartLink(){
        element = driver.findElement(cartLink);
        element.click();
    }

    public void clickOnHomepageSleevelessDressViewProductLink() {
        element = driver.findElement(homepageSleevelessDressViewProductLink);
        element.click();
    }

    public void clickOnHomepageMenTshirtAddToCartButton() {
        element = driver.findElement(homepageMenTshirtAddToCartButton);
        element.click();
    }

    public WebElement getHomepageViewCartLink() {
        return driver.findElement(homepageViewCartLink);
    }
    public void clickOnHomepageViewCartLink() {
        element = driver.findElement(homepageViewCartLink);
        element.click();
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(homepageContinueShoppingButton);
    }
    public void clickONHomepageContinueShoppingButton() {
        element = driver.findElement(homepageContinueShoppingButton);
        element.click();
    }

    public void clickOnSleevelessDressAddToCartButton() {
        element = driver.findElement(homepageSleevelessDressAddToCart);
        element.click();
    }
}
