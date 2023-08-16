package subscriptionTests;

import org.openqa.selenium.JavascriptExecutor;
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

import java.time.Duration;

public class CartSubscriptionTest {
    public static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String EMAIL_ADDRESS = "man@mliok.com";
        private static final String SUBSCRIBE_SUCCESS_MESSAGE = "You have been successfully subscribed!";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
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
    }

    @Test(description = "Cart Subscription Scenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Cart' button
    5. Scroll down to footer
    6. Verify text 'SUBSCRIPTION'
    7. Enter email address in input and click arrow button
    8. Verify success message 'You have been successfully subscribed!' is visible
     */
    public void cartSubscriptionScenario() {
        System.out.println("<-- Cart Subscription Scenario -->");
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");

        homepage.clickOnCartLink();
        System.out.println("Opening Cart page");

        //Scrolling down to Subscription field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homepage.getHomepageSubscriptionField());
        cartPage.getCartSubscriptionField().sendKeys(Constant.EMAIL_ADDRESS);
        System.out.println("Populating email address inside Subscription email address field.");
        cartPage.clickOnCartSubscribeButton();
        System.out.println("Clicking on Submit button.");
        wait.until(ExpectedConditions.visibilityOf(cartPage.getCartSubscriptionSuccessMessage()));
        Assert.assertEquals(cartPage.getCartSubscriptionSuccessMessage().getText(), Constant.SUBSCRIBE_SUCCESS_MESSAGE);
        System.out.println("Subscription success message appeared.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage .");
        driver.close();
    }
}





