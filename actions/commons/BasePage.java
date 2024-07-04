package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageUIs.*;

import java.time.Duration;
import java.util.List;

public class BasePage {



    public void openPageURL(WebDriver driver, String URL) {
        driver.get(URL);
    }

    public String getTitle(WebDriver driver)  {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    //

    public void back(WebDriver driver) {
        driver.navigate().back();
    }

    public void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    //

    /*
    Alert: - Tạo mới driver
            - Chờ cho alert hiện bằng explicit wait
     */

    public void waitAlertPresence(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
    }

    public void acceptAlert (WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keyToSend) {
        driver.switchTo().alert().sendKeys(keyToSend);
    }

    //Skip Window

    protected WebElement getElement(WebDriver driver, String xpath) {
        return driver.findElement(getByLocator(xpath));
    }

    protected List<WebElement> getElements(WebDriver driver, String xpath) {
        return driver.findElements(getByLocator(xpath));
    }

    //Truyền tham số vào By
    private By getByLocator(String prefixLocator){   //id= , name= ,xpath=, css= ,...
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));             //Index = 3: id= ->0,1,2,-> xét sau dấu = trở đi
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    private By getByXpath(String locator ){
        return By.xpath(locator);
    }


    public void clickToElement(WebDriver driver, String locator) {
        driver.findElement(getByLocator(locator)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        driver.findElement(getByLocator(locator)).sendKeys(keyToSend);
    }

    public void selectItemInDropDown(WebDriver driver, String parentLocator, String childLocator) {
        List<WebElement> list = driver.findElements(getByLocator(parentLocator));
        for (WebElement item: list) {
            String item1 = item.getText();
            if (item1.equals(childLocator)) {
                item.click();
                break;
            }
        }
    }

    public String getSelectedItemInDropDown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor;
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }


    //METHOD IN METHOD
    public String getAttribute(WebDriver driver, String locator ,String atrributeName) {
        return getElement(driver, locator).getAttribute(atrributeName);
    } //hàm getElement là đã tạo ở trên đầu. Sdung Hàm trong hàm

    public String getText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String css) {
        return getElement(driver, locator).getCssValue(css);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getElementSize(WebDriver driver, String locator) {
        return getElements(driver,locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    /*
    - Displayed: Presence + visible
    - Enabled: Presence + click/edit/select/scroll
    - Selected: Presece + tagname = input/option (select)
     */
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    //Frame/ỉframe


    //Actions

    public void doubleClicktoElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator ,String locator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver,locator)).perform();
    }

    public void srollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, String keys) {
        new Actions(driver).sendKeys(getElement(driver,locator), keys).perform();
    }

    //Tạm hold 3 phần: Iframe, JS, Wait (bỏ Upload, window)

    //Wait
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForAlertPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }


    // Phần dưới này dành cho switch Page, ném hết methods openPage vào BasePage; Còn Page UI locator dùng chung thì cho vào BasePageUI
//    public AddressPageObject openAddressPage(WebDriver driver) {
//        clickToElement(driver, BasePageUI.ADDRESS_LINK);
//        return PageGenarator_SwitchPage.getAddressPage(driver);
//    }
//
//    public OrderPageObject openOrderPage(WebDriver driver) {
//        clickToElement(driver, BasePageUI.ORDER_LINK);
//        return PageGenarator_SwitchPage.getOrderPage(driver);
//    }
//
//    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
//        clickToElement(driver, BasePageUI.REWARDPOINT_LINK);
//        return PageGenarator_SwitchPage.getRewardPoint(driver);
//    }
//
//    public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
//        clickToElement(driver, BasePageUI.CUSTOMERINFO_LINK);
//        return PageGenarator_SwitchPage.getCustomerInfo(driver);
//    }

}
