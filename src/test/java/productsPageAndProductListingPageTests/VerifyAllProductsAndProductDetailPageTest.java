package productsPageAndProductListingPageTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Homepage;
import page_objects.ProductsDetailsPage;
import page_objects.ProductsListingPage;

import java.time.Duration;

public class VerifyAllProductsAndProductDetailPageTest {
    static class Constant {
        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String PRODUCTS_DETAILS_PAGE_1_URL = "https://automationexercise.com/product_details/1";
        private final static String PRODUCTS_TITLE_1 = "Blue Top";
        private final static String PRODUCTS_CATEGORY_1 = "Category: Women > Tops";
        private final static String PRODUCTS_PRICE_1 = "Rs. 500";
        private final static String PRODUCTS_AVAILABILITY_1 = " In Stock";
        private final static String PRODUCTS_CONDITIONS_1 = " New";
        private final static String PRODUCTS_BRAND_1 = " Polo";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ProductsListingPage productsListingPage;
    ProductsDetailsPage productsDetailsPage;

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
        productsDetailsPage = new ProductsDetailsPage(driver);
    }

    @Test(description = "VerifyAllProductsAndProductDetailPageScenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that product details is visible: product name, category, price, availability, condition, brand
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

        boolean productsList = productsListingPage.getProductsList().isDisplayed();
        if (productsList) {
            System.out.println("Product list is Displayed");
        } else {
            System.out.println("Products list is NOT Displayed");
        }

        productsListingPage.clickOnBlueTopViewProductButton();
        System.out.println("User click one 'View Product' button to view products detail page.");
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.PRODUCTS_DETAILS_PAGE_1_URL);
        System.out.println("User has landed on first  products detail page");

        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsName(), Constant.PRODUCTS_TITLE_1);
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsCategory(), Constant.PRODUCTS_CATEGORY_1);
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsPrice(), Constant.PRODUCTS_PRICE_1);
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsAvailability(), Constant.PRODUCTS_AVAILABILITY_1);
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsCondition(), Constant.PRODUCTS_CONDITIONS_1);
        Assert.assertNotEquals(productsDetailsPage.getDetailPageProductsBrand(), Constant.PRODUCTS_BRAND_1);
        System.out.println("All product details are visible");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
