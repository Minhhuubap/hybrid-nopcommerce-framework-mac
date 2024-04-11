package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        return getAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }


    public String getLastNameTextboxValue() {
        return getAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDropDownSeleStringctedValue() {
        return getSelectedItemInDropDown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropDownSelectedValue() {
        return getSelectedItemInDropDown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropDownSelectedValue() {
        return getSelectedItemInDropDown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        return getAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        return getAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }
}
