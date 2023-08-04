package signUpandLogin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Homepage;
import page_objects.SignupAndLoginPage;
import page_objects.UserAccountInfoPage;

import java.time.Duration;

public class RegisterUserTest {

    static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String USERNAME = "Pete";
        private static final String EMAIL_ADDRESS = "secini6394@mliok.com";
        private static final String PASSWORD = "123@derek@";
        private static final String DAY_OF_BIRTH = "20";
        private static final String MONTH_OF_BIRTH = "May";
        private static final String YEAR_OF_BIRTH = "1970";
        private static final String FIRST_NAME = "Peter";
        private static final String LAST_NAME = "Doe";
        private static final String ADDRESS_1 = "Donner street 123";
        private static final String COUNTRY = "Canada";
        private static final String STATE = "Upper";
        private static final String CITY = "Montereal";
        private static final String ZIPCODE = "125487";
        private static final String MOBILE_NUMBER = "623479384921304914";

    }


    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    SignupAndLoginPage signupandloginpage;
    UserAccountInfoPage userAccountInfoPage;




    @BeforeMethod(alwaysRun = true)
    public void openTest() {
        System.out.println("Initializing automationexercise.com webpage test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepage = new Homepage(driver);
        signupandloginpage = new SignupAndLoginPage(driver);
        userAccountInfoPage = new UserAccountInfoPage(driver);


    }

    @Test
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    */
    public void registerUserScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("Clicking on Signup/Login link");
        homepage.getSignUpLoginElement().click();
        boolean i = signupandloginpage.getSignUpTextElement().isDisplayed();
        if (i){
            System.out.println("The title 'New User Signup!' is visible");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible");
        }
        System.out.println("Populating mandatory fields");
        signupandloginpage.getSignUpNameField().sendKeys(Constant.USERNAME);
        signupandloginpage.getSignUpEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        signupandloginpage.clickOnSignUpButton();





    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }

}



