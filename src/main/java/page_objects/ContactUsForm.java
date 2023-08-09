package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsForm {
    private WebDriver driver;
    private WebElement element;

    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    private final By contactUsNameField = By.xpath("//form[@id='contact-us-form']//input[@name='name']");
    private final By contactUsEmailField = By.xpath("//form[@id='contact-us-form']//input[@name='email']");
    private final By contactUsSubjectField = By.xpath("//form[@id='contact-us-form']//input[@name='subject']");
    private final By contactUsMessageField = By.xpath("/html//textarea[@id='message']");
    private final By contactUsChooseFileButton = By.cssSelector("input[name='upload_file']");
    private final By contactUsSubmitButton = By.xpath("//form[@id='contact-us-form']//input[@name='submit']");
    private final By contactUsSuccessMessage = By.cssSelector(".alert.alert-success.status");
    private final By contactUsHomeButton = By.xpath("//div[@id='form-section']/a[@href='/']");
    private final By contactUsTitle = By.cssSelector(".contact-form > .text-center.title");

    public WebElement getContactUsNameField() {
        return driver.findElement(contactUsNameField);
    }
    public void setContactUsNameField(String value){
        driver.findElement(contactUsNameField).sendKeys(value);
    }

    public WebElement getContactUsEmailField() {
        return driver.findElement(contactUsEmailField);
    }
    public void setContactUsEmailField(String value){
        driver.findElement(contactUsEmailField).sendKeys(value);
    }

    public WebElement getContactUsSubjectField() {
        return driver.findElement(contactUsSubjectField);
    }
    public void setContactUsSubjectField(String value){
        driver.findElement(contactUsSubjectField).sendKeys(value);
    }

    public WebElement getContactUsMessageField() {
        return driver.findElement(contactUsMessageField);
    }
    public void setContactUsMessageField(String value){
        driver.findElement(contactUsMessageField).sendKeys(value);
    }

    public WebElement getContactUsChooseFileButton(){
        return driver.findElement(contactUsChooseFileButton);
    }

    public void setContactUsChooseFileButton(String value){
        driver.findElement(contactUsChooseFileButton).sendKeys(value);
    }

    public void clickOnContactUsSubmitButton(){
        element = driver.findElement(contactUsSubmitButton);
        element.click();
    }

    public WebElement getContactUsSuccessMessage(){
        return driver.findElement(contactUsSuccessMessage);
    }
    public void clickOnContactUsHomeButton(){
        element = driver.findElement(contactUsHomeButton);
        element.click();
    }

    public WebElement getContactUsTitle() {
        return driver.findElement(contactUsTitle);
    }
}
