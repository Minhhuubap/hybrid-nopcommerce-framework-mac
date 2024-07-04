package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;


    public UserHomePO(WebDriver driver) {   //Đoạn này map driver
        this.driver = driver;
    }   //Constructor


    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return new UserRegisterPO(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK) ;
        //chỗ này false vì hàm assertTrue bên kia nếu để hàm này true thì sẽ luôn true, ko check
    }

    public UserCustomerInfoPO clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return new UserCustomerInfoPO(driver);
    }


    public UserLoginPO openLoginPage() {
        clickToElement(driver, UserHomePageUI.LOGIN_BUTTON);
        return new UserLoginPO(driver);
    }
}

//Trong HomePage object thi dung locator cua HomePageUI
