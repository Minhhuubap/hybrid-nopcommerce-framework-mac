package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public void enterToEmailTextbox(String s) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, s);

    }

    public void enterToPasswordTextbox(String s) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, s);
    }


    public void clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
