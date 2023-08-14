package cartPageAndCheckoutFlowTests;

import org.openqa.selenium.WebElement;
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

public class LoginBeforeCheckout {
    static class Constant {
        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String CART_URL = "https://automationexercise.com/view_cart";
        private static final String USERNAME = "Pete";
        private static final String EMAIL_ADDRESS = "MR47@mliok.com";
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
        private final static String PRODUCTS_TITLE_2 = "Men Tshirt";
        private final static String COMMENT_ABOUT_ORDER = "Cannot wait to wear it.";
        public final static String NAME_OF_CARD = "Peter Crown";
        public final static String CARD_NUMBER = "4111 1111 1111 1111";
        public final static String CVC_NUMBER = "308";
        public final static String MONTH_OF_EXPIRATION = "06";
        public final static String YEAR_OF_EXPIRATION = "2030";
        public final static String ORDER_SUCCESS_MESSAGE = "Congratulations! Your order has been confirmed!";
    }

    ChromeDriver driver;
    WebDriverWait wait;
    Homepage homepage;
    CartPage cartPage;
    SignupAndLoginPage signUpAndLoginPage;
    UserAccountInfoPage userAccountInfoPage;
    AccountConfirmationPage accountConfirmationPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    AccountDeletePage accountDeletePage;
    OrderConfirmPage orderConfirmPage;


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
        signUpAndLoginPage = new SignupAndLoginPage(driver);
        userAccountInfoPage = new UserAccountInfoPage(driver);
        accountConfirmationPage = new AccountConfirmationPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        accountDeletePage = new AccountDeletePage(driver);
        orderConfirmPage = new OrderConfirmPage(driver);

    }

    @Test(description = "RegisterUserForNextTestScenario", priority = 1)
    // Register new user to test next test
    public void registerUserForNextTestScenario() {
        System.out.println("Creating User data for next test");
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
        homepage.clickOnLogoutUserLink();
        System.out.println("User has logout from his profile");
        System.out.println("User data has been created for next test");
    }

    @Test(description = "LoginBeforeCheckoutScenario", priority = 2)
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill email, password and click 'Login' button
    6. Verify 'Logged in as username' at top
    7. Add products to cart
    8. Click 'Cart' button
    9. Verify that cart page is displayed
    10. Click Proceed To Checkout
    11. Verify Address Details and Review Your Order
    12. Enter description in comment text area and click 'Place Order'
    13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    14. Click 'Pay and Confirm Order' button
    15. Verify success message 'Your order has been placed successfully!'
    16. Click 'Delete Account' button
    17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    */
    public void loginBeforeCheckoutScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));
        System.out.println("The user is on correct webpage.");

        homepage.clickOnSignUpLoginLink();
        boolean loginText = signUpAndLoginPage.getLoginText().isDisplayed();
        if (loginText) {
            System.out.println("The title 'Login to your account' is visible.");
        } else {
            System.out.println("The title 'Login to your account' is NOT visible.");
        }

        signUpAndLoginPage.getLoginEmailAddressField().sendKeys(Constant.EMAIL_ADDRESS);
        signUpAndLoginPage.getLoginPasswordField().sendKeys(Constant.PASSWORD);
        signUpAndLoginPage.clickOnLoginButton();

        try {
            wait.until(ExpectedConditions.visibilityOf(homepage.getLoggedInAsUser()));
            if (homepage.getLoggedInAsUser().isDisplayed()) {
                System.out.println("User is looged in");
            } else {
                System.out.println("User has not been logged in");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        homepage.clickOnHomepageMenTshirtAddToCartButton();
        System.out.println("Adding product to the cart");

        wait.until(ExpectedConditions.visibilityOf(homepage.getHomepageViewCartLink()));
        homepage.clickOnHomepageViewCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), Constant.CART_URL);
        System.out.println("User has landed on the Cart page");

        cartPage.clickOnCartProceedToCheckout();

        System.out.println("Verifying Delivery and Invoice Addresses.");
        WebElement deliveryAddressElement = checkoutPage.getDeliveryAddressField();
        String deliveryAddress = deliveryAddressElement.getText();
        String[] deliveryAddressLines = deliveryAddress.split("\n");
        String deliveryName = deliveryAddressLines[1];
        String deliveryStreet = deliveryAddressLines[2];
        String deliveryCityZip = deliveryAddressLines[3];
        String deliveryCountry = deliveryAddressLines[4];
        String deliveryPhone = deliveryAddressLines[5];

        if (Constant.FIRST_NAME.contains(deliveryName) ||
                Constant.ADDRESS_1.contains(deliveryStreet) ||
                Constant.CITY.contains(deliveryCityZip) ||
                Constant.COUNTRY.contains(deliveryCountry) ||
                Constant.MOBILE_NUMBER.contains(deliveryPhone)) {
            System.out.println("Delivery address matches account information.");
        } else {
            System.out.println("Delivery address does not match account information.");
        }

        WebElement invoiceAddressElement = checkoutPage.getInvoiceAddressField();
        String invoiceAddress = invoiceAddressElement.getText();
        String[] invoiceAddressLines = invoiceAddress.split("\n");
        String invoiceName = invoiceAddressLines[1];
        String invoiceStreet = invoiceAddressLines[2];
        String invoiceCityZip = invoiceAddressLines[3];
        String invoiceCountry = invoiceAddressLines[4];
        String invoicePhone = invoiceAddressLines[5];

        if (Constant.FIRST_NAME.contains(invoiceName) ||
                Constant.ADDRESS_1.contains(invoiceStreet) ||
                Constant.CITY.contains(invoiceCityZip) ||
                Constant.COUNTRY.contains(invoiceCountry) ||
                Constant.MOBILE_NUMBER.contains(invoicePhone)) {
            System.out.println("Invoice address matches account information.");
        } else {
            System.out.println("Invoice address does not match account information.");
        }

        Assert.assertNotEquals(checkoutPage.getCheckoutMenTshirtTitle(), Constant.PRODUCTS_TITLE_2);
        checkoutPage.getCheckoutLeaveCommentField().sendKeys(Constant.COMMENT_ABOUT_ORDER);
        checkoutPage.clickOnPlaceOrderButton();
        Thread.sleep(5000);

        System.out.println("Populating Card info.");
        paymentPage.getPaymentNameOnCard().sendKeys(Constant.NAME_OF_CARD);
        paymentPage.getPaymentCardNumber().sendKeys(Constant.CARD_NUMBER);
        paymentPage.getPaymentCVCNumber().sendKeys(Constant.CVC_NUMBER);
        paymentPage.getPaymentMonthOfExpiration().sendKeys(Constant.MONTH_OF_EXPIRATION);
        paymentPage.getPaymentYearOfExpiration().sendKeys(Constant.YEAR_OF_EXPIRATION);
        System.out.println("All madatory fields of Card info have been populated");

        paymentPage.clickOnPayAndConfirmOrderButton();
        System.out.println("Clicking on Pay and Confirm Order button.");
        wait.until(ExpectedConditions.visibilityOf(orderConfirmPage.getOrderConfirmSuccessMessage()));
        Assert.assertEquals(orderConfirmPage.getOrderConfirmSuccessMessage().getText(), Constant.ORDER_SUCCESS_MESSAGE);
        System.out.println("Order completion success message appeared.");

        homepage.clickOnDeleteAccountLink();

        boolean accountDelete = accountDeletePage.getAccountDeleteTitle().isDisplayed();
        if (accountDelete) {
            System.out.println("The page title 'ACCOUNT DELETED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT DELETED!' NOT VISIBLE ");
        }
        accountDeletePage.clickOnContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on homepage again.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        System.out.println("Closing automationexercise.com webpage test");
        driver.close();
    }
}
