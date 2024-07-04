package pageObjects.users;

import org.openqa.selenium.WebDriver;
import pageUIs.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSideBarPO {
    private WebDriver driver;
    public UserCustomerInfoPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        return getAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }


    public String getLastNameTextboxValue() {
        return getAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDropDownSeleStringctedValue() {
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropDownSelectedValue() {
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropDownSelectedValue() {
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        return getAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        return getAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }

    /*
    public AddressPageObject openAddressPage() {
        clickToElement(driver, CustomerInfoPageUI.ADDRESS_LINK);
        return PageGenarator_SwitchPage.getAddressPage(driver);
    }
//Phần này đã bị comment lại vì chuyển sang dùng BasePage/ BasePAgeUI cho đỡ trùng lặp, tạo nhiều lần
     */
}
