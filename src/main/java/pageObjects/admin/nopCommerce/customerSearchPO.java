package pageObjects.admin.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.nopCommerce.customerSearchPageUI;

public class customerSearchPO extends CommonFunctions {
    WebDriver driver;
    public customerSearchPO(WebDriver driver){
        this.driver = driver;
    }

    public boolean isResultDisplayedInTable(String email , String name , String customerRole , String company , String active){
        waitElementVisible(driver , customerSearchPageUI.CUSTOMER_RESULT_TABLE , email , name , customerRole , company , active);
        return isElementDisplayed(driver , customerSearchPageUI.CUSTOMER_RESULT_TABLE , email , name , customerRole , company , active);
    }
}
