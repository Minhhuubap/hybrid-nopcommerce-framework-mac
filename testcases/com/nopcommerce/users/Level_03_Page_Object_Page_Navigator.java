package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import java.time.Duration;

public class Level_03_Page_Object_Page_Navigator extends BaseTest {
    //Declare variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfo;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;



    //Pre-condition

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open URL -> qua Home Page
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Khởi tạo page và bắt đầu làm action của page đó
//        homePage = new HomePageObject(driver);      //Biến driver = new FireFox

        homePage = PageGenerator_PageOb.getHomePage(driver);        //Giấu khởi tạo new Page theo tính Encapsulate

        firstName = "Minh";
        lastName = "Ta";
        day = "12";
        month = "5";
        year = "1993";
        emailAddress = "banhtrui" + generateRandomNumber() + "@gmail.com";      //Hàm ở đây dùng extends trong BaseTest
        companyName = "ABC";
        password = "Biboba123";
    }

    //Testcases
    @Test
    public void User_01_Register() {
//        //Action 1
//        homePage.clickToRegisterLink();
//        //homePage -> registerpage -> new registerPage
//        registerPage = new RegisterPageObject(driver);

        registerPage = homePage.clickToRegisterLink();

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
//        registerPage.clickToLoginButton();
//        loginPage = new LoginPageObject(driver);

        loginPage = registerPage.clickToLoginButton();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        //Home page -> customer info
//        homePage.clickToMyAccountLink();
//        customerInfo = new CustomerInfoPageObject(driver);

        customerInfo = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerInfo.isGenderMaleSelected(),"Male");
        Assert.assertEquals(customerInfo.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfo.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfo.getDayDropDownSeleStringctedValue(),day);
        Assert.assertEquals(customerInfo.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(customerInfo.getYearDropDownSelectedValue(),year);
        Assert.assertEquals(customerInfo.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfo.getCompanyTextboxValue(),companyName);

    }

    //Post-condition

    @AfterClass
    public void afterClass(){

    }
}
