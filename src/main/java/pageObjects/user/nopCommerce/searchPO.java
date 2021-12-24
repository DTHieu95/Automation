package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.addressPageUI;
import pageUIs.user.nopCommerce.searchPageUI;

public class searchPO extends CommonFunctions {
    WebDriver driver;

    public searchPO(WebDriver driver){
        this.driver = driver;
    }


    public boolean isMsgWarningDisplayed(){
        waitElementVisible(driver , searchPageUI.MSG_WARNING);
        return isElementDisplayed(driver , searchPageUI.MSG_WARNING);
    }

    public boolean isMsgNoResultDisplayed(){
        waitElementVisible(driver , searchPageUI.MSG_NO_RESULT);
        return isElementDisplayed(driver , searchPageUI.MSG_NO_RESULT);
    }
}
