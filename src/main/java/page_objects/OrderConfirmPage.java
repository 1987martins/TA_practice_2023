package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmPage {

    private WebDriver driver;

    public OrderConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By orderConfirmSuccessMessage = By.cssSelector("[class='col-sm-9 col-sm-offset-1'] p");

    public WebElement getOrderConfirmSuccessMessage() {
        return driver.findElement(orderConfirmSuccessMessage);
    }
}
