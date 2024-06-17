package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SideBarPageUI;

public class SideBarPageObject extends BasePage {
    WebDriver driver;
    public SideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        clickToElement(driver, SideBarPageUI.ADDRESS_LINK);
        return PageGenarator_SwitchPage.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage() {
        clickToElement(driver, SideBarPageUI.ORDER_LINK);
        return PageGenarator_SwitchPage.getOrderPage(driver);
    }

    public RewardPointPageObject openRewardPointPage() {
        clickToElement(driver, SideBarPageUI.REWARDPOINT_LINK);
        return PageGenarator_SwitchPage.getRewardPoint(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        clickToElement(driver, SideBarPageUI.CUSTOMERINFO_LINK);
        return PageGenarator_SwitchPage.getCustomerInfo(driver);
    }
}
