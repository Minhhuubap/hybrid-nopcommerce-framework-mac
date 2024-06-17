package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObject extends SideBarPageObject {
    private WebDriver driver;
    public AddressPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

/*
    public RewardPointPageObject openRewardPointPage() {
        clickToElement(driver, AddressPageUI.REWARDPOINT_LINK);             //PageUI của page nào thì nằm trong PageObject đó
        return PageGenarator_SwitchPage.getRewardPoint(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        clickToElement(driver, AddressPageUI.CUSTOMERINFO_LINK);
        return PageGenarator_SwitchPage.getCustomerInfo(driver);
    }

 */
    //Phần này đã bị comment lại vì chuyển sang dùng BasePage/ BasePAgeUI cho đỡ trùng lặp, tạo nhiều lần
}
