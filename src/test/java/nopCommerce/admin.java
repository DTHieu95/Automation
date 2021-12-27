package nopCommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.nopCommerce.*;

public class admin extends BaseTest {
    WebDriver driver;
    loginPO loginPage;
    productSearchPO productSearchPage;
    dashboardPO dashboardPage;
    editProductPO editProductPage;
    customerSearchPO customerSearchPage;
    editCustomerPO editCustomerPage;
    addNewCustomerPO addNewCustomerPage;
    String productName , srcImage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        srcImage = productName.toLowerCase().replace(" " , "-");

        loginPage = pageGenerator.getLoginPage(driver);
        loginPage.sendKeyToField(driver , "Email" , "admin@yourstore.com");
        loginPage.sendKeyToField(driver , "Password" , "admin");
        loginPage.clickToButton(driver , "Log in");

        dashboardPage = pageGenerator.getDashboardPage(driver);
    }

    @Test
    public void TC_01(){
        verifyEquals(dashboardPage.getContentHeaderAdmin(driver) , "Dashboard");

        log.info("Go to product page");
        dashboardPage.hoverMenuAndClickSubMenu(driver , "Catalog" , "Products");
        productSearchPage = pageGenerator.getProductSearchPage(driver);

        log.info("Search with product name and verify result");
        productSearchPage.sendKeyToField(driver , "SearchProductName" , "SearchProductName");
        productSearchPage.clickToButton(driver , "Search");
        verifyEquals(productSearchPage.getNumberRecordByID(driver , "products-grid") , 1);
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Picture" , "src" , "1").contains(srcImage));
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Product Name" , "1") , productName);
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "SKU" , "1") , "LE_IC_600");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Price" , "1") , "500");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Stock quantity" , "1") , "10000");
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Published" , "class" , "1").contains("true-icon"));

        log.info("Search with product name + parent category + unchecked");
        productSearchPage.sendKeyToField(driver , "SearchProductName" , "SearchProductName");
        productSearchPage.selectValueInDropdownName(driver , "SearchCategoryId" , "Computer");
        productSearchPage.uncheckCheckboxByID(driver , "SearchCategoryId");
        productSearchPage.clickToButton(driver , "Search");
        verifyTrue(productSearchPage.isMsgNoDataDisplayedByID(driver , "products-grid"));
        verifyEquals(productSearchPage.getNumberRecordByID(driver , "products-grid") , 0);

        log.info("Search with product name + parent categories + checked and verify result");
        productSearchPage.sendKeyToField(driver , "SearchProductName" , "SearchProductName");
        productSearchPage.selectValueInDropdownName(driver , "SearchCategoryId" , "Computer");
        productSearchPage.checkToCheckboxByID(driver , "SearchIncludeSubCategories");
        productSearchPage.clickToButton(driver , "Search");
        verifyEquals(productSearchPage.getNumberRecordByID(driver , "products-grid") , 1);
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Picture" , "src" , "1").contains(srcImage));
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Product Name" , "1") , productName);
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "SKU" , "1") , "LE_IC_600");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Price" , "1") , "500");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Stock quantity" , "1") , "10000");
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Published" , "class" , "1").contains("true-icon"));

        log.info("Search with product name + child category and verify result");
        productSearchPage.sendKeyToField(driver , "SearchProductName" , "SearchProductName");
        productSearchPage.selectValueInDropdownName(driver , "SearchCategoryId" , "Computers >> Desktops");
        productSearchPage.uncheckCheckboxByID(driver , "SearchCategoryId");
        productSearchPage.clickToButton(driver , "Search");
        verifyEquals(productSearchPage.getNumberRecordByID(driver , "products-grid") , 1);
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Picture" , "src" , "1").contains(srcImage));
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Product Name" , "1") , productName);
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "SKU" , "1") , "LE_IC_600");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Price" , "1") , "500");
        verifyEquals(productSearchPage.getTextInTableByID(driver , "products-grid" , "Stock quantity" , "1") , "10000");
        verifyTrue(productSearchPage.getValueInTableByID(driver , "products-grid" , "Published" , "class" , "1").contains("true-icon"));

        log.info("Search with product name + manufacturer");
        productSearchPage.sendKeyToField(driver , "SearchProductName" , "SearchProductName");
        productSearchPage.selectValueInDropdownName(driver , "SearchCategoryId" , "All");
        productSearchPage.uncheckCheckboxByID(driver , "SearchCategoryId");
        productSearchPage.selectValueInDropdownName(driver , "SearchManufacturerId" , "Apple");
        productSearchPage.clickToButton(driver , "Search");
        verifyTrue(productSearchPage.isMsgNoDataDisplayedByID(driver , "products-grid"));
        verifyEquals(productSearchPage.getNumberRecordByID(driver , "products-grid") , 0);
    }

    @Test
    public void TC_02(){
        log.info("Rediret to product by SKU");
        productSearchPage.sendKeyToField(driver , "GoDirectlyToSku" , "LE_IC_600");
        productSearchPage.clickToButton(driver , "Go");

        editProductPage = pageGenerator.getEditProductPage(driver);
        verifyEquals(editProductPage.getContentHeaderAdmin(driver) , "Edit product details - " + productName);
    }
}
