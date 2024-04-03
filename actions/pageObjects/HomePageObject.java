package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        return false;
        //chỗ này false vì hàm assertTrue bên kia nếu để hàm này true thì sẽ luôn true, ko check
    }

    public void clickToMyAccountLink() {
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}

//Trong HomePage object thi dung locator cua HomePageUI
