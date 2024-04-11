package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_04_Multiple_Browser extends BaseTest {
    //Declare variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfo;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);  //Method trong BaseTest    //Cần phải map driver vì biến driver ban đầu chưa được map?

//       driver = new FirefoxDriver();
//       driver.get("");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePageObject(driver);
    }

    //Testcases
    @Test
    public void User_01_Register() {
        //Action 1
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

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

        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextbox("");
        loginPage.enterToPasswordTextbox("");
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        homePage.clickToMyAccountLink();

        customerInfo = new CustomerInfoPageObject(driver);

        Assert.assertEquals(customerInfo.isGenderMaleSelected(),"");

        Assert.assertEquals(customerInfo.getFirstNameTextboxValue(),"");
        Assert.assertEquals(customerInfo.getLastNameTextboxValue(),"");
        Assert.assertEquals(customerInfo.getDayDropDownSeleStringctedValue(),"");
        Assert.assertEquals(customerInfo.getMonthDropDownSelectedValue(),"");
        Assert.assertEquals(customerInfo.getYearDropDownSelectedValue(),"");
        Assert.assertEquals(customerInfo.getEmailTextboxValue(),"");
        Assert.assertEquals(customerInfo.getCompanyTextboxValue(),"");




    }

    @AfterClass
    public void afterClass(){

    }
}
