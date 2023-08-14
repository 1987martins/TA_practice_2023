package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By searchResultPageTitle = By.cssSelector(".text-center.title");
    private final By searchResultPageProductTitle = By.cssSelector(".productinfo.text-center > p");

    public WebElement getSearchResultPageTitle() {
        return driver.findElement(searchResultPageTitle);
    }

    public WebElement getSearchResultPageProductTitle() {
        return driver.findElement(searchResultPageProductTitle);
    }
}
