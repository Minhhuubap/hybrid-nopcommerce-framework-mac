package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenarator_SwitchPage {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static OrderPageObject getOrderPage(WebDriver driver) {
        return new OrderPageObject(driver);
    }

    public static RewardPointPageObject getRewardPoint(WebDriver driver) {
        return new RewardPointPageObject(driver);
    }

    public static CustomerInfoPageObject getCustomerInfo(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }


}
