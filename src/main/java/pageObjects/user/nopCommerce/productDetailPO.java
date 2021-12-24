package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.addressPageUI;
import pageUIs.user.nopCommerce.productDetailPageUI;

public class productDetailPO extends CommonFunctions {
    WebDriver driver;

    public productDetailPO(WebDriver driver){
        this.driver = driver;
    }


    public String getValueByTitle(String title){
        waitElementVisible(driver , productDetailPageUI.VALUE_BY_TITLE , title);
        return getElementText(driver , productDetailPageUI.VALUE_BY_TITLE , title);
    }
}
