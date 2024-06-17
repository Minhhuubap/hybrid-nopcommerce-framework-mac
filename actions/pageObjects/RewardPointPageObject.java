package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends SideBarPageObject {          //Trước đó là extends BasePage
    private WebDriver driver;
    public RewardPointPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

/*
    public OrderPageObject openOrderPage() {
        clickToElement(driver, RewardPointPageUI.ORDER_LINK);
        return PageGenarator_SwitchPage.getOrderPage(driver);
    }

 */
}

//Phần này đã bị comment lại vì chuyển sang dùng BasePage/ BasePAgeUI cho đỡ trùng lặp, tạo nhiều lần