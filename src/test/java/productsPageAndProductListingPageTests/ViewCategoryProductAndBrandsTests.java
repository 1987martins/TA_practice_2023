package productsPageAndProductListingPageTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Homepage;
import page_objects.ProductBrandPage;
import page_objects.ProductCategoryPage;
import page_objects.ProductsListingPage;

import java.time.Duration;

public class ViewCategoryProductAndBrandsTests {

    static class Constant {

        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String CATEGORY_TITLE ="CATEGORY";
        private final static String BRANDS_TITLE ="Brands";
        private final static String CATEGORY_PRODUCT_PAGE_WOMEN_DRESS_TITLE = "Women - Dress Products";
        private final static String CATEGORY_PRODUCT_PAGE_MEN_TSHIRT_TITLE = "Men - Tshirts Products";
        private final static String BRAND_PRODUCT_PAGE_MADAME_TITLE = "Brand - Madame Products";
        private final static String BRAND_PRODUCT_PAGE_BABYHUG_TITLE = "Brand - Babyhug Products";
        private final static String PRODUCTS_PAGE_URL = "https://automationexercise.com/products";

    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ProductCategoryPage productCategoryPage;
    ProductsListingPage productsListingPage;
    ProductBrandPage productBrandPage;


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
        productCategoryPage = new ProductCategoryPage(driver);
        productsListingPage = new ProductsListingPage(driver);
        productBrandPage = new ProductBrandPage(driver);
    }

    @Test
    /*
   1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that categories are visible on left side bar
    4. Click on 'Women' category
    5. Click on any category link under 'Women' category, for example: Dress
    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page
    */
    public void ViewCategoryProductScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homepage.getHomepageCategoryTitle());
        Assert.assertNotEquals(homepage.getHomepageCategoryTitle(), Constant.CATEGORY_TITLE);
        homepage.clickOnHomepageWomenCategory();
        System.out.println("Opening Womens categories on left side of the page.");

        wait.until(ExpectedConditions.visibilityOf(homepage.getHomepageWomenCategoryDress()));
        homepage.clickOnHomepageWomenCategoryDress();
        System.out.println("Clicking on Dress subcategory of Womens category.");

        Assert.assertNotEquals(productCategoryPage.getProductCategoryPageTitle(), Constant.CATEGORY_PRODUCT_PAGE_WOMEN_DRESS_TITLE);
        System.out.println("User has landed on Women - Dress products page.");

        Thread.sleep(5000);

        homepage.clickOnHomepageMenCategory();
        System.out.println("Opening Mens categories on left side of the page.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getHomepageMenCategoryTshirts()));
        System.out.println("Clicking on Tshirts subcategory of Mens category.");
        homepage.clickOnHomepageMenCategoryTshirts();

        Assert.assertNotEquals(productCategoryPage.getProductCategoryPageTitle(), Constant.CATEGORY_PRODUCT_PAGE_MEN_TSHIRT_TITLE);
        System.out.println("User has landed on Men - Tshirts products page.");
    }

    @Test
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify that Brands are visible on left side bar
    5. Click on any brand name
    6. Verify that user is navigated to brand page and brand products are displayed
    7. On left side bar, click on any other brand link
    8. Verify that user is navigated to that brand page and can see products
    */
    public void ViewBrandProductsScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        homepage.clickOnProductsLink();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.PRODUCTS_PAGE_URL);
        System.out.println("User has landed n Products page.");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productsListingPage.getProductsBrandsTitle());
        Assert.assertNotEquals(productsListingPage.getProductsBrandsTitle(), Constant.BRANDS_TITLE);
        System.out.println("Locating Brands section on left side of the page.");

        productsListingPage.clickOnProductBrandMadameLink();
        System.out.println("Clicking on Madame subcategory of Brands category.");
        Assert.assertNotEquals(productBrandPage.getProductBrandPageTitle(), Constant.BRAND_PRODUCT_PAGE_MADAME_TITLE);
        System.out.println("User has landed on Madame brand products page.");

        productsListingPage.clickOnProductBrandBabyhugLink();
        System.out.println("Clicking on Babyhug subcategory of Brands category.");
        wait.until(ExpectedConditions.visibilityOf(productBrandPage.getProductBrandPageTitle()));
        Assert.assertNotEquals(productBrandPage.getProductBrandPageTitle(), Constant.BRAND_PRODUCT_PAGE_BABYHUG_TITLE);
        System.out.println("User has landed on Babyhug brand products page.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
