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
import page_objects.Homepage;

import java.time.Duration;

public class HomepageSubscriptionTest {
    public static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String EMAIL_ADDRESS = "6394@mliok.com";
        private static final String SUBSCRIBE_SUCCESS_MESSAGE = "You have been successfully subscribed!";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;

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
    }

    @Test(description = "HomepageSubscriptionScenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Scroll down to footer
    5. Verify text 'SUBSCRIPTION'
    6. Enter email address in input and click arrow button
    7. Verify success message 'You have been successfully subscribed!' is visible
     */
    public void homepageSubscriptionScenario() {
        System.out.println("<-- Homepage Subscription Scenario --> ");
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");

        //Scrolling down to Subscription field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homepage.getHomepageSubscriptionField());
        homepage.getHomepageSubscriptionField().sendKeys(Constant.EMAIL_ADDRESS);
        System.out.println("Populating email address inside Subscription email address field.");
        homepage.clickOnHomepageSubscribeButton();
        System.out.println("Clicking on Submit button.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getHomepageSubscriptionSusccessMessage()));
        Assert.assertEquals(homepage.getHomepageSubscriptionSusccessMessage().getText(), Constant.SUBSCRIBE_SUCCESS_MESSAGE);
        System.out.println("Subscription success message appeared.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage .");
        driver.close();
    }
}





