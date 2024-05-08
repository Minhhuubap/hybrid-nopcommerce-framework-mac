package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

public class RegisterPageFactory extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='gender-male']" )
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']" )
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']" )
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']" )
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']" )
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='Email']" )
    private WebElement email;

    @FindBy(xpath = "//input[@id='Company']" )
    private WebElement companyNameTextBox;

    @FindBy(xpath = "//input[@id='Password']" )
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']" )
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//button[@id='register-button']" )
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']" )
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//a[text()='Log in']" )
    private WebElement loginButton;



    //

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToMaleRadio() {
        waitForElementClickable(driver,genderMaleRadio);
        genderMaleRadio.click();
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementClickable(driver,firstNameTextbox);
        firstNameTextbox.sendKeys(firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementClickable(driver,lastNameTextbox);
        lastNameTextbox.sendKeys(lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver,dayDropdown);
        selectItemInDropDown(dayDropdown, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver,monthDropdown);
        selectItemInDropDown(monthDropdown, month);

    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver,yearDropdown);
        selectItemInDropDown(yearDropdown, year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver,email);
        email.sendKeys(emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementClickable(driver,companyNameTextBox);
        companyNameTextBox.sendKeys(companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver,passwordTextbox);
        passwordTextbox.sendKeys(password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementClickable(driver,confirmPasswordTextbox);
        confirmPasswordTextbox.sendKeys(password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,registerButton);
        registerButton.click();
    }

    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver,registerSuccessMessage);
        return registerSuccessMessage.getText();
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,loginButton);
        loginButton.click();
    }
}
