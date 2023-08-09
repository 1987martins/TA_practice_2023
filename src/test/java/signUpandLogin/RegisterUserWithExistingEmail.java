package signUpandLogin;

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

public class RegisterUserWithExistingEmail {
    static class Constant {
        private static final String WEBPAGE_URL = "https://automationexercise.com/";
        private static final String USERNAME = "Pete";
        private static final String EMAIL_ADDRESS = "936394@mliok.com";
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
        private static final String ERROR_MESSAGE2 = "Email Address already exist!";

    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    SignupAndLoginPage signupandloginpage;
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
        signupandloginpage = new SignupAndLoginPage(driver);
        userAccountInfoPage = new UserAccountInfoPage(driver);
        accountConfirmationPage = new AccountConfirmationPage(driver);
        accountDeletePage = new AccountDeletePage(driver);
    }

    @Test
    // Register new user to test next test
    public void registerUserScenario() {
        driver.get(Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("Clicking on Signup/Login link");
        homepage.clickOnSignUpLoginLink();
        boolean a = signupandloginpage.getSignUpTextElement().isDisplayed();
        if (a){
            System.out.println("The title 'New User Signup!' is visible.");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible.");
        }
        System.out.println("Populating mandatory fields");
        signupandloginpage.getSignUpNameField().sendKeys(Constant.USERNAME);
        signupandloginpage.getSignUpEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        signupandloginpage.clickOnSignUpButton();
        boolean b = userAccountInfoPage.getEnterAccountInfoTitle().isDisplayed();
        if (b){
            System.out.println("The title 'ENTER ACCOUNT INFORMATION!' is visible.");
        } else {
            System.out.println("The title 'ENTER ACCOUNT INFORMATION!' is NOT visible.");
        }

        System.out.println("Populating mandatory fields on User detail form");
        userAccountInfoPage.clickOnMRGenderRadioButton();

        boolean usernameisvalid = userAccountInfoPage.getUserNameField().isDisplayed();
        if(usernameisvalid){
            System.out.println("The username is equal to entered name in SignUp page.");
        }else{
            System.out.println("The username is NOT equal to entered name in SignUp page.");
        }

        boolean emailisvalid = userAccountInfoPage.getUserEmailField().isDisplayed();
        if(emailisvalid){
            System.out.println("The email is equal to entered name in SignUp page.");
        }else{
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

        boolean c = accountConfirmationPage.getAccountCreatedTitle().isDisplayed();
        if (c){
            System.out.println("The page title 'ACCOUNT CREATED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT CREATED!' NOT VISIBLE ");
        }

        accountConfirmationPage.clickOnContinueButton();

        try {
            wait.until(ExpectedConditions.visibilityOf(homepage.getLoggedInAsUser()));
            if(homepage.getLoggedInAsUser().isDisplayed()) {
                System.out.println("User is looged in");
            } else {
                System.out.println("User has not been logged in");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        homepage.clickOnLogoutUserLink();
        System.out.println("User has logout from his profile");

        boolean ad = signupandloginpage.getSignUpTextElement().isDisplayed();
        if (ad){
            System.out.println("The title 'New User Signup!' is visible.");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible.");
        }

    }

    @Test
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible
    */
    public void registerUserWithExistingEmail() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");
        System.out.println("Clicking on Signup/Login link");
        homepage.clickOnSignUpLoginLink();
        boolean a = signupandloginpage.getSignUpTextElement().isDisplayed();
        if (a){
            System.out.println("The title 'New User Signup!' is visible.");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible.");
        }

        signupandloginpage.getSignUpNameField().sendKeys(Constant.USERNAME);
        signupandloginpage.getSignUpEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        signupandloginpage.clickOnSignUpButton();
        Assert.assertEquals(signupandloginpage.getErrorMessageText2().getText(), Constant.ERROR_MESSAGE2);
        boolean errorMessage2 = signupandloginpage.getErrorMessageText2().isDisplayed();
        if(errorMessage2){
            System.out.println("The error message 'Email Address already exist!' is visible.");
        }else{
            System.out.println("The error message 'Email Address already exist!' is NOT visible.");
        }

        //login in using correct data to delete user from database
        signupandloginpage.getLoginEmailAddressField().sendKeys(Constant.EMAIL_ADDRESS);
        signupandloginpage.getLoginPasswordField().sendKeys(Constant.PASSWORD);
        signupandloginpage.clickOnLoginButton();
        homepage.clickOnDeleteAccountLink();

        boolean f = accountDeletePage.getAccountDeleteTitle().isDisplayed();
        if (f){
            System.out.println("The page title 'ACCOUNT DELETED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT DELETED!' NOT VISIBLE ");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
       System.out.println("Closing automationexercise.com webpage test");
       driver.close();
   }
}



