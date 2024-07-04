package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserSideBarPO {
    private WebDriver driver;
    public UserOrderPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    /*
    public AddressPageObject openAddressPage() {
        clickToElement(driver, OrderPageUI.ADDRESS_LINK);
        return PageGenarator_SwitchPage.getAddressPage(driver);
    }

     */

    //Phần này đã bị comment lại vì chuyển sang dùng BasePage/ BasePAgeUI cho đỡ trùng lặp, tạo nhiều lần
}
