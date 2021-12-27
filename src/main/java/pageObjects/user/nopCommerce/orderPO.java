package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.orderPageUI;

public class orderPO extends CommonFunctions {
    WebDriver driver;

    public orderPO(WebDriver driver){
        this.driver = driver;
    }

    public orderDetailPO clickToButtonDetailOrder(String orderID){
        waitElementClickable(driver , orderPageUI.BUTTON_BY_ORDER_ID , orderID);
        clickToElement(driver , orderPageUI.BUTTON_BY_ORDER_ID , orderID);
        return pageGeneratorManager.getOrderDetailPage(driver);
    }


}
