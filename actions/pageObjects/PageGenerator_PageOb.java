package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator_PageOb {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }


//    public static LoginPageObject getHomePage(WebDriver driver) {
//        return new LoginPageObject(driver);
//    }
//
//    public static RegisterPageObject getHomePage(WebDriver driver) {
//        return new RegisterPageObject(driver);
//    }
//
//    public static CustomerInfoPageObject getHomePage(WebDriver driver) {
//        return new CustomerInfoPageObject(driver);
//    }


}
