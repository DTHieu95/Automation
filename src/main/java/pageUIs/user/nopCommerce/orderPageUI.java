package pageUIs.user.nopCommerce;

public class orderPageUI {
    public static final String INFO_ORDER_BY_ID = "//strong[text()='Order Number: %s']/parent::div/parent::div//ul[@class = 'info']";
    public static final String BUTTON_BY_ORDER_ID = "//strong[text()='Order Number: %s']/parent::div/parent::div//button[contains(string() , 'Details')]";
}
