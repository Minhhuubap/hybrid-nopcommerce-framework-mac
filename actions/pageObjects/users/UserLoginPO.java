package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);

    }

    public void enterToPasswordTextbox(String password) {
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }


    public void clickToLoginButton() {
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }
}
