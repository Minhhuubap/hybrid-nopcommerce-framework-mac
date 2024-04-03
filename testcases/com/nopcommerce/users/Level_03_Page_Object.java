package com.nopcommerce.users;

import commons.BasePage;
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

import java.sql.Driver;
import java.time.Duration;

public class Level_03_Page_Object {
    //Declare variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfo;



    //Pre-condition

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open URL -> qua Home Page
        driver.get("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Khởi tạo page và bắt đầu làm action của page đó
        homePage = new HomePageObject();
    }

    //Testcases
    @Test
    public void User_01_Register() {
        //Action 1
        homePage.clickToRegisterLink();

        //homePage -> registerpage -> new registerPage
        registerPage = new RegisterPageObject();

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox("");
        registerPage.enterToLastNameTextbox("");
        registerPage.selectDayDropdown("");
        registerPage.selectMonthDropdown("");
        registerPage.selectYearDropdown("");
        registerPage.enterToEmailTextbox("");
        registerPage.enterToCompanyTextbox("");
        registerPage.enterToPasswordTextbox("");
        registerPage.enterToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your register completed");


    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLoginButton();

        loginPage = new LoginPageObject();

        loginPage.enterToEmailTextbox("");
        loginPage.enterToPasswordTextbox("");
        registerPage.clickToLoginButton();

        homePage = new HomePageObject();

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        //Home page -> customer info
        homePage.clickToMyAccountLink();

        customerInfo = new CustomerInfoPageObject();

        Assert.assertEquals(customerInfo.isGenderMaleSelected(),"");

        Assert.assertEquals(customerInfo.getFirstNameTextboxValue(),"");
        Assert.assertEquals(customerInfo.getLastNameTextboxValue(),"");
        Assert.assertEquals(customerInfo.getDayDropDownSeleStringctedValue(),"");
        Assert.assertEquals(customerInfo.getMonthDropDownSelectedValue(),"");
        Assert.assertEquals(customerInfo.getYearDropDownSelectedValue(),"");
        Assert.assertEquals(customerInfo.getEmailTextboxValue(),"");




    }

    //Post-condition

    @AfterClass
    public void afterClass(){

    }
}
