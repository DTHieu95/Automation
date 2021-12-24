package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.homePageUI;

public class customerInfoPO extends CommonFunctions {
    WebDriver driver;

    public customerInfoPO(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomePageTitleShow(){
        waitElementVisible(driver , homePageUI.TITLE_HOME_PAGE);
        return isElementDisplayed(driver , homePageUI.TITLE_HOME_PAGE);
    }
}
