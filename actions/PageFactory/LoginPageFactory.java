package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')")
    private WebElement loginButton;


    //
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver,emailTextbox);
        emailTextbox.sendKeys(emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver,passwordTextbox);
        passwordTextbox.sendKeys(password);

    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,loginButton);
        loginButton.click();
    }

    public void loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
    }//Method cuoi nay la sao????
}
