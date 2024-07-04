package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenarator_SwitchPage;
import pageObjects.PageGenerator_PageOb;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.*;

import java.time.Duration;

public class Level_08_Switch_Site_URL extends BaseTest {
    //Declare variable
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;

    //
    private String userURL, adminURL;
    private String adminEmailAddress, adminEmailPassword;



    //Pre-condition

    @Parameters({"browser","userURL","adminURL"})
    @BeforeClass
    public void beforeClass(String browserName, String userURL, String adminURL) {
        this.userURL = userURL;             //Chưa hiểu lắm cái này để làm gì khi gán this.
        this.adminURL = adminURL;
        driver = getBrowserDriver(browserName, this.userURL);         //Chỗ này nữa ở bên BaseTest
        userHomePage = PageGenerator_PageOb.getHomePage(driver);

        firstName = "Minh";
        lastName = "Ta";
        day = "12";
        month = "5";
        year = "1993";
        emailAddress = "banhtrui" + generateRandomNumber() + "@gmail.com";
        companyName = "ABC";
        password = "Biboba123";

        adminEmailAddress = "admin@yourstore.com";
        adminEmailPassword = "admin";
    }

    //Testcases
    @Test
    public void A_User_01_Register() {

        userRegisterPage = userHomePage.clickToRegisterLink();

        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.selectDayDropdown(day);
        userRegisterPage.selectMonthDropdown(month);
        userRegisterPage.selectYearDropdown(year);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");

        //Đang ở màn hình register nhưng nó auto login account vào rồi -> Phải log out ra để test lại login account
        userHomePage = userRegisterPage.clickToLogoutLink();


    }

    @Test
    public void Role_01_User_Site_To_Admin_Site() {

        userLoginPage = userHomePage.openLoginPage();

        userLoginPage.enterToEmailTextbox(emailAddress);
        userLoginPage.enterToPasswordTextbox(password);
        userLoginPage.clickToLoginButton();

        userHomePage = new UserHomePO(driver);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        //Qua trang Admin để verify/ approve order ở trên với quyền Admin
        userHomePage.openPageURL(driver,this.adminURL);

        //Chua login
        adminLoginPage = PageGenarator_SwitchPage.getAdminLoginPage(driver);
        /*
        //Login trước đó roi
        adminDashboardPage = PageGenarator_SwitchPage.getAdminDashboardPage(driver);        //Nên không đưa đoạn khởi tạo page vào openAdminSite()
         */

        //Login vao Admin
        adminLoginPage.enterToUsernameTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminEmailPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();        //Vao DashBoard

    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        //Vào trang order/customer/.... page nào cũng có thể mở userURL

        adminDashboardPage.openPageURL(driver, this.userURL);   //đã login rồi
        userHomePage = PageGenarator_SwitchPage.getUserHomePage(driver);


        //Action next step....

    }

    //@Test
    public void User_03_MyAccount() {

        userCustomerInfoPage = userHomePage.clickToMyAccountLink();

        Assert.assertTrue(userCustomerInfoPage.isGenderMaleSelected(),"?");     //Lỗi chỗ này expected result khác
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(userCustomerInfoPage.getDayDropDownSeleStringctedValue(),day);
        Assert.assertEquals(userCustomerInfoPage.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(userCustomerInfoPage.getYearDropDownSelectedValue(),year);
        Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(),companyName);

    }

    //@Test
    public void User_04_Switch_Page() {
        // Customer Info -> Address
        addressPage = userCustomerInfoPage.openAddressPage();

        // Address -> RewardPoint
        rewardPointPage = addressPage.openRewardPointPage();

        // RewardPoint -> Order
        orderPage = rewardPointPage.openOrderPage();

        //Order -> Address
        addressPage = orderPage.openAddressPage();

        //Address - > CustomerInfo
        userCustomerInfoPage = addressPage.openCustomerInfoPage();
    }

    //Post-condition

    @AfterClass
    public void afterClass(){

    }
}
