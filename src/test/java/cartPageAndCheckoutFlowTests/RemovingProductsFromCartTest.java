package cartPageAndCheckoutFlowTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class RemovingProductsFromCartTest {

    static class Constant {

        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String PRODUCTS_TITLE_1 = "Men Tshirt";
        private final static String PRODUCTS_TITLE_2 = "Sleeveless Dress";
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

    @Test
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click 'X' button corresponding to particular product
    8. Verify that product is removed from the cart
    */
    public void RemovingProductsFromCartScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        homepage.clickOnHomepageMenTshirtAddToCartButton();
        System.out.println("Adding product to the cart.");

        wait.until(ExpectedConditions.visibilityOf(homepage.getContinueShoppingButton()));
        homepage.clickONHomepageContinueShoppingButton();
        System.out.println("Continue shopping and add second product.");

        homepage.clickOnSleevelessDressAddToCartButton();
        System.out.println("Adding second product to the cart.");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(homepage.getHomepageViewCartLink()));
        homepage.clickOnHomepageViewCartLink();

        Assert.assertNotEquals(cartPage.getCartMenTshirtTitle(), Constant.PRODUCTS_TITLE_1);
        Assert.assertNotEquals(cartPage.getCartSleevelessDressTitle(), Constant.PRODUCTS_TITLE_2);

        cartPage.clickOnDeleteProductFromCartButton1();
        System.out.println("Removing first product from the cart.");
        cartPage.clickOnDeleteProductFromCartButton2();
        System.out.println("Removing second product from the cart.");

        wait.until(ExpectedConditions.visibilityOf(cartPage.getCartEmptyCartMessageText()));
        boolean emptyCartMessage = cartPage.getCartEmptyCartMessageText().isDisplayed();
        if(emptyCartMessage){
            System.out.println("Products removed successfully and Empty cart message is visible");
        } else {
            System.out.println("Products removal failed.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
