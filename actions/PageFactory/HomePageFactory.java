package PageFactory;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    private WebDriver driver;

    //Đây là element locator -> Dùng PageFactory.initElements
    @FindBy(how = How.CLASS_NAME, using ="ico-register" )
    private WebElement registerLink;    //Bắt buộc chỗ này là WebElement
    @FindBy(className = "ico-account")
    private WebElement myAccountLink;



    //Đây là action của Page
    public HomePageFactory (WebDriver driver) {
        this.driver = driver;
        //public static void initElements(SearchContext searchcontext, Object page)
        PageFactory.initElements(driver, this);
        //truyền driver vào vẫn đúng vì nó là con của SearchContext
    }
    public RegisterPageFactory clickToRegisterLink() {
        waitForElementClickable(driver,registerLink);
        clickToElement(registerLink);   //tham số là element
        return new RegisterPageFactory(driver);     //hàm này cho phần page Navigate -> tính Encapsulate đóng gói collapse giữa 2 methods.
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, myAccountLink);
        return isElementDisplayed(myAccountLink);
    }

    public CustomerInfoPageFactory clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(myAccountLink);
        return new CustomerInfoPageFactory(driver);
    }


}
