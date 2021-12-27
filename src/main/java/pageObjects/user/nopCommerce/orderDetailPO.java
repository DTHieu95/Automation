package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.orderDetailPageUI;

public class orderDetailPO extends CommonFunctions {
    WebDriver driver;

    public orderDetailPO(WebDriver driver){
        this.driver = driver;
    }

    public String getOrderNumberInOverview(){
        waitElementVisible(driver , orderDetailPageUI.ORDER_NUMBER);
        return getElementText(driver , orderDetailPageUI.ORDER_NUMBER);
    }


}
