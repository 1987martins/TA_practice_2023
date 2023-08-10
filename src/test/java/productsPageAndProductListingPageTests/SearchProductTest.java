package productsPageAndProductListingPageTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Homepage;
import page_objects.ProductsDetailsPage;
import page_objects.ProductsListingPage;
import page_objects.SearchResultPage;

import java.time.Duration;

public class SearchProductTest {

    static class Constant {

        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String SEARCH_ITEM_TEXT ="Winter top";
        private final static String SEARCH_RESULT_ITEMS_TITLE = "Winter Top";

    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ProductsListingPage productslistingpage;
    ProductsDetailsPage productsdetailspage;
    SearchResultPage searchresultpage;
    Actions actions;

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
        productslistingpage = new ProductsListingPage(driver);
        productsdetailspage = new ProductsDetailsPage(driver);
        searchresultpage = new SearchResultPage(driver);
        actions = new Actions(driver);
    }

    @Test
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible
    */
    public void VerifyAllProductsAndProductDetailPageScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        homepage.clickOnProductsLink();
        Thread.sleep(5000);
        boolean productlistingpagetitle = productslistingpage.getProductsListingPageTitle().isDisplayed();
        if(productlistingpagetitle){
            System.out.println("The products listing page title 'ALL PRODUCTS' is visible.");
        }else{
            System.out.println("The products listing page title 'ALL PRODUCTS' is NOT visible.");
        }
//        wait.until(ExpectedConditions.elementToBeClickable(productslistingpage.getSearchInputField()));
//        productslistingpage.getProductsListingPageTitle().sendKeys(Constant.SEARCH_ITEM_TEXT);
        actions.moveToElement(productslistingpage.getSearchInputField()).click().perform();
        productslistingpage.getSearchInputField().sendKeys(Constant.SEARCH_ITEM_TEXT);
        productslistingpage.clickOnSearchButton();

        boolean searchresultpagetitle = searchresultpage.getSearchResultPageTitle().isDisplayed();
        if(searchresultpagetitle){
            System.out.println("The search result page title 'SEARCHED PRODUCTS' is visible.");
        }else{
            System.out.println("The search result page title 'SEARCHED PRODUCTS' is NOT visible.");
        }

        Assert.assertNotEquals(searchresultpage.getSearchResultPageProductTitle(), Constant.SEARCH_RESULT_ITEMS_TITLE);
        System.out.println("Search results are correct");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
