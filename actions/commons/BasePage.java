package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    //Đặt biến driver là tham số
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

    public WebElement getElement(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElements(WebDriver driver, String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public void clickToElement(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        driver.findElement(By.xpath(locator)).sendKeys(keyToSend);
    }

    public void selectItemInDropDown(WebDriver driver, String parentLocator, String childLocator) {
        List<WebElement> list = driver.findElements(By.xpath(parentLocator));
        for (WebElement item: list) {
            String item1 = item.getText();
            if (item1.equals(childLocator)) {
                item.click();
                break;
            }
        }
    }

    public void getSelectedItemInDropDown(WebDriver driver, String parentLocator, String childLocator) {
        driver.findElement(By.xpath(parentLocator)).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        for (WebElement item: allItems) {
            String item1 = item.getText();
            if (item1.equals(childLocator)) {
                item.getText();
                break;
            }
        }
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

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));

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
    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
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
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }
    public void waitForAlertPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

}
