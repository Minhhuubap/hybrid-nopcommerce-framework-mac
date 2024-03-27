package com.nopcommerce.users;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class LeveL_02_BasePage_TechPanda {
     BasePage basePage = new BasePage();
     WebDriver driver;
     Random rand = new Random();
     String emailAddress;


     @BeforeClass
     public void beforeClass() {

          driver = new FirefoxDriver();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

          emailAddress = "banh" + rand.nextInt(999) + "@gmail.com";
     }


     /*
     List of BasePage applied on: dùng hết
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



     @Test
     public void TC_01_Register_Successfully() {
          basePage.openPageURL(driver, "http://live.techpanda.org/index.php/customer/account/create/");
          basePage.sendKeyToElement(driver,"//input[@id='firstname']", "A");
          basePage.sendKeyToElement(driver,"//input[@id='lastname']", "B");
          basePage.sendKeyToElement(driver,"//input[@id='email_address']", emailAddress);
          basePage.sendKeyToElement(driver,"//input[@id='password']", "motconvit");
          basePage.sendKeyToElement(driver,"//input[@id='confirmation']", "motconvit");
          basePage.clickToElemnt(driver,"//button[@title='Register']");



          //verify thanh cong
          Assert.assertEquals(basePage.getText(driver,"//ul[@class='messages']/li[@class='success-msg']//span"),"Thank you for registering with Main Website Store.");
          basePage.clickToElemnt(driver,"//div[@class='footer']//a[text()='My Account']");



          //đặt biến cho đoạn text cần verify vì trong assert nhận string
          String contactInfoText = basePage.getText(driver,"//h3[text()='Contact Information']/parent::div/following-sibling::div/p");
          System.out.println(contactInfoText);

          //đoạn này vì dùng random email nên verify tương đối bằng Assert True. chứ không nên dùng equals
          Assert.assertTrue(contactInfoText.contains(emailAddress));
          Assert.assertEquals(basePage.getText(driver,"//h1[text()='My Dashboard']//parent::div//following-sibling::div//strong"), "Hello, A B!");
     }

     @Test
     public void TC_02_Alert() {

     }



}
