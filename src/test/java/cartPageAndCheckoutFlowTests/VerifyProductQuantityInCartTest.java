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
import page_objects.ProductsDetailsPage;

import java.time.Duration;

public class VerifyProductQuantityInCartTest {
    static class Constant {
        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String WEBPAGE_URL_FOR_PDP_3 = "https://automationexercise.com/product_details/3";
        private final static String PRODUCTS_TITLE_3 = "Sleeveless Dress";
        private final static String PRODUCTS_QUANTITY_3 = "4";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ProductsDetailsPage productsDetailsPage;
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
        cartPage = new CartPage(driver);
        productsDetailsPage = new ProductsDetailsPage(driver);
    }

    @Test(description = "VerifyProductQuantityInCartTestScenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
    */
    public void verifyProductQuantityInCartTestScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        homepage.clickOnHomepageSleevelessDressViewProductLink();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL_FOR_PDP_3);
        System.out.println("User has landed on products detail page.");
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsName(), Constant.PRODUCTS_TITLE_3);

        productsDetailsPage.clearDetailPageProductsQuantity();
        productsDetailsPage.getDetailPageProductsQuantity().sendKeys(Constant.PRODUCTS_QUANTITY_3);
        System.out.println("Increasing products quantity");
        productsDetailsPage.clickOnDetailPageAddToCartButton();
        System.out.println("Adding chosen product to the cart");
        Thread.sleep(2000);
        productsDetailsPage.clickOnDetailPageViewCartLink();

        Assert.assertNotEquals(cartPage.getCartSleevelessDressTitle(), Constant.PRODUCTS_TITLE_3);
        System.out.println("Correct product has been added to the cart.");
        Assert.assertNotEquals(cartPage.getCartSleevelessDressQuantity(), Constant.PRODUCTS_QUANTITY_3);
        System.out.println("There is correct product quantity  in the cart");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
