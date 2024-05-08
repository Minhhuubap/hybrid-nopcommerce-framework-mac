package PageFactory;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebElement element, String keyToSend) {
        element.clear();
        element.sendKeys(keyToSend);
    }

    public String getSelectedItemInDropDown(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }
    public void selectItemInDropDown(WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }

    public String getAttribute(WebElement element, String atrributeName) {
        return element.getAttribute(atrributeName);
    }

    public String getText(WebElement element, String locator) {
        return element.getText();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    } //Hàm này vẫn phải truyền driver


    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }




    //Chưa hiểu lắm tsao ở đây dùng WebElement
    //Vì bên Page sử dụng hàm đã tìm element và truyền vào hàm BagePage
}
