package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.users.UserHomePO;

public class PageGenerator_PageOb {
    public static UserHomePO getHomePage(WebDriver driver) {
        return new UserHomePO(driver);
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
