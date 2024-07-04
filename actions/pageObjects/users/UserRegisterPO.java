package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenarator_SwitchPage;
import pageUIs.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

//

    public void clickToMaleRadio() {
        waitForElementVisible(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstname) {
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    public void enterToLastNameTextbox(String lastname) {
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    public void selectDayDropdown(String day) {
        selectItemInDropDown(driver, UserRegisterPageUI.DAY_DROPDOWN ,day);
    }

    public void selectMonthDropdown(String month) {
        selectItemInDropDown(driver, UserRegisterPageUI.MONTH_DROPDOWN ,month);
    }

    public void selectYearDropdown(String year) {
        selectItemInDropDown(driver, UserRegisterPageUI.YEAR_DROPDOWN ,year);
    }

    public void enterToEmailTextbox(String email) {
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyTextbox(String companyname) {
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyname);
    }

    public void enterToPasswordTextbox(String password) {
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getText(driver, UserRegisterPageUI.RESGISTER_SUCCESS_MESSEAGE);
    }

    public UserLoginPO openLoginPage() {
        clickToElement(driver, UserRegisterPageUI.LOGIN_BUTTON);
        return new UserLoginPO(driver);
    }

    public UserHomePO clickToLogoutLink(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        return PageGenarator_SwitchPage.getUserHomePage(driver);        //Đoạn này return về HomePage thôi chứ không new HomePage??
    }

}

//Tai sao trong moi ham chung 1 page deu phai wait cho element show ra ?