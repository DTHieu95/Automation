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
    editAddressPO editAddressPage;
    addNewAddressPO addNewAddressPage;
    String productName , srcImage;
    String cusEmail , cusPass , cusFirstName , cusLastName , cusGender , cusDOB , cusCompany , adminComment , cusRole;
    String editCusEmail , editCusFirstName , editCusLastName  , editCusDOB , editCusCompany , editAdminComment ;
    String addFirstName , addLastName , addEmail , addCompany , addCountry , addRegion, addCity , add1 , add2 , addZip , addPhone , addFax;
    String editAddFirstName , editAddLastName , editAddEmail , editAddCompany , editAddCountry , editAddRegion, addState , editAddCity , editAdd1 , editAdd2 , editAddZip , editAddPhone , editAddFax;



    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        cusEmail = "automationfc@gmail.com";                editCusEmail = "edit_automationfc@gmail.com";
        cusPass = "Han@123do";                              editCusFirstName = "Edit Automation";
        cusFirstName = "Automation";                        editCusLastName = "Edit FC";
        cusLastName = "FC";                                 editCusDOB = "2/2/2000";
        cusGender = "Male";                                 editCusCompany = "Edit Automation FC";
        cusDOB = "1/1/2000";                                editAdminComment = "Edit Customer (Guest)";
        cusCompany ="Automation FC";
        adminComment = "Add new Customer (Guest)";
        cusRole = "Guests";

        addFirstName = "Automation";                        editAddFirstName = "Edit Automation";
        addLastName = "FC";                                 editAddLastName = "Edit FC";
        addEmail = "automationfc@gmail.com";                editAddEmail = "edit_automationfc@gmail.com";
        addCompany = "Automation FC";                       editAddCompany = "Edit Automation FC";
        addCountry = "Viet Nam";                            editAddCountry = "United States";
        addRegion = "VN";                                   addState = "California";
        addCity = "Ho Chi Minh";                            editAddRegion = "Edit Region";
        add1 = "743 Le Loi";                                editAddCity = "Albany";
        add2 = "453 Le Lai";                                editAdd1 = "123 PO Box";
        addZip = "650000";                                  editAdd2 = "356 Los Bancos";
        addPhone = "0123456789";                            editAddZip ="150000";
        addFax = "0987654321";                              editAddPhone = "1234567890";
                                                            editAddFax = "9876543210";
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

    @Test
    public void TC_03(){
        editProductPage.hoverMenuAndClickSubMenu(driver , "Customers" , "Customers");

        customerSearchPage = pageGenerator.getCustomerSearchPage(driver);
        verifyEquals(customerSearchPage.getContentHeaderAdmin(driver) , "Customers");

        log.info("Add new customer");
        customerSearchPage.clickToButton(driver , "Add new");
        addNewCustomerPage = pageGenerator.GetAddNewCustomerPage(driver);
        verifyEquals(addNewCustomerPage.getContentHeaderAdmin(driver) , "Add a new customer");
        addNewCustomerPage.sendKeyToField(driver , "Email" , cusEmail);
        addNewCustomerPage.sendKeyToField(driver , "Password" , cusPass);
        addNewCustomerPage.checkToRadioBox(driver , cusGender);
        addNewCustomerPage.sendKeyToField(driver , "FirstName" , cusFirstName);
        addNewCustomerPage.sendKeyToField(driver , "LastName" , cusLastName);
        addNewCustomerPage.sendKeyToField(driver , "DateOfBirth" , cusDOB);
        addNewCustomerPage.sendKeyToField(driver , "Company" , cusCompany);
        addNewCustomerPage.deleteRoleByName(driver , "Registered");
        addNewCustomerPage.selectValueInDropdownName(driver , "SelectedCustomerRoleIds" , cusRole);
        addNewCustomerPage.sendKeyToField(driver , "AdminComment" , adminComment);
        addNewCustomerPage.clickToButton(driver , "Save and Continue Edit");

        editCustomerPage = pageGenerator.getEditCustomerPage(driver);

        log.info("Verify message success and value in field");
        verifyEquals(editCustomerPage.getMsgInAlertSuccess(driver) , "The customer has been updated successfully.");
        verifyEquals(editCustomerPage.getContentHeaderAdmin(driver) , "Edit customer details - " + cusLastName + " " + cusFirstName);
        verifyEquals(editCustomerPage.getValueInField(driver , "Email") , cusEmail);
        verifyEquals(editCustomerPage.getValueInField(driver , "FirstName") , cusFirstName);
        verifyEquals(editCustomerPage.getValueInField(driver , "LastName") , cusLastName);
        verifyEquals(editCustomerPage.getValueInField(driver , "Company") , cusCompany);
        verifyEquals(editCustomerPage.getValueInField(driver , "DateOfBirth") , cusDOB);
        verifyTrue(editCustomerPage.isCheckBoxSelected(driver , cusGender));
        verifyEquals(editCustomerPage.getSelectedValueFromDropdown(driver , "SelectedCustomerRoleIds") , cusRole);
        verifyEquals(editCustomerPage.getTextInField(driver , "AdminComment") , adminComment);

        log.info("Back to customer list");
        editCustomerPage.clickToLink(driver , "back to customer list");
        customerSearchPage = pageGenerator.getCustomerSearchPage(driver);

        log.info("Search with customer role and verify customer is shown in result");
        customerSearchPage.deleteRoleByName(driver , "Registered");
        customerSearchPage.selectValueInDropdownName(driver , "SelectedCustomerRoleIds" , cusRole);
        customerSearchPage.clickToButton(driver , "Search");
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , cusFirstName + " " + cusLastName, cusRole , cusCompany , "true"));

        log.info("Search customer with mail");
        customerSearchPage.sendKeyToField(driver , "SearchEmail" , cusEmail);
        customerSearchPage.clickToButton(driver , "Search");
        verifyEquals(customerSearchPage.getNumberRecordByID(driver , "customers-grid") , 1);
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , cusFirstName + " " + cusLastName, cusRole , cusCompany , "true"));

        log.info("Search with customer with first name and last name");
        customerSearchPage.sendKeyToField(driver , "SearchEmail" , "");
        customerSearchPage.sendKeyToField(driver , "SearchFirstName" , cusFirstName);
        customerSearchPage.sendKeyToField(driver , "SearchLastName" , cusLastName);
        customerSearchPage.clickToButton(driver , "Search");
        verifyEquals(customerSearchPage.getNumberRecordByID(driver , "customers-grid") , 1);
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , cusFirstName + " " + cusLastName, cusRole , cusCompany , "true"));

        log.info("Search with customer with company");
        customerSearchPage.sendKeyToField(driver , "SearchCompany" , cusCompany);
        customerSearchPage.sendKeyToField(driver , "SearchFirstName" , "");
        customerSearchPage.sendKeyToField(driver , "SearchLastName" , "");
        customerSearchPage.clickToButton(driver , "Search");
        verifyEquals(customerSearchPage.getNumberRecordByID(driver , "customers-grid") , 1);
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , cusFirstName + " " + cusLastName, cusRole , cusCompany , "true"));

        log.info("Search with customer with first name and last name");
        customerSearchPage.sendKeyToField(driver , "SearchEmail" , cusEmail);
        customerSearchPage.sendKeyToField(driver , "SearchFirstName" , cusFirstName);
        customerSearchPage.sendKeyToField(driver , "SearchLastName" , cusLastName);
        customerSearchPage.sendKeyToField(driver , "SearchCompany" , cusCompany);
        customerSearchPage.selectValueInDropdownName(driver , "SearchMonthOfBirth" , "1");
        customerSearchPage.selectValueInDropdownName(driver , "SearchDayOfBirth" , "1");
        customerSearchPage.clickToButton(driver , "Search");
        verifyEquals(customerSearchPage.getNumberRecordByID(driver , "customers-grid") , 1);
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , cusFirstName + " " + cusLastName, cusRole , cusCompany , "true"));

    }

    @Test
    public void TC_04(){
        customerSearchPage.clickToButtonByIDAndName(driver , "customers-grid" , cusFirstName + " " + cusLastName, "Edit");
        editCustomerPage = pageGenerator.getEditCustomerPage(driver);

        log.info("Edit Customer");
        addNewCustomerPage.sendKeyToField(driver , "Email" , cusEmail);
        addNewCustomerPage.sendKeyToField(driver , "FirstName" , editCusFirstName);
        addNewCustomerPage.sendKeyToField(driver , "LastName" , editCusLastName);
        addNewCustomerPage.sendKeyToField(driver , "DateOfBirth" , editCusDOB);
        editCustomerPage.sendKeyToField(driver , "Company" , editCusCompany);
        addNewCustomerPage.sendKeyToField(driver , "AdminComment" , editAdminComment);
        addNewCustomerPage.clickToButton(driver , "Save");

        customerSearchPage = pageGenerator.getCustomerSearchPage(driver);
        verifyEquals(customerSearchPage.getMsgInAlertSuccess(driver) , "The customer has been updated successfully.");

        log.info("Search with new value after updating");
        customerSearchPage.sendKeyToField(driver , "SearchEmail" , editCusEmail);
        customerSearchPage.sendKeyToField(driver , "SearchFirstName" , editCusFirstName);
        customerSearchPage.sendKeyToField(driver , "SearchLastName" , editCusLastName);
        customerSearchPage.sendKeyToField(driver , "SearchCompany" , editCusCompany);
        customerSearchPage.selectValueInDropdownName(driver , "SearchMonthOfBirth" , "2");
        customerSearchPage.selectValueInDropdownName(driver , "SearchDayOfBirth" , "2");
        customerSearchPage.clickToButton(driver , "Search");
        verifyEquals(customerSearchPage.getNumberRecordByID(driver , "customers-grid") , 1);
        verifyTrue(customerSearchPage.isResultDisplayedInTable(cusRole , editCusFirstName + " " + editCusLastName, cusRole , editCusCompany , "true"));
    }

    @Test
    public void TC_05(){
        customerSearchPage.clickToButtonByIDAndName(driver , "customers-grid" ,editCusFirstName + " " + editCusLastName, "Edit" );
        editCustomerPage = pageGenerator.getEditCustomerPage(driver);
        editCustomerPage.clickToToogleIconByCardName(driver , "customer-address");
        verifyTrue(editCustomerPage.isMsgNoDataDisplayedByID(driver , "customer-addresses-grid"));

        log.info("Add new address");
        editCustomerPage.clickToButton(driver , "Add new address");
        addNewAddressPage = pageGenerator.getAddNewAddressPage(driver);
        verifyEquals(addNewAddressPage.getContentHeaderAdmin(driver) , "Add a new address");
        addNewAddressPage.sendKeyToField(driver , "Address_FirstName" ,addFirstName );
        addNewAddressPage.sendKeyToField(driver , "Address_LastName" ,addLastName );
        addNewAddressPage.sendKeyToField(driver , "Address_Email" ,addEmail );
        addNewAddressPage.sendKeyToField(driver , "Address_Company" ,addCompany );
        addNewAddressPage.selectValueInDropdownName(driver , "Address.CountryId" , addCountry);
        addNewAddressPage.sendKeyToField(driver , "Address_County" ,addRegion );
        addNewAddressPage.sendKeyToField(driver , "Address_City" ,addCity );
        addNewAddressPage.sendKeyToField(driver , "Address_Address1" ,add1 );
        addNewAddressPage.sendKeyToField(driver , "Address_Address2" ,add2 );
        addNewAddressPage.sendKeyToField(driver , "Address_ZipPostalCode" ,addZip );
        addNewAddressPage.sendKeyToField(driver , "Address_PhoneNumber" ,addPhone );
        addNewAddressPage.sendKeyToField(driver , "Address_FaxNumber" ,addFax );
        addNewAddressPage.clickToButton(driver , "Save");
        editAddressPage = pageGenerator.getEditAddressPage(driver);

        log.info("Verify value after creating in edit page");
        verifyEquals(editAddressPage.getMsgInAlertSuccess(driver) , "The new address has been added successfully.");
        verifyEquals(editAddressPage.getContentHeaderAdmin(driver) , "Edit address");
        verifyEquals(editAddressPage.getValueInField(driver , "Address_FirstName") , addFirstName);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_LastName") , addLastName);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Email") , addEmail);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Company") , addCompany);
        verifyEquals(editAddressPage.getSelectedValueFromDropdown(driver , "Address.CountryId") , addCountry);
        verifyEquals(editAddressPage.getSelectedValueFromDropdown(driver , "Address.StateProvinceId") , "Other");
        verifyEquals(editAddressPage.getValueInField(driver , "Address_County") , addRegion);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_City") , addCity);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Address1") , add1);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Address2") , add2);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_ZipPostalCode") , addZip);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_PhoneNumber") , addPhone);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_FaxNumber") , addFax);
        editAddressPage.clickToLink(driver , "back to customer details");
        editCustomerPage = pageGenerator.getEditCustomerPage(driver);

        log.info("Verify value address in table");
        verifyEquals(editCustomerPage.getNumberRecordByID(driver , "customer-addresses-grid") , 1);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "First Name" , "1") , addFirstName);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Last name" , "1") , addLastName);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Email" , "1") , addEmail);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Phone number" , "1") , addPhone);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Fax number" , "1") , addFax);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Address" , "1") , addCompany + "\n" + add1 + "\n" + add2 + "\n" + addCity + "," + addZip + "\n" + addCountry);

        editCustomerPage.clickToButtonByIDAndName(driver , "customer-addresses-grid" , addEmail , "Edit");
        editAddressPage = pageGenerator.getEditAddressPage(driver);

        log.info("Edit address with new value");
        addNewAddressPage.sendKeyToField(driver , "Address_FirstName" ,editAddFirstName );
        addNewAddressPage.sendKeyToField(driver , "Address_LastName" ,editAddLastName );
        addNewAddressPage.sendKeyToField(driver , "Address_Email" ,editAddEmail );
        addNewAddressPage.sendKeyToField(driver , "Address_Company" ,editAddCompany );
        addNewAddressPage.selectValueInDropdownName(driver , "Address.CountryId" , editAddCountry);
        editAddressPage.selectValueInDropdownName(driver , "Address.StateProvinceId" ,addState);
        addNewAddressPage.sendKeyToField(driver , "Address_County" ,editAddRegion );
        addNewAddressPage.sendKeyToField(driver , "Address_City" ,editAddCity );
        addNewAddressPage.sendKeyToField(driver , "Address_Address1" ,editAdd1 );
        addNewAddressPage.sendKeyToField(driver , "Address_Address2" ,editAdd2 );
        addNewAddressPage.sendKeyToField(driver , "Address_ZipPostalCode" ,editAddZip );
        addNewAddressPage.sendKeyToField(driver , "Address_PhoneNumber" ,editAddPhone );
        addNewAddressPage.sendKeyToField(driver , "Address_FaxNumber" ,editAddFax );
        addNewAddressPage.clickToButton(driver , "Save");

        log.info("Verify value in edit page");
        verifyEquals(editAddressPage.getMsgInAlertSuccess(driver) , "The address has been updated successfully.");
        verifyEquals(editAddressPage.getContentHeaderAdmin(driver) , "Edit address");
        verifyEquals(editAddressPage.getValueInField(driver , "Address_FirstName") , editAddFirstName);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_LastName") , editAddLastName);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Email") , editAddEmail);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Company") , editAddCompany);
        verifyEquals(editAddressPage.getSelectedValueFromDropdown(driver , "Address.CountryId") , editAddCountry);
        verifyEquals(editAddressPage.getSelectedValueFromDropdown(driver , "Address.StateProvinceId") , addState);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_County") , editAddRegion);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_City") , editAddCity);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Address1") , editAdd1);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_Address2") , editAdd2);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_ZipPostalCode") , editAddZip);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_PhoneNumber") , editAddPhone);
        verifyEquals(editAddressPage.getValueInField(driver , "Address_FaxNumber") , editAddFax);
        editAddressPage.clickToLink(driver , "back to customer details");
        editCustomerPage = pageGenerator.getEditCustomerPage(driver);

        log.info("Verify value address after updating");
        verifyEquals(editCustomerPage.getNumberRecordByID(driver , "customer-addresses-grid") , 1);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "First Name" , "1") , editAddFirstName);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Last name" , "1") , editAddLastName);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Email" , "1") , editAddEmail);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Phone number" , "1") , editAddPhone);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Fax number" , "1") , editAddFax);
        verifyEquals(editCustomerPage.getTextInTableByID(driver , "customer-addresses-grid" , "Address" , "1") , editAddCompany + "\n" + editAdd1 + "\n" + editAdd2 + "\n" + editAddCity + "," + addState + "," + editAddZip + "\n" + editAddCountry);

        log.info("Delete address");
        editCustomerPage.clickToButtonByIDAndName(driver , "customer-addresses-grid" , editAddEmail , "Delete");
        editCustomerPage.acceptAlert(driver);
        verifyEquals(editCustomerPage.getNumberRecordByID(driver , "customer-addresses-grid") , 0);
        verifyTrue(editCustomerPage.isMsgNoDataDisplayedByID(driver , "customer-addresses-grid"));
    }
}
