package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.homePageUI;

public class computerPO extends CommonFunctions {
    WebDriver driver;

    public computerPO(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomePageTitleShow(){
        waitElementVisible(driver , homePageUI.TITLE_HOME_PAGE);
        return isElementDisplayed(driver , homePageUI.TITLE_HOME_PAGE);
    }
}
