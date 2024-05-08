package com.nopcommerce.users;

import PageFactory.CustomerInfoPageFactory;
import PageFactory.HomePageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.RegisterPageFactory;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_05_PageFactory extends BaseTest {
    //Declare variable
    private WebDriver driver;
    private HomePageFactory homePage;
    private RegisterPageFactory registerPage;
    private LoginPageFactory loginPage;
    private CustomerInfoPageFactory customerInfo;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;



    //Pre-condition

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();           //Driver cần được truyền duy nhât 1 lần, ko cần new nhièu

        //Open URL -> qua Home Page
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Khởi tạo page và bắt đầu làm action của page đó
        homePage = new HomePageFactory(driver);      //Biến driver = new FireFox

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
        //Action 1
        homePage.clickToRegisterLink();             //Biến driver nhảy vào hàm clickToRegisterLink ở HomePageObject -> biến driver nhảy vào method Wait của BaseP

        //homePage -> registerpage -> new registerPage
        registerPage = new RegisterPageFactory(driver);

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
        registerPage.clickToLoginButton();

        loginPage = new LoginPageFactory(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new HomePageFactory(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        //Home page -> customer info
        homePage.clickToMyAccountLink();

        customerInfo = new CustomerInfoPageFactory(driver);            //Nếu không map driver thì mỗi lần new TE ko có driver được tạo?

        Assert.assertEquals(customerInfo.isGenderMaleSelected(),"Male");

        Assert.assertEquals(customerInfo.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfo.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfo.getDayDropDownSelectedValue(),day);
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
