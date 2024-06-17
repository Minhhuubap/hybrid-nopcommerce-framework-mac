package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;

public class OrderPageObject extends SideBarPageObject {
    private WebDriver driver;
    public OrderPageObject(WebDriver driver){
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
