package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.addressPageUI;

public class wishlistPO extends CommonFunctions {
    WebDriver driver;

    public wishlistPO(WebDriver driver){
        this.driver = driver;
    }

    public String getValueofAddress(String className){
        waitElementVisible(driver , addressPageUI.LINE_VALUE , className);
        return getElementText(driver , addressPageUI.LINE_VALUE , className);
    }
}
