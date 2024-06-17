package PageFactory;        //Apply lên TE5 về PageFactory nên move thư mục sang PageFactory

import PageFactory.HomePageFactory;
import org.openqa.selenium.WebDriver;

public class PageGenerator{
    public static HomePageFactory getHomePage(WebDriver driver) {
        return new HomePageFactory(driver);
    }

}
