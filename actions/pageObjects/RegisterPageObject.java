package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

import java.util.Random;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

//

    public void clickToMaleRadio() {
        waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstname) {
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    public void enterToLastNameTextbox(String lastname) {
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    public void selectDayDropdown(String day) {
        selectItemInDropDown(driver, RegisterPageUI.DAY_DROPDOWN ,day);
    }

    public void selectMonthDropdown(String month) {
        selectItemInDropDown(driver, RegisterPageUI.MONTH_DROPDOWN ,month);
    }

    public void selectYearDropdown(String year) {
        selectItemInDropDown(driver, RegisterPageUI.YEAR_DROPDOWN ,year);
    }

    public void enterToEmailTextbox(String email) {
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyTextbox(String companyname) {
        sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyname);
    }

    public void enterToPasswordTextbox(String password) {
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getText(driver,RegisterPageUI.RESGISTER_SUCCESS_MESSEAGE);
    }

    public void clickToLoginButton() {
        clickToElement(driver, RegisterPageUI.LOGIN_BUTTON);
    }
}

//Tai sao trong moi ham chung 1 page deu phai wait cho element show ra ?