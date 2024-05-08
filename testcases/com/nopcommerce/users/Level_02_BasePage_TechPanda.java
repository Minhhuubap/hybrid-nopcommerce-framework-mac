package com.nopcommerce.users;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Level_02_BasePage_TechPanda { //Hoặc để class này extends BasePage -> Không cần phải lôi basePage.
     BasePage basePage;
     WebDriver driver;
     Random rand = new Random();
     String emailAddress;


     @BeforeClass (groups = {"webBrowser", "webElement"})
     public void beforeClass() {
          driver = new FirefoxDriver();
          basePage = new BasePage();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          emailAddress = "banh" + rand.nextInt(999) + "@gmail.com";
     }


     /*
     List of BasePage applied on:
     Web Browser
     V     1. URL(open, getTitle, getURL, getPageSource), web action (back/foward/refresh)
          2. Alert

     Web Element
     V     1. FindElement
     V     2. locator
     V     3. click
     V     4. sendKey
          5. dropdown
          6. get(attribute/text/cssValue/HexaColor/size)
          7. radio, checkbox (displayed/selected/enabled)
          8. Iframe
          9. userActions
          10. JS
          11. Wait
      */



     @Test (groups = {"webBrowser"})
     public void TC_01_WebBrowser_Verify_URL() {
          basePage.openPageURL(driver,"http://live.techpanda.org");
          basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");
          Assert.assertEquals(basePage.getCurrentURL(driver), "http://live.techpanda.org/index.php/customer/account/login/");
          basePage.clickToElement(driver,"//a[@title='Create an Account']");
          Assert.assertEquals(basePage.getCurrentURL(driver),"http://live.techpanda.org/index.php/customer/account/create/");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_WebBrowser_Verify_Title() {
          basePage.openPageURL(driver,"http://live.techpanda.org/");
          basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");
          Assert.assertEquals(basePage.getTitle(driver),"Customer Login");
          basePage.clickToElement(driver,"//a[@title='Create an Account']");
          Assert.assertEquals(basePage.getTitle(driver),"Create New Customer Account");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_WebBrowser_Navigate_Function() {
          basePage.openPageURL(driver,"http://live.techpanda.org/");
          basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");
          basePage.clickToElement(driver,"//a[@title='Create an Account']");
          Assert.assertEquals(basePage.getCurrentURL(driver),"http://live.techpanda.org/index.php/customer/account/create/");
          basePage.back(driver);
          Assert.assertEquals(basePage.getCurrentURL(driver),"http://live.techpanda.org/index.php/customer/account/login/");
          Assert.assertEquals(basePage.getTitle(driver),"Customer Login");
     }


     @Test (groups = {"webBrowser"})
     public void TC_01_WebBrowser_GetPageSource() {
          basePage.openPageURL(driver,"http://live.techpanda.org/");
          basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");
          basePage.getPageSource(driver).contains("Login or Create an Account");
          basePage.clickToElement(driver,"//a[@title='Create an Account']");
          basePage.getPageSource(driver).contains("Create an Account");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_Alert_Accept_and_GetText() {
          basePage.openPageURL(driver,"https://automationfc.github.io/basic-form/index.html");
          basePage.clickToElement(driver,"//button[text()='Click for JS Alert']");
          basePage.waitAlertPresence(driver);
          Assert.assertEquals(basePage.getTextAlert(driver),"I am a JS Alert");
          basePage.acceptAlert(driver);
          Assert.assertEquals(basePage.getText(driver,"//p[@id='result']"),"You clicked an alert successfully");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_Alert_Confirm() {
          basePage.openPageURL(driver,"https://automationfc.github.io/basic-form/index.html");
          basePage.clickToElement(driver,"//button[text()='Click for JS Confirm']");
          basePage.waitAlertPresence(driver);
          Assert.assertEquals(basePage.getTextAlert(driver),"I am a JS Confirm");
          basePage.acceptAlert(driver);
          Assert.assertEquals(basePage.getText(driver,"//p[@id='result']"),"You clicked: Ok");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_Alert_Cancel() {
          basePage.openPageURL(driver,"https://automationfc.github.io/basic-form/index.html");
          basePage.clickToElement(driver,"//button[text()='Click for JS Confirm']");
          basePage.waitAlertPresence(driver);
          Assert.assertEquals(basePage.getTextAlert(driver),"I am a JS Confirm");
          basePage.cancelAlert(driver);
          Assert.assertEquals(basePage.getText(driver,"//p[@id='result']"),"You clicked: Cancel");
     }

     @Test (groups = {"webBrowser"})
     public void TC_01_Alert_SendKey() {
          basePage.openPageURL(driver,"https://automationfc.github.io/basic-form/index.html");
          basePage.clickToElement(driver,"//button[text()='Click for JS Prompt']");
          basePage.waitAlertPresence(driver);
          Assert.assertEquals(basePage.getTextAlert(driver),"I am a JS prompt");
          basePage.sendkeyToAlert(driver,"fuck");
          basePage.acceptAlert(driver);
          Assert.assertEquals(basePage.getText(driver,"//p[@id='result']"),"You entered: fuck");
     }


     //

     @Test (groups = {"webElement"})
     public void TC_02_WebElement_Register_Successfully() {
          basePage.openPageURL(driver, "http://live.techpanda.org/index.php/customer/account/create/");
          basePage.sendKeyToElement(driver,"//input[@id='firstname']", "A");
          basePage.sendKeyToElement(driver,"//input[@id='lastname']", "B");
          basePage.sendKeyToElement(driver,"//input[@id='email_address']", emailAddress);
          basePage.sendKeyToElement(driver,"//input[@id='password']", "motconvit");
          basePage.sendKeyToElement(driver,"//input[@id='confirmation']", "motconvit");
          basePage.clickToElement(driver,"//button[@title='Register']");



          //verify thanh cong
          Assert.assertEquals(basePage.getText(driver,"//ul[@class='messages']/li[@class='success-msg']//span"),"Thank you for registering with Main Website Store.");
          basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");



          //đặt biến cho đoạn text cần verify vì trong assert nhận string
          String contactInfoText = basePage.getText(driver,"//h3[text()='Contact Information']/parent::div/following-sibling::div/p");
          System.out.println(contactInfoText);

          //đoạn này vì dùng random email nên verify tương đối bằng Assert True. chứ không nên dùng equals
          Assert.assertTrue(contactInfoText.contains(emailAddress));
          Assert.assertEquals(basePage.getText(driver,"//h1[text()='My Dashboard']//parent::div//following-sibling::div//strong"), "Hello, A B!");
     }


     @Test
     public void TC_04_Dropdown() {
          basePage.openPageURL(driver,"https://demo.nopcommerce.com/register");
          basePage.sendKeyToElement(driver,"//input[@id='FirstName']","ha??");
          basePage.sendKeyToElement(driver,"//input[@id='LastName']","ha??");
          //Đoạn này thiếu method dropdown với new Select()
     }
/*
     @Test
     public void TC_04_Dropdown_01() {
          driver.get("https://demo.nopcommerce.com/register");
          driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("ha??");
          driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("ha??");
          new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("11");
          new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("July");
          new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1993");
          driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
          driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("ha??");
          driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
          driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
          driver.findElement(By.xpath("//button[@id='register-button']")).click();
          Assert.assertEquals(driver.findElement(By.cssSelector(".page-body>.result")).getText(), "Your registration completed");
          driver.findElement(By.xpath("//a[text()='My account']")).click();
          driver.findElement(By.id("Email")).sendKeys(emailAddress);
          driver.findElement(By.id("Password")).sendKeys("123456");
          driver.findElement(By.xpath("//button[text()='Log in']")).click();
          sleepInSecond(3);
          Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), "11");
          Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), "July");
          Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), "1993");
     }

 */



}
