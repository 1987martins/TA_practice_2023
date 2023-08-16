package signUpandLoginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.*;

import java.time.Duration;

public class RegisterUserTest {
    public static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String USERNAME = "Pete";
        private static final String EMAIL_ADDRESS = "MR6394@mliok.com";
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
        private static final String MOBILE_NUMBER = "629384921304914";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    SignupAndLoginPage signUpAndLoginPage;
    UserAccountInfoPage userAccountInfoPage;
    AccountConfirmationPage accountConfirmationPage;
    AccountDeletePage accountDeletePage;

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
        signUpAndLoginPage = new SignupAndLoginPage(driver);
        userAccountInfoPage = new UserAccountInfoPage(driver);
        accountConfirmationPage = new AccountConfirmationPage(driver);
        accountDeletePage = new AccountDeletePage(driver);
    }

    @Test(description = "Register User Scenario")
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
    public void registerUserScenario() {
        System.out.println("<-- Register User Scenario -->");
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");

        homepage.clickOnSignUpLoginLink();
        System.out.println("Clicking on Signup/Login link");
        boolean signUpText = signUpAndLoginPage.getSignUpTextElement().isDisplayed();
        if (signUpText) {
            System.out.println("The title 'New User Signup!' is visible.");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible.");
        }
        System.out.println("Populating mandatory fields");
        signUpAndLoginPage.getSignUpNameField().sendKeys(Constant.USERNAME);
        signUpAndLoginPage.getSignUpEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        signUpAndLoginPage.clickOnSignUpButton();
        boolean enterAccountInfo = userAccountInfoPage.getEnterAccountInfoTitle().isDisplayed();
        if (enterAccountInfo) {
            System.out.println("The title 'ENTER ACCOUNT INFORMATION!' is visible.");
        } else {
            System.out.println("The title 'ENTER ACCOUNT INFORMATION!' is NOT visible.");
        }

        System.out.println("Populating mandatory fields on User detail form");
        userAccountInfoPage.clickOnMRGenderRadioButton();

        boolean userNameIsValid = userAccountInfoPage.getUserNameField().isDisplayed();
        if (userNameIsValid) {
            System.out.println("The username is equal to entered name in SignUp page.");
        } else {
            System.out.println("The username is NOT equal to entered name in SignUp page.");
        }

        boolean emailIsValid = userAccountInfoPage.getUserEmailField().isDisplayed();
        if (emailIsValid) {
            System.out.println("The email is equal to entered name in SignUp page.");
        } else {
            System.out.println("The email is NOT equal to entered name in SignUp page.");
        }
        userAccountInfoPage.getPasswordField().sendKeys(Constant.PASSWORD);

        Select dateOfBirth = new Select(userAccountInfoPage.getUserDayOfBirthDropdownMenu());
        dateOfBirth.selectByVisibleText(Constant.DAY_OF_BIRTH);
        Select monthOfBirth = new Select(userAccountInfoPage.getUserMonthOfBirthDropdownMenu());
        monthOfBirth.selectByVisibleText(Constant.MONTH_OF_BIRTH);
        Select yearOfBirth = new Select(userAccountInfoPage.getUserYearOfBirthDropdownMenu());
        yearOfBirth.selectByVisibleText(Constant.YEAR_OF_BIRTH);

        userAccountInfoPage.clickOnsignupForNewsletterCheckbox();
        userAccountInfoPage.clickOnSpecialOffersCheckbox();
        userAccountInfoPage.getFirstNameField().sendKeys(Constant.FIRST_NAME);
        userAccountInfoPage.getLastNameField().sendKeys(Constant.LAST_NAME);
        userAccountInfoPage.getAddressField1().sendKeys(Constant.ADDRESS_1);

        Select country = new Select(userAccountInfoPage.getCountryDropdownMenu());
        country.selectByVisibleText(Constant.COUNTRY);

        userAccountInfoPage.getStateField().sendKeys(Constant.STATE);
        userAccountInfoPage.getCityField().sendKeys(Constant.CITY);
        userAccountInfoPage.getZipCodeField().sendKeys(Constant.ZIPCODE);
        userAccountInfoPage.getMobileNumberField().sendKeys(Constant.MOBILE_NUMBER);

        userAccountInfoPage.clickOnCreateAccountButton();

        boolean accountCreated = accountConfirmationPage.getAccountCreatedTitle().isDisplayed();
        if (accountCreated) {
            System.out.println("The page title 'ACCOUNT CREATED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT CREATED!' NOT VISIBLE ");
        }

        accountConfirmationPage.clickOnContinueButton();

        try {
            Thread.sleep(5000); // Wait for 5 seconds

            wait.until(ExpectedConditions.visibilityOf(homepage.getLoggedInAsUser()));
            if (homepage.getLoggedInAsUser().isDisplayed()) {
                System.out.println("User is looged in");
            } else {
                System.out.println("User has not been logged in");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        homepage.clickOnDeleteAccountLink();

        boolean accountDelete = accountDeletePage.getAccountDeleteTitle().isDisplayed();
        if (accountDelete) {
            System.out.println("The page title 'ACCOUNT DELETED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT DELETED!' NOT VISIBLE ");
        }
        accountDeletePage.clickOnContinueButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}




