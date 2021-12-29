package pageUIs.admin.nopCommerce;

public class baseAdminUI {
    public static final String CONTENT_HEADER = "//div[contains(@class , 'content-header')]/h1";
    public static final String MENU_LINK_BY_NAME = "//ul[@role = 'menu']/li/a/p[contains(string() , '%s')]";
    public static final String SUB_MENU_LINK_BY_NAME = "//ul[@class = 'nav nav-treeview' and @style]//p[contains(string() , '%s')]";
    public static final String BUTTON_BY_NAME = "//table[@id = '%s']//td[text() = '%s']/following-sibling::td//a[contains(string() , '%s')]";
    public static final String MSG_NO_DATA_BY_TABLE_ID = "//table[@id = '%s']//td[text() = 'No data available in table']";
    public static final String NUMBER_RECORD_BY_TABLE_ID = "//table[@id = '%s']//td[contains(@class , 'button-column')]";
    public static final String TABLE_COLUMN_BY_ID = "//table[@id = '%s']//tr//th[contains(string() , '%s')]/preceding-sibling::th";
    public static final String TABLE_ROW_BY_ID = "//table[@id = '%s']//tbody/tr[%s]/td[%s]";
    public static final String CHECKBOX_BY_ID = "//input[@id = 'SearchIncludeSubCategories']";
    public static final String DELETE_ROLE_BY_NAME = "//li[@role = 'option']//span[contains(string() , '%s')]/following-sibling::span/span[@class='k-icon k-i-close']";
    public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[@data-card-name = '%s']//button[@class = 'btn btn-tool']/i";
    public static final String ALERT_SUCCESS_MSG = "//div[@class = 'alert alert-success alert-dismissable']";
}
