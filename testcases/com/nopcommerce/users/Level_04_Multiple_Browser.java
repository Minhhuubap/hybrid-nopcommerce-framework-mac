package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;

public class Level_04_Multiple_Browser extends BaseTest {
    //Declare variable
    private WebDriver driver;
    
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfo;

    private String firstName, lastName, day, month, year, emailAddress, companyName, password;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);  //Method trong BaseTest    //Cần phải map driver vì biến driver ban đầu chưa được map?

//       driver = new FirefoxDriver();
//       driver.get("");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new UserHomePO(driver);

        firstName = "Minh";
        lastName = "Ta";
        day = "12";
        month = "5";
        year = "1993";
        emailAddress = "banhtrui" + generateRandomNumber() + "@gmail.com";
        companyName = "ABC";
        password = "Biboba123";
    }

    //Testcases
    @Test
    public void User_01_Register() {
        //Action 1
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPO(driver);

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");


    }

    @Test
    public void User_02_Login() {
        registerPage.openLoginPage();

        loginPage = new UserLoginPO(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePO(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        homePage.clickToMyAccountLink();

        customerInfo = new UserCustomerInfoPO(driver);

        Assert.assertTrue(customerInfo.isGenderMaleSelected());

        Assert.assertEquals(customerInfo.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfo.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfo.getDayDropDownSeleStringctedValue(),day);
        Assert.assertEquals(customerInfo.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(customerInfo.getYearDropDownSelectedValue(),year);
        Assert.assertEquals(customerInfo.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfo.getCompanyTextboxValue(),companyName);
//Bị fail mất phần Day/Month/Year vì drop down ở customerInfo không nhận data



    }

    @AfterClass
    public void afterClass(){

    }
}

