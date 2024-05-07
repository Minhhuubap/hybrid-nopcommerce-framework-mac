package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        switch (browserName){
            case "firefox" -> driver = new FirefoxDriver();
            case "chrome" -> driver = new ChromeDriver();
            default -> throw new RuntimeException("BrowserName is not valid");      //có throw ko cần break
        }

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;              //New xong trả về driver cho class Test bên kia gọi ra
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(999);
    }

    RemoteWebDriver yo = new FirefoxDriver();
    


}
