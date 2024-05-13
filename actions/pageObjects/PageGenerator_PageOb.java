package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator_PageOb {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
}
