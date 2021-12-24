package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.registerPageUI;

public class registerPO extends CommonFunctions {
    WebDriver driver;

    public registerPO(WebDriver driver){
        this.driver = driver;
    }

    public String getMsgRegisterSuccess(){
        waitElementVisible(driver , registerPageUI.MSG_SUCCESS);
        return getElementText(driver, registerPageUI.MSG_SUCCESS);
    }
}
