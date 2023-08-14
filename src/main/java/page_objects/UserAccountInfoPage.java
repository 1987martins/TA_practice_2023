package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAccountInfoPage {

    private WebDriver driver;
    private WebElement element;


    public UserAccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By enterAccountInfoTitle = By.cssSelector(".login-form > .text-center.title > b");
    private final By mrGenderRadioButton = By.xpath("//*[@id=\"uniform-id_gender1\"]");
    private final By mrsGenderRadioButton = By.xpath("//*[@id=\"uniform-id_gender2\"]");
    private final By userNameField = By.xpath("//*[@id=\"name\"]");
    private final By userEmailField = By.xpath("//*[@id=\"email\"]");
    private final By passwordField = By.xpath("//*[@id=\"password\"]");
    private final By userDayOfBirthDropdownMenu = By.xpath("//*[@id=\"days\"]");
    private final By userMonthOfBirthDropdownMenu = By.xpath("//*[@id=\"months\"]");
    private final By userYearOfBirthDropdownMenu = By.xpath("//*[@id=\"years\"]");
    private final By signupForNewsletterCheckbox = By.xpath("//*[@id=\"newsletter\"]");
    private final By specialOffersCheckbox = By.xpath("//*[@id=\"optin\"]");
    private final By firstNameField = By.xpath("//*[@id=\"first_name\"]");
    private final By lastNameField = By.xpath("//*[@id=\"last_name\"]");
    private final By addressField1 = By.xpath("//*[@id=\"address1\"]");
    private final By countryDropdownMenu = By.xpath("//*[@id=\"country\"]");
    private final By stateField = By.xpath("//*[@id=\"state\"]");
    private final By cityField = By.xpath("//*[@id=\"city\"]");
    private final By zipCodeField = By.xpath("//*[@id=\"zipcode\"]");
    private final By mobileNumberField = By.xpath("//*[@id=\"mobile_number\"]");
    private final By createAccountButton = By.cssSelector("section#form > .container form[method='post'] > .btn.btn-default");

    public WebElement getEnterAccountInfoTitle() {
        return driver.findElement(enterAccountInfoTitle);
    }

    public WebElement getMrGenderRadioButton() {
        return driver.findElement(mrGenderRadioButton);
    }

    public void clickOnMRGenderRadioButton() {
        element = driver.findElement(mrGenderRadioButton);
        element.click();
    }

    public WebElement getMrsGenderRadioButton() {
        return driver.findElement(mrsGenderRadioButton);
    }

    public void clickOnMRSGenderRadioButton(){
        element = driver.findElement(mrsGenderRadioButton);
        element.click();
    }

    public WebElement getUserNameField() {
        return  driver.findElement(userNameField);
    }

    public void setUserNameField(String value) {
        driver.findElement(userNameField).sendKeys(value);
    }

    public WebElement getUserEmailField() {
        return driver.findElement(userEmailField);
    }

    public void setEmailField(String value) {
        driver.findElement(userEmailField).sendKeys(value);
    }

    public WebElement getUserDayOfBirthDropdownMenu() {
        return driver.findElement(userDayOfBirthDropdownMenu);
    }

    public void setUserDayOfBirthDropdownMenu(String value) {
        driver.findElement(userDayOfBirthDropdownMenu).sendKeys(value);
    }

    public WebElement getUserMonthOfBirthDropdownMenu() {
         return driver.findElement(userMonthOfBirthDropdownMenu);
    }

    public void setUserMonthOfBirthDropdownMenu(String value) {
        driver.findElement(userMonthOfBirthDropdownMenu).sendKeys(value);
    }

    public WebElement getUserYearOfBirthDropdownMenu() {
        return driver.findElement(userYearOfBirthDropdownMenu);
    }

    public void setUserYearOfBirthDropdownMenu(String value) {
        driver.findElement(userYearOfBirthDropdownMenu).sendKeys(value);
    }

    public void clickOnsignupForNewsletterCheckbox() {
        element = driver.findElement(signupForNewsletterCheckbox);
        element.click();
    }

    public void clickOnSpecialOffersCheckbox() {
        element = driver.findElement(specialOffersCheckbox);
        element.click();
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public void setFirstNameField(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public void setLastNameField(String value) {
        driver.findElement(lastNameField).sendKeys(value);
    }

    public WebElement getAddressField1() {
        return driver.findElement(addressField1);
    }

    public void setAddressField1(String value) {
        driver.findElement(addressField1).sendKeys(value);
    }

    public WebElement getCountryDropdownMenu() {
        return driver.findElement(countryDropdownMenu);
    }

    public void setCountryDropdownMenu(String value) {
        driver.findElement(countryDropdownMenu).sendKeys(value);
    }

    public WebElement getStateField() {
        return driver.findElement(stateField);
    }

    public void setStateField(String value) {
        driver.findElement(stateField).sendKeys(value);
    }

    public WebElement getCityField() {
        return driver.findElement(cityField);
    }

    public void setCityField(String value) {
        driver.findElement(cityField).sendKeys(value);
    }

    public WebElement getZipCodeField() {
        return driver.findElement(zipCodeField);
    }

    public void setZipCodeField(String value) {
        driver.findElement(zipCodeField).sendKeys(value);
    }

    public WebElement getMobileNumberField() {
        return driver.findElement(mobileNumberField);
    }

    public void setMobileNumberField(String value) {
        driver.findElement(mobileNumberField).sendKeys(value);
    }

    public void clickOnCreateAccountButton() {
        element = driver.findElement(createAccountButton);
        element.click();
    }

    public WebElement getPasswordField(){
        return driver.findElement(passwordField);
    }

    public void setPasswordField(String value) {
        driver.findElement(passwordField).sendKeys(value);
    }
}