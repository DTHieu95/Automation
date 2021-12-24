package pageUIs.user.nopCommerce;

public class BaseUserUI {
    public static final String HEADER_LINK = "//div[@class = 'header-links']//a[text() = '%s']";
    public static final String PAGE_TITLE = "//div[@class = 'page-title']/h1[text() = '%s']";
    public static final String INPUT_FIELD_ID = "//*[@id = '%s']";
    public static final String RADIO_BOX_LABEL = "//label[text() = '%s']/preceding-sibling::input";
    public static final String CHECK_BOX_LABEL = "//label[text() = '%s']/following-sibling::input";
    public static final String ERROR_MSG_FIELD = "//span[@id = %s']";
    public static final String BUTTON_NAME = "//button[text() = '%s']";
    public static final String LINK_TEXT = "//a[text() = '%s']";
    public static final String ERROR_MSG_SUMMARY = "//div[@class = 'message-error validation-summary-errors']";
    public static final String DROP_DOWN_NAME = "//select[@name = '%s']";
    public static final String MENU_SIDE = "//div[@class = 'listbox']//a[contains(string() , '%s')]";
    public static final String MSG_NO_DATA = "//div[@class='no-data' and text() = '%s']";
    public static final String BAR_SUCCESS_MSG = "//div[@class = 'bar-notification success']";
    public static final String ICON_CLOSE_IN_BAR = "//div[@class = 'bar-notification success']//span[@class = 'close']";
    public static final String PRODUCT_NAME = "//div[@class = 'product-item']//h2[@class = 'product-title']/a";
    public static final String LINK_PRODUCT = "//h2[@class = 'product-title']/a[text() = '%s']";
    public static final String FOOTER_LINK = "//div[@class = 'footer-upper']//a[text() = '%s']";
    public static final String MENU_HEADER = "//div[@class = 'header-menu']/ul[@class = 'top-menu notmobile']//a[contains(string() , '%s')]";
    public static final String SUB_LIST = "//ul[@class = 'sublist']//a[contains(string() , 'Desktops')]";
    public static final String PRODUCT_PRICE = "//div[@class = 'product-item']//div[@class = 'prices']/span";
    public static final String ICON_NEXT_PREVIOUS = "//li[@class = '%s-page']/a";
    public static final String NUMBER_PAGE = "//div[@class = 'pager']//a[text() = '%s']";
    public static final String NUMBER_WISHLIST_CART_HEADER = "//a[@class = 'ico-%s']//span[text() = '(%s)']";
    public static final String TABLE_COLUMN = "//table//tr//th[contains(string() , '%s')]/preceding-sibling::th";
    public static final String TABLE_ROW = "//table//tbody/tr[%s]/td[%s]";
    public static final String CHECKBOX_BY_PRODUCT_NAME = "//a[text() = '%s']/parent::td/preceding-sibling::td[@class = 'add-to-cart']/input";
    public static final String ICON_REMOVE_BY_PRODUCT_NAME = "//a[text() = '%s']/parent::td/following-sibling::td[@class = 'remove-from-cart']//button";
    public static final String MSG_NO_DATA_WISHLIST_CART = "//div[@class = 'page %s-page']//div[@class = 'no-data']";
    public static final String BUTTON_PRODUCT = "//a[textp) = '%s']/parent::h2/following-sibling::div//button[text() = '%s']";
    public static final String TABLE_BY_ROW = "//table//tr[contains(string() , '%s')]/preceding-sibling::tr";
    public static final String TABLE_BY_COLUMN = "//table//tbody/tr[%s]/td[%s]";

}
