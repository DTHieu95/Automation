package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.addressPageUI;
import pageUIs.user.nopCommerce.homePageUI;

public class addressPO extends CommonFunctions {
    WebDriver driver;

    public addressPO(WebDriver driver){
        this.driver = driver;
    }

    public String getValueofAddress(String className){
        waitElementVisible(driver , addressPageUI.LINE_VALUE , className);
        return getElementText(driver , addressPageUI.LINE_VALUE , className);
    }
}
