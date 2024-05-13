package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    @CacheLookup    //Tìm 1 lần
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement companyTextbox;


//

    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, firstNameTextbox);
        return isElementSelected(firstNameTextbox);
    }

    public String getFirstNameTextboxValue() {
        return firstNameTextbox.getAttribute("value");
    }

    public String getLastNameTextboxValue() {
        return lastNameTextbox.getAttribute("value");
    }

    public String getDayDropDownSelectedValue() {
        return getSelectedItemInDropDown(dayDropdown);
    }

    public String getMonthDropDownSelectedValue() {
        return getSelectedItemInDropDown(monthDropdown);
    }

    public String getYearDropDownSelectedValue() {
        return getSelectedItemInDropDown(yearDropdown);
    }

    public String getEmailTextboxValue() {
        return emailTextbox.getAttribute("value");
    }

    public String getCompanyTextboxValue() {
        return companyTextbox.getAttribute("value");
    }
}
