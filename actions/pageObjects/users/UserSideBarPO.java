package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenarator_SwitchPage;
import pageUIs.users.UserSideBarPageUI;

public class UserSideBarPO extends BasePage {
    WebDriver driver;
    public UserSideBarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPO openAddressPage() {
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenarator_SwitchPage.getUserAddressPage(driver);
    }

    public UserOrderPO openOrderPage() {
        clickToElement(driver, UserSideBarPageUI.ORDER_LINK);
        return PageGenarator_SwitchPage.getUserOrderPage(driver);
    }

    public UserRewardPointPO openRewardPointPage() {
        clickToElement(driver, UserSideBarPageUI.REWARDPOINT_LINK);
        return PageGenarator_SwitchPage.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        clickToElement(driver, UserSideBarPageUI.CUSTOMERINFO_LINK);
        return PageGenarator_SwitchPage.getUserCustomerInfoPage(driver);
    }
}
