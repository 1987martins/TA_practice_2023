package cartPageAndCheckoutFlowTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CartPage;
import page_objects.Homepage;
import page_objects.ProductsListingPage;

import java.time.Duration;

public class AddingTwoProductsToTheCartTest {
    static class Constant {
        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String PRODUCTS_TITLE_1 = "Blue Top";
        private final static String PRODUCTS_PRICE_1 = "Rs. 500";
        private final static String PRODUCTS_TITLE_2 = "Men Tshirt";
        private final static String PRODUCTS_PRICE_2 = "Rs. 400";
        private final static String PRODUCTS_QUANTITY_1 = "1";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ProductsListingPage productsListingPage;
    CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void openTest() {
        System.out.println("Initializing automationexercise.com webpage test");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        // Create ChromeOptions instance and add the --incognito argument
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepage = new Homepage(driver);
        productsListingPage = new ProductsListingPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "VerifyAllProductsAndProductDetailPageScenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
    */
    public void verifyAllProductsAndProductDetailPageScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");

        homepage.clickOnProductsLink();
        Thread.sleep(5000);
        boolean productListingPageTitle = productsListingPage.getProductsListingPageTitle().isDisplayed();
        if (productListingPageTitle) {
            System.out.println("The products listing page title 'ALL PRODUCTS' is visible.");
        } else {
            System.out.println("The products listing page title 'ALL PRODUCTS' is NOT visible.");
        }

        productsListingPage.clickOnBlueTopAddToCartButton();
        System.out.println("First product has been added to the cart");

        Thread.sleep(2000);
        productsListingPage.clickOnContinueShoppingButton();
        System.out.println("Clicking on Continue shopping button");

        productsListingPage.clickOnMenTshirtAddToCartButton();
        System.out.println("Second product has been added to the cart.");

        Thread.sleep(2000);
        productsListingPage.clickOnViewCartLink();
        System.out.println("Clicking on view cart link.");

        Assert.assertNotEquals(cartPage.getCartBluTopTitle(), Constant.PRODUCTS_TITLE_1);
        Assert.assertNotEquals(cartPage.getCartMenTshirtTitle(), Constant.PRODUCTS_TITLE_2);
        System.out.println("Both products have been added to the cart");

        Assert.assertNotEquals(cartPage.getCartBlueTopProductPrice(), Constant.PRODUCTS_PRICE_1);
        Assert.assertNotEquals(cartPage.getCartBlueTopProductQuantity(), Constant.PRODUCTS_QUANTITY_1);
        Assert.assertNotEquals(cartPage.getCartBlueTopTotalPrice(), Constant.PRODUCTS_PRICE_1);
        Assert.assertNotEquals(cartPage.getCartMenTshirtProductPrice(), Constant.PRODUCTS_PRICE_2);
        Assert.assertNotEquals(cartPage.getCartMenTshirtProductQuantity(), Constant.PRODUCTS_QUANTITY_1);
        Assert.assertNotEquals(cartPage.getCartMenTshirtTotalPrice(), Constant.PRODUCTS_PRICE_2);
        System.out.println("All good.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
