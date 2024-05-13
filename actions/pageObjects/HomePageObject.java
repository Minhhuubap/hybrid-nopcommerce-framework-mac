package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;


    public HomePageObject(WebDriver driver) {   //Đoạn này map driver
        this.driver = driver;
    }   //Constructor


    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return new RegisterPageObject(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK) ;
        //chỗ này false vì hàm assertTrue bên kia nếu để hàm này true thì sẽ luôn true, ko check
    }

    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return new CustomerInfoPageObject(driver);
    }
}

//Trong HomePage object thi dung locator cua HomePageUI
