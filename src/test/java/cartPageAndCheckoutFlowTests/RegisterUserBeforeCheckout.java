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

public class RegisterUserBeforeCheckout {

    static class Constant {

        private final static String WEBPAGE_URL = "https://automationexercise.com/";
        private final static String CART_URL = "https://automationexercise.com/view_cart";
        private static final String USERNAME = "Pete";
        private static final String EMAIL_ADDRESS = "2953@mliok.com";
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

    @Test
    /*
   1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill all details in Signup and create account
    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'ViewCart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify Address Details and Review Your Order
    13. Enter description in comment text area and click 'Place Order'
    14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    15. Click 'Pay and Confirm Order' button
    16. Verify success message 'Congratulations! Your order has been confirmed!'
    17. Click 'Delete Account' button
    18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    */
    public void RegisterUserBeforeCheckoutScenario() throws InterruptedException {
        driver.get(Constant.WEBPAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on correct webpage.");
        wait.until(ExpectedConditions.visibilityOf(homepage.getLogoElement()));

        System.out.println("Clicking on Signup/Login link");
        homepage.clickOnSignUpLoginLink();
        boolean a = signUpAndLoginPage.getSignUpTextElement().isDisplayed();
        if (a){
            System.out.println("The title 'New User Signup!' is visible.");
        } else {
            System.out.println("The title 'New User Signup!' is NOT visible.");
        }
        System.out.println("Populating mandatory fields");
        signUpAndLoginPage.getSignUpNameField().sendKeys(Constant.USERNAME);
        signUpAndLoginPage.getSignUpEmailField().sendKeys(Constant.EMAIL_ADDRESS);
        signUpAndLoginPage.clickOnSignUpButton();
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
            Thread.sleep(5000); // Wait for 5 seconds

            wait.until(ExpectedConditions.visibilityOf(homepage.getLoggedInAsUser()));
            if(homepage.getLoggedInAsUser().isDisplayed()) {
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

        boolean f = accountDeletePage.getAccountDeleteTitle().isDisplayed();
        if (f){
            System.out.println("The page title 'ACCOUNT DELETED!' is visible ");
        } else {
            System.out.println("The page title 'ACCOUNT DELETED!' NOT VISIBLE ");
        }
        accountDeletePage.clickOnContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), Constant.WEBPAGE_URL);
        System.out.println("The user is on homepage again.");

    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDownTest() {
//        System.out.println("Closing automationexercise.com webpage test");
//        driver.close();
//    }
}