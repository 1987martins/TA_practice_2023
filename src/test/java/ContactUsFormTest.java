import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.*;

import java.time.Duration;

public class ContactUsFormTest {
    public static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String USERNAME = "Peter";
        private static final String EMAIL_ADDRESS = "936394@mliok.com";
        private static final String CONTACT_US_SUBJECT = "Question about returning purchased item";
        private static final String CONTACT_US_MESSAGE = "What are steps to return purchased item and getting back my money";
        private static final String PATH_TO_FILE = "C:\\Users\\User\\Desktop\\OneDRIVE\\My Own Programming Work\\TA_practice_2023\\resources\\20160318_084612.jpg";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    ContactUsForm contactUsForm;
    Alert alert;


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
        contactUsForm = new ContactUsForm(driver);
    }

    @Test(description = "ContactUsFormScenario")
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */
    public void contactUsFormScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");
        homepage.clickOnContactUsLink();

        boolean a = contactUsForm.getContactUsTitle().isDisplayed();
        if (a) {
            System.out.println("The title 'GET IN TOUCH' is visible.");
        } else {
            System.out.println("The title 'GET IN TOUCH' is NOT visible.");
        }
        System.out.println("Populating all contact us form fields with data.");
        contactUsForm.getContactUsNameField().sendKeys(Constant.USERNAME);
        contactUsForm.getContactUsEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        contactUsForm.getContactUsSubjectField().sendKeys(Constant.CONTACT_US_SUBJECT);
        contactUsForm.getContactUsMessageField().sendKeys(Constant.CONTACT_US_MESSAGE);
        contactUsForm.getContactUsChooseFileButton().sendKeys(Constant.PATH_TO_FILE);
        contactUsForm.clickOnContactUsSubmitButton();
        Thread.sleep(2000);
        System.out.println("Accepting alert pop window");
        alert = driver.switchTo().alert();
        alert.accept();

        boolean contactusuccessmessage = contactUsForm.getContactUsSuccessMessage().isDisplayed();
        if (contactusuccessmessage) {
            System.out.println("The error message 'Success! Your details have been submitted successfully.' is visible.");
        } else {
            System.out.println("The error message 'Success! Your details have been submitted successfully.' is NOT visible.");
        }
        contactUsForm.clickOnContactUsHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("User is on homepage");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}





