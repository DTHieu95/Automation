package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.addressPageUI;
import pageUIs.user.nopCommerce.checkoutPageUI;

public class checkoutPO extends CommonFunctions {
    WebDriver driver;

    public checkoutPO(WebDriver driver){
        this.driver = driver;
    }



    public String getMsgBodyCheckoutSuccessPage(String type){
        waitElementVisible(driver , checkoutPageUI.CHECK_OUT_SUCCESS_BODY, type);
        return getElementText(driver , checkoutPageUI.CHECK_OUT_SUCCESS_BODY , type).trim();
    }


}
