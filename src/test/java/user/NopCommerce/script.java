package user.NopCommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.util.Locale;

public class script extends BaseTest {
    WebDriver driver;
    homePO homePage;
    registerPO registerPage;
    loginPO loginPage;
    customerInfoPO customerInfoPage;
    addressPO addressPage;
    changePassPO changePassPage;
    productReviewPO productReviewPage;
    productDetailPO productDetailPage;
    searchPO searchPage;
    reviewPO reviewPage;
    notebookPO notebookPage;
    computerPO computerPage;
    shoppingCartPO shoppingCartPage;
    wishlistPO wishlistPage;
    compareProductPO compareProductPage;
    recentlyViewProductPO recentlyViewProductPage;
    desktopPO desktopPage;
    checkoutPO checkoutPage;
    orderPO orderPage;
    orderDetailPO orderDetailPage;

    String firstName , lastName , email , password , newPass , product;
    String addFN , addLN , addEmail , addCompany , addCountry , addState , city , add1 , add2 , zip , phone , fax;
    String SKU , quantity , price , totalAmount , productName , srcImage , productName1;
    String CPU , screen , memory, price1 , CPU1 , screen1 , memory1 , hardDrive;
    String productName2 , productName3 , productName4;
    String processor , ram , hdd , os , software , software2 , software3 , atributeMiniCart;
    Float Price;
    String billFN , billLN , billMail , billCompany , billCountry , billCity , billAdd1 , billAdd2 , billZip , billPhone , billFax , payMethod;
    String shipFN , shipLN , shipMail , shipCompany , shipCountry , shipCity , shipAdd1 , shipAdd2 , shipZip , shipPhone , shipFax , shipMethod;
    String orderID , orderID1 , dateCalendar , priceProduct1 , SKU1 , quantity1 , srcImage1 , total1 , re_quantity , re_total;
    String typeCard , cardName , cardNumber , expMonth , expYear , cardCode;
    String billFN1 , billLN1 , billMail1 , billCompany1 , billCountry1 , billCity1 , billAdd11 , billAdd21 , billZip1 , billPhone1 , billFax1;
    String shipFN1 , shipLN1 , shipMail1 , shipCompany1 , shipCountry1 , shipCity1 , shipAdd11 , shipAdd21 , shipZip1 , shipPhone1 , shipFax1;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        homePage = pageGeneratorManager.getHomePage(driver);

        firstName = "Hieu";
        lastName = "DT";
        email = "hieudt1095@gmail.com";
        password = "Han@123do";
        newPass = "Han@456do";
        product = "Build your own computer";

        //Address
        addFN = "Automation";
        addLN = "FC";
        addEmail = "automationfc.vn@gmail.com";
        addCompany = "Automation FC";
        addCountry = "Vietnam";
        addState = "Other";
        city = "Da Nang";
        add1 = "123/04 Le Lai";
        add2 = "234/05 Hai Phong";
        zip = "550000";
        phone = "0123456789";
        fax = "0987654321";

        totalAmount = String.valueOf(Float.parseFloat(quantity) * Float.parseFloat(price));
        productName = "Apple MacBook Pro 13-inch";
        srcImage = productName.toLowerCase().replace(" " , "-");
        srcImage1 = productName1.toLowerCase().replace(" " , "-");

        productName1 = "Asus N551JK-XO076H Laptop";
        productName2 = "Samsung Series 9 NP900X4C Premium Ultrabook";
        productName3 = "HP Spectre XT Pro UltraBook";
        productName4 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";

        processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        ram = "8GB [+$60.00]";
        hdd = "400 GB [+$100.00]";
        os = "Vista Premium [+$60.00]";
        software = "Microsoft Office [+$50.00]";
        software2 = "Acrobat Reader [+$10.00]";
        software3 = "Total Commander [+$5.00]";

        billFN = "Hieu";                                shipFN = "Hoa";
        billLN = "DT";                                  shipLN = "NP";
        billMail = "automation@gmail.com";              shipMail = "auto@gmail.com";
        billCompany = "JSC";                            shipCompany = "CPN";
        billCountry = "Viet nam";                       shipCountry = "Viet nam";
        billCity = "HN";                                shipCity = "Hoa";
        billAdd1 =  "add1";                             shipAdd1 = "NP";
        billAdd2 = "add2";                              shipAdd2 = "auto";
        billZip = "999999";                             shipZip = "333333";
        billPhone ="0987654321";                        shipPhone = "0999999999";
        billFax = "0123456789";                         shipFax = "123456789";

        billFN1 = "Hieu1";                                shipFN1 = "Hoa1";
        billLN1 = "DT1";                                  shipLN1 = "NP1";
        billMail1 = "1automation@gmail.com";              shipMail1 = "1auto@gmail.com";
        billCompany1 = "1JSC";                            shipCompany1 = "CPN1";
        billCountry1 = "Thailand";                        shipCountry1 = "Spain";
        billCity1 = "HN1";                                shipCity1 = "Hoa1";
        billAdd11 =  "add11";                             shipAdd11 = "NP1";
        billAdd21 = "add21";                              shipAdd21 = "auto1";
        billZip1 = "9999991";                             shipZip1 = "3333331";
        billPhone1 ="09876543211";                        shipPhone1 = "09999999991";
        billFax1 = "01234567891";                         shipFax1 = "1234567891";

        shipMethod = "Ground";
        typeCard = "Visa";
        cardName = "DINH TRAN HIEU";
        cardNumber = "374245455400126" ;
        expMonth = "05";
        expYear = "2023";
        cardCode = "111";
        dateCalendar = homePage.getDateCalendarWithNoTime();



        atributeMiniCart = "Processor: " + processor + "\nRAM: " + ram + "\nHDD: " + hdd + "\nOS: " + os + "\nSoftware: " + software + "\nSoftware: " + software2 + "\nSoftware: " + software3;
    }

    @Test
    public void TC_01(){
        log.info("Click to Register in header");
        homePage.clickToHeaderLink(driver , "Register");

        registerPage = pageGeneratorManager.getRegisterPage(driver);

    }

    @Test
    public void TC_02(){
        verifyTrue(registerPage.isPageTitleCorrect(driver , "Register"));

        log.info("CLick button Register with all field is empty");
        registerPage.clickToButton(driver , "Register");

        log.info("Check show message field require in First Name");
        verifyEquals(registerPage.getErrorMessageInField(driver , "FirstName-error") , "First name is required.");

        log.info("Check show message field require in Last Name");
        verifyEquals(registerPage.getErrorMessageInField(driver , "LastName-error") , "Last name is required.");

        log.info("Check show message field require in Email");
        verifyEquals(registerPage.getErrorMessageInField(driver , "Email-error") , "Email is required.");

        log.info("Check show message field require in Password");
        verifyEquals(registerPage.getErrorMessageInField(driver , "Password-error") , "Password is required.");

        log.info("Check show message field require in confirm password");
        verifyEquals(registerPage.getErrorMessageInField(driver , "ConfirmPassword-error") , "Password is required.");
    }

    @Test
    public void TC_03(){
        log.info("Input email invalid in field");
        registerPage.sendKeyToField(driver , "Email" , "abc");

        log.info("Verify message error show in field");
        verifyEquals(registerPage.getErrorMessageInField(driver , "Email-error") , "Wrong email");

        log.info("Input valid value in field first name");
        registerPage.sendKeyToField(driver  , "FirstName" , firstName);

        log.info("Input valid value in field last name");
        registerPage.sendKeyToField(driver  , "LastName" , lastName);

        log.info("Input valid value in field email");
        registerPage.sendKeyToField(driver  , "Email" , email);

        log.info("Input valid value in field password");
        registerPage.sendKeyToField(driver  , "Password" , password);

        log.info("Input valid value in field confirm password");
        registerPage.sendKeyToField(driver  , "ConfirmPassword" , password);

        log.info("CLick to button register");
        registerPage.clickToButton(driver , "Register");

        log.info("Verify message success displayed");
        verifyEquals(registerPage.getMsgRegisterSuccess() , "Your registration completed");

        log.info("Click to continue");
        registerPage.clickToLink(driver , "Continue");

        homePage = pageGeneratorManager.getHomePage(driver);

        log.info("Verify back to home page");
        verifyTrue(homePage.isHomePageTitleShow());

        log.info("Click to Button Log out");
        homePage.clickToHeaderLink(driver , "Log out");

        log.info("Verify still in home page");
        verifyTrue(homePage.isHomePageTitleShow());

        log.info("Click to link register in home page");
        homePage.clickToHeaderLink(driver , "Register");

        registerPage = pageGeneratorManager.getRegisterPage(driver);

    }

    @Test
    public void TC_04(){
        log.info("Input valid value in field first name");
        registerPage.sendKeyToField(driver  , "FirstName" , firstName);

        log.info("Input valid value in field last name");
        registerPage.sendKeyToField(driver  , "LastName" , lastName);

        log.info("Input email has already registerd in field email");
        registerPage.sendKeyToField(driver  , "Email" , email);

        log.info("Input valid value in field password");
        registerPage.sendKeyToField(driver  , "Password" , password);

        log.info("Input valid value in field confirm password");
        registerPage.sendKeyToField(driver  , "ConfirmPassword" , password);

        log.info("CLick to button register");
        registerPage.clickToButton(driver , "Register");

        log.info("Show error message of email is already taken");
        verifyEquals(registerPage.getErrorMsgSummary(driver) , "The specified email already exists");
    }

    @Test
    public void TC_05(){
        log.info("Input password less than 6");
        registerPage.sendKeyToField(driver  , "Password" , "123");

        log.info("Verify message error displayed in field password");
        verifyEquals(registerPage.getErrorMessageInField(driver , "Password-error") , "Password must meet the following rules: \nmust have at least 6 characters");

        log.info("Input password and confirm password different");
        registerPage.sendKeyToField(driver  , "Password" , password);

        registerPage.sendKeyToField(driver  , "ConfirmPassword" , "12345");

        log.info("Verify message error displayed in field confirm pw");
        verifyEquals(registerPage.getErrorMessageInField(driver , "ConfirmPassword-error") , "The password and confirmation password do not match.");

        log.info("Click to Log in in header");
        registerPage.clickToHeaderLink(driver , "Log in");

        loginPage = pageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_06(){
        log.info("Verify login page header");
        verifyTrue(loginPage.isPageTitleCorrect(driver , "Welcome, Please Sign In!"));

        log.info("Click button log in with no data");
        loginPage.clickToButton(driver , "Log in");

        log.info("Verify message error displayed");
        verifyEquals(loginPage.getErrorMessageInField(driver , "Email-error") , "Please enter your email");

        log.info("Input invalid email");
        loginPage.sendKeyToField(driver , "Email" , "hieu");

        log.info("Verify message error displayed");
        verifyEquals(loginPage.getErrorMessageInField(driver , "Email-error") , "Wrong email");

        log.info("Input email not registed");
        loginPage.sendKeyToField(driver , "Email" , "hieudt10095@gmail.com");

        loginPage.clickToButton(driver , "Log in");

        log.info("Verify error message displayed");
        verifyEquals(loginPage.getErrorMsgSummary(driver) ,"Login was unsuccessful. Please correct the errors and try again. \nNo customer account found");

        log.info("Input email is already registed");
        loginPage.sendKeyToField(driver , "Email" , email);

        loginPage.clickToButton(driver , "Log in");

        log.info("Verify error message displayed");
        verifyEquals(loginPage.getErrorMsgSummary(driver) , "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("Input email valid and wrong password");
        loginPage.sendKeyToField(driver , "Email" , email);

        loginPage.sendKeyToField(driver , "Password" , "Han@3do");

        loginPage.clickToButton(driver , "Log in");

        log.info("Verify error message displayed");
        verifyEquals(loginPage.getErrorMsgSummary(driver) , "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("Input correct email and password");
        loginPage.sendKeyToField(driver , "Email" , email);

        loginPage.sendKeyToField(driver , "Password" , password);

        loginPage.clickToButton(driver , "Log in");

        homePage = pageGeneratorManager.getHomePage(driver);

        log.info("Verify back to home page");
        verifyTrue(homePage.isHomePageTitleShow());
    }

    @Test
    public void TC_07(){
        homePage.clickToHeaderLink(driver , "My Account");

        customerInfoPage = pageGeneratorManager.getCustomerInfoPage(driver);

        log.info("verify header of customer info page");
        verifyTrue(customerInfoPage.isPageTitleCorrect(driver , "My account - Customer info"));

        log.info("Select radio box female");
        customerInfoPage.checkToRadioBox(driver , "Female");

        log.info("Update value in field first name");
        customerInfoPage.sendKeyToField(driver , "FirstName" , "Automation");

        log.info("Update value in field last name");
        customerInfoPage.sendKeyToField(driver , "LastName" , "FC");

        log.info("Select value in drop down DOB");
        customerInfoPage.selectValueInDropdownName(driver , "DateOfBirthDay" , "1");

        customerInfoPage.selectValueInDropdownName(driver , "DateOfBirthMonth" , "1");

        customerInfoPage.selectValueInDropdownName(driver , "DateOfBirthYear" , "1999");

        log.info("Update value in field email");
        customerInfoPage.sendKeyToField(driver , "Email" , "automationfc.vn@gmail.com");

        log.info("Update value in field company");
        customerInfoPage.sendKeyToField(driver , "Company" , "Automation FC");

        log.info("CLick button Save");
        customerInfoPage.clickToButton(driver , "Save");

        log.info("Verify checkbox female is selected");
        verifyTrue(customerInfoPage.isRadioBoxSelected(driver , "Female"));

        log.info("Verify value first name after updating");
        verifyEquals(customerInfoPage.getValueInField(driver , "FirstName") , "Automation");

        log.info("Verify value last name after updating");
        verifyEquals(customerInfoPage.getValueInField(driver , "LastName") , "FC");

        log.info("Verify value email after updating");
        verifyEquals(customerInfoPage.getValueInField(driver , "Email") , "automationfc.vn@gmail.com");

        log.info("Verify value company after updating");
        verifyEquals(customerInfoPage.getValueInField(driver , "Company") , "Automation FC");

        log.info("Click to menu side Address");
        customerInfoPage.clickToMenuSideByName(driver , "Addresses");

    }

    @Test
    public void TC_08(){
        addressPage = pageGeneratorManager.getAddressPage(driver);

        log.info("Verify address page header");
        verifyTrue(addressPage.isPageTitleCorrect(driver , "My account - Addresses"));

        log.info("Verify displayed message no data");
        verifyTrue(addressPage.isMsgNoDataDisplayed(driver , "No addresses"));

        log.info("CLick button Add new");
        addressPage.clickToButton(driver , "Add new");

        log.info("Verify header of add address");
        verifyTrue(addressPage.isPageTitleCorrect(driver , "My account - Add new address"));

        log.info("Input value in field first name");
        addressPage.sendKeyToField(driver , "Address_FirstName" , addFN);

        log.info("Input value in field last name");
        addressPage.sendKeyToField(driver , "Address_LastName" , addLN);

        log.info("Input value in field email");
        addressPage.sendKeyToField(driver , "Address_Email" , addEmail);

        log.info("Input value in field company");
        addressPage.sendKeyToField(driver , "Address_Company" , addCompany);

        log.info("Select value in country");
        addressPage.selectValueInDropdownName(driver , "Address.CountryId" , addCountry);

        log.info("Input value in field city");
        addressPage.sendKeyToField(driver , "Address_City" , city);

        log.info("Input value in field address 1");
        addressPage.sendKeyToField(driver , "Address_Address1" , add1);

        log.info("Input value in field address 2");
        addressPage.sendKeyToField(driver , "Address_Address2" , add2);

        log.info("Input value in field zip");
        addressPage.sendKeyToField(driver , "Address_ZipPostalCode" , zip);

        log.info("Input value in field phone");
        addressPage.sendKeyToField(driver , "Address_PhoneNumber" , phone);

        log.info("Input value in field fax");
        addressPage.sendKeyToField(driver , "Address_FaxNumber" , fax);

        log.info("CLick to button save");
        addressPage.clickToButton(driver , "Save");

        log.info("Verify value name");
        verifyEquals(addressPage.getValueofAddress("name") , addFN + " " + addLN);

        log.info("Verify value email");
        verifyEquals(addressPage.getValueofAddress("email") , "Email:\n" + addEmail);

        log.info("Verify value phone number");
        verifyEquals(addressPage.getValueofAddress("phone") , "Phone number:" + " " + phone);

        log.info("Verify value fax number");
        verifyEquals(addressPage.getValueofAddress("fax") , "Fax number:" + " " + fax);

        log.info("Verify value of company");
        verifyEquals(addressPage.getValueofAddress("company") , addCompany);

        log.info("Verify value of address 1");
        verifyEquals(addressPage.getValueofAddress("address1") , add1);

        log.info("Verify value of address 2");
        verifyEquals(addressPage.getValueofAddress("address2") , add2);

        log.info("CLick menu side change password");
        addressPage.clickToMenuSideByName(driver , "Change password");

        changePassPage = pageGeneratorManager.getChangePassPage(driver);
    }

    @Test
    public void TC_09(){
        log.info("Verify header page change password");
        verifyTrue(changePassPage.isPageTitleCorrect(driver , "My account - Change password"));

        log.info("Input value in old password");
        changePassPage.sendKeyToField(driver , "OldPassword" , password);

        log.info("Input value in new password");
        changePassPage.sendKeyToField(driver , "NewPassword" , newPass);

        log.info("Input value in confirm password");
        changePassPage.sendKeyToField(driver , "ConfirmNewPassword" ,  newPass);

        log.info("Click button change password");
        changePassPage.clickToButton(driver , "Change password");

        log.info("Verify message success displayed in bar");
        verifyEquals(changePassPage.getSuccessMsgInBar(driver) , "Password was changed");

        log.info("CLick icon close");
        changePassPage.clickToCloseMsgBar(driver);

        log.info("CLick log out");
        changePassPage.clickToHeaderLink(driver , "Log out");

        homePage = pageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLink(driver , "Log in");

        loginPage = pageGeneratorManager.getLoginPage(driver);

        log.info("Log in with old password");
        loginPage.sendKeyToField(driver , "Email" , "automationfc.vn@gmail.com");

        loginPage.sendKeyToField(driver , "Password" , password);

        loginPage.clickToButton(driver , "Log in");

        verifyEquals(loginPage.getErrorMsgSummary(driver) , "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("Log in with new password");
        loginPage.sendKeyToField(driver , "Email" , "automationfc.vn@gmail.com");

        loginPage.sendKeyToField(driver , "Password" , newPass);

        loginPage.clickToButton(driver , "Log in");

        homePage = pageGeneratorManager.getHomePage(driver);

        verifyTrue(homePage.isHomePageTitleShow());
    }

    @Test
    public void TC_10(){
        homePage.clickToLinkProduct(driver , product);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.clickToLink(driver , "Add your review");

        reviewPage = pageGeneratorManager.getReviewPage(driver);

        reviewPage.sendKeyToField(driver , "AddProductReview_Title" , "Review computer");

        reviewPage.sendKeyToField(driver , "AddProductReview_ReviewText" , "Review computer details");

        reviewPage.clickToButton(driver , "Submit review");

        reviewPage.clickToHeaderLink(driver , "My Account");

        customerInfoPage = pageGeneratorManager.getCustomerInfoPage(driver);

        customerInfoPage.clickToMenuSideByName(driver , "My product reviews");

        productReviewPage = pageGeneratorManager.getProducReviewPage(driver);

        verifyTrue(productReviewPage.isPageTitleCorrect(driver , "My account - My product reviews"));

        verifyEquals(productReviewPage.getReviewTitle() , "Review computer");

        verifyEquals(productReviewPage.getReviewContent() , "Review computer details");

        verifyEquals(productReviewPage.getReviewInfo() , "Product review for:\n" + product);
    }

    @Test
    public void TC_11(){
        productReviewPage.clickToLinkFooter(driver , "Search");

        searchPage = pageGeneratorManager.getSearchPage(driver);

        verifyTrue(searchPage.isPageTitleCorrect(driver , "Search"));

        log.info("Search with no fill keyword");
        searchPage.clickToButton(driver , "Search");

        verifyTrue(searchPage.isMsgWarningDisplayed());

        log.info("Search with data no exist");
        searchPage.sendKeyToField(driver , "q" , "Macbook Pro 2050");

        searchPage.clickToButton(driver , "Search");

        verifyTrue(searchPage.isMsgNoResultDisplayed());

        log.info("Relative search");
        searchPage.sendKeyToField(driver , "q" , "Lenovo");

        searchPage.clickToButton(driver , "Search");

        verifyEquals(searchPage.getNumberProduct(driver) , 2);

        verifyTrue(searchPage.isSearchProductCorrect(driver , "Lenono"));

        log.info("Great search");
        searchPage.sendKeyToField(driver , "q" , "Thinkpad X1 Carbon");

        searchPage.clickToButton(driver , "Search");

        verifyEquals(searchPage.getNumberProduct(driver) , 1);

        verifyEquals(searchPage.getProductName(driver) , "Lenovo Thinkpad X1 Carbon");

        log.info("Advanced search with parent categories");
        searchPage.sendKeyToField(driver , "q" , "Apple Macbook Pro");

        searchPage.checkToRadioBox(driver , "Advanced search");

        searchPage.selectValueInDropdownName(driver , "cid" , "Computers");

        searchPage.clickToButton(driver , "Search");

        verifyEquals(searchPage.getNumberProduct(driver) , 0);

        verifyTrue(searchPage.isMsgNoResultDisplayed());
    }

    @Test
    public void TC_12(){
        log.info("Advanced search with sub categories");
        searchPage.sendKeyToField(driver , "q" , "Apple Macbook Pro");
        searchPage.checkToRadioBox(driver , "Advanced search");
        searchPage.selectValueInDropdownName(driver , "cid" , "Computers");
        searchPage.checkToRadioBox(driver , "Automatically search sub categories");
        searchPage.clickToButton(driver , "Search");
        verifyEquals(searchPage.getNumberProduct(driver) , 1);
        verifyEquals(searchPage.getProductName(driver) , "Apple MacBook Pro 13-inch");

        log.info("Advanced search with incorrect manufacture");
        searchPage.sendKeyToField(driver , "q" , "Apple Macbook Pro");
        searchPage.checkToRadioBox(driver , "Advanced search");
        searchPage.selectValueInDropdownName(driver , "cid" , "Computers");
        searchPage.checkToRadioBox(driver , "Automatically search sub categories");
        searchPage.selectValueInDropdownName(driver , "mid" , "HP");
        searchPage.clickToButton(driver , "Search");
        verifyEquals(searchPage.getNumberProduct(driver) , 0);
        verifyTrue(searchPage.isMsgNoResultDisplayed());

        log.info("Search with correct manufacture");
        searchPage.sendKeyToField(driver , "q" , "Apple Macbook Pro");
        searchPage.checkToRadioBox(driver , "Advanced search");
        searchPage.selectValueInDropdownName(driver , "cid" , "Computers");
        searchPage.checkToRadioBox(driver , "Automatically search sub categories");
        searchPage.selectValueInDropdownName(driver , "mid" , "Apple");
        searchPage.clickToButton(driver , "Search");
        verifyEquals(searchPage.getNumberProduct(driver) , 1);
        verifyEquals(searchPage.getProductName(driver) , "Apple MacBook Pro 13-inch");
    }

    @Test
    public void TC_13(){
        searchPage.clickToMenuHeader(driver , "Computers");

        computerPage = pageGeneratorManager.getComputerPage(driver);

        verifyTrue(computerPage.isPageTitleCorrect(driver , "Computers"));

        computerPage.clickToSubMenu(driver , "Notebooks");

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        verifyTrue(notebookPage.isPageTitleCorrect(driver , "Notebooks"));

        log.info("Sort by A - Z");
        notebookPage.selectValueInDropdownName(driver , "products-orderby" , "Name: A to Z");

        verifyTrue(notebookPage.isProductSortAscending(driver));

        log.info("Sort by Z - A");
        notebookPage.selectValueInDropdownName(driver , "products-orderby" , "Name: Z to A");

        verifyTrue(notebookPage.isProductSortDescending(driver));

        log.info("Sort by price Low to High");
        notebookPage.selectValueInDropdownName(driver , "products-orderby" , "Price: Low to High");

        verifyTrue(notebookPage.isProductPriceSortAscending(driver));

        log.info("Sort by price High to Low");
        notebookPage.selectValueInDropdownName(driver , "products-orderby" , "Price: High to Low");

        verifyTrue(notebookPage.isProductPriceSortDescending(driver));

        log.info("Displayed 3 product in page");
        notebookPage.selectValueInDropdownName(driver , "products-pagesize" , "3");

        verifyTrue(notebookPage.isNumberProductDisplayedCorrect(driver , 3));

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "previous"));

        notebookPage.clickToDifferentPage(driver , "2");

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "next"));

        log.info("Displayed 6 product in page");
        notebookPage.selectValueInDropdownName(driver , "products-pagesize" , "6");

        verifyTrue(notebookPage.isNumberProductDisplayedCorrect(driver , 6));

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "previous"));

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "next"));

        log.info("Displayed 9 product in page");
        notebookPage.selectValueInDropdownName(driver , "products-pagesize" , "9");

        verifyTrue(notebookPage.isNumberProductDisplayedCorrect(driver , 9));

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "previous"));

        verifyFalse(notebookPage.isIconPreviousOrNextDisplayed(driver , "next"));
    }

    @Test
    public void TC_14(){
        notebookPage.clickToLinkProduct(driver , "Apple MacBook Pro 13-inch");

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.clickToButton(driver , "Add to wishlist");

        verifyEquals(productDetailPage.getSuccessMsgInBar(driver) , "The product has been added to your \nwishlist");

        productDetailPage.clickToLink(driver , "wishlist");

        wishlistPage = pageGeneratorManager.getWishlistPage(driver);

        verifyTrue(wishlistPage.isPageTitleCorrect(driver , "Wishlist"));

        verifyTrue(wishlistPage.isNumberWishlistOrCartCorrect(driver , "wishlist" , "2"));

        SKU = wishlistPage.getTextInField(driver , "sku-4");

        price = wishlistPage.getTextInField(driver , "price-value-4").trim();

        quantity = wishlistPage.getValueInField(driver , "product_enteredQuantity_4");

        verifyEquals(wishlistPage.getTextInTable(driver , "cart", "SKU" , "1") , SKU);

        verifyEquals(wishlistPage.getTextInTable(driver ,"cart", "Product(s)" , "1") , productName);

        verifyTrue(wishlistPage.getValueInTable(driver ,"cart", "Image" , "src" ,"1").contains(srcImage));

        verifyEquals(wishlistPage.getTextInTable(driver  ,"cart","Price" , "1") , "Price:\n" + price);

        verifyEquals(wishlistPage.getValueInTable(driver ,"cart", "Qty." , "value" , "1") , "Qty.:\n" + quantity);

        verifyEquals(wishlistPage.getValueInTable(driver ,"cart", "Total" , "value" , "1") , "Total:\n" + totalAmount);

    }

    @Test
    public void TC_15(){
        wishlistPage.checkToCheckBoxProductName(driver , productName);

        wishlistPage.clickToButton(driver , "Add to cart");

        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        verifyTrue(shoppingCartPage.isNumberWishlistOrCartCorrect(driver , "wishlist" , "0"));

        verifyTrue(shoppingCartPage.isNumberWishlistOrCartCorrect(driver , "cart" , "2"));

        verifyTrue(shoppingCartPage.isPageTitleCorrect(driver , "Shopping cart"));

        verifyEquals(shoppingCartPage.getTextInTable(driver ,"cart", "SKU" , "1") , SKU);

        verifyEquals(shoppingCartPage.getTextInTable(driver ,"cart", "Product(s)" , "1") , productName);

        verifyTrue(shoppingCartPage.getValueInTable(driver ,"cart", "Image" , "src" ,"1").contains(srcImage));

        verifyEquals(shoppingCartPage.getTextInTable(driver  ,"cart","Price" , "1") , "Price:\n" + price);

        verifyEquals(shoppingCartPage.getValueInTable(driver ,"cart", "Qty." , "value" , "1") , "Qty.:\n" + quantity);

        verifyEquals(shoppingCartPage.getValueInTable(driver ,"cart", "Total" , "value" , "1") , "Total:\n" + totalAmount);

        shoppingCartPage.clickToLink(driver , productName);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.clickToButton(driver , "Add to wishlist");

        productDetailPage.clickToLink(driver , "wishlist");

        wishlistPage = pageGeneratorManager.getWishlistPage(driver);

        wishlistPage.clickToIconRemoveProduct(driver , productName);

        verifyEquals(wishlistPage.getMsgNoDataInPage(driver , "wishlist").trim() , "The wishlist is empty!");
    }

    @Test
    public void TC_16(){
        wishlistPage.clickToMenuHeader(driver , "Computers");

        computerPage = pageGeneratorManager.getComputerPage(driver);

        computerPage.clickToSubMenu(driver , "Notebooks");

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        notebookPage.clickToLinkProduct(driver , productName);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        CPU = productDetailPage.getValueByTitle("CPU Type");
        memory = productDetailPage.getValueByTitle("Memory");
        screen = productDetailPage.getValueByTitle("Screensize");

        productDetailPage.backToPage(driver);

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        notebookPage.clickToLinkProduct(driver , productName1);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        price1 = productDetailPage.getTextInField(driver , "price-value-5").trim();
        CPU = productDetailPage.getValueByTitle("CPU Type");
        memory = productDetailPage.getValueByTitle("Memory");
        screen = productDetailPage.getValueByTitle("Screensize");
        hardDrive = productDetailPage.getValueByTitle("Hard drive");

        productDetailPage.backToPage(driver);

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        notebookPage.clickToButtonProduct(driver , productName , "Add to compare list");

        verifyEquals(notebookPage.getSuccessMsgInBar(driver) , "The product has been added to your \nproduct comparison");

        notebookPage.clickToButtonProduct(driver , productName1 , "Add to compare list");

        verifyEquals(notebookPage.getSuccessMsgInBar(driver) , "The product has been added to your \nproduct comparison");

        notebookPage.clickToLink(driver , "product comparison");

        compareProductPage = pageGeneratorManager.getCompareProductPage(driver);

        verifyTrue(compareProductPage.isPageTitleCorrect(driver , "Compare products"));

        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "compare-products-table", "Name" , "2") , productName1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver ,"compare-products-table", "Price" , "2") , price1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Screensize" , "2") , screen1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "CPU Type" , "2") , CPU1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Memory" , "2") , memory1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Hard drive" , "2") , hardDrive);

        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Name" , "3") , productName);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Price" , "3") , price);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Screensize" , "3") , screen);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "CPU Type" , "3") , CPU);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Memory" , "3") , memory);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver,"compare-products-table" , "Hard drive" , "3") , "");

        compareProductPage.clickToLink(driver , "Clear list");

        verifyEquals(compareProductPage.getMsgNoDataInPage(driver , "compare-products").trim() , "You have no items to compare.");
    }

    @Test
    public void TC_17(){
        compareProductPage.backToPage(driver);

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        notebookPage.clickToLinkProduct(driver , productName);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.clickToLinkProduct(driver , productName1);
        productDetailPage.clickToLinkProduct(driver , productName2);
        productDetailPage.clickToLinkProduct(driver , productName3);
        productDetailPage.clickToLinkProduct(driver , productName4);

        productDetailPage.clickToLinkFooter(driver , "Recently viewed products");

        recentlyViewProductPage = pageGeneratorManager.getRecentlyViewProductPage(driver);

        verifyTrue(recentlyViewProductPage.isPageTitleCorrect(driver , "Recently viewed products"));

        verifyEquals(recentlyViewProductPage.getNumberProduct(driver) , 3);

    }

    @Test
    public void TC_18(){
        recentlyViewProductPage.clickToMenuHeader(driver , "Computer");

        recentlyViewProductPage.clickToSubMenu(driver , "Desktops");

        desktopPage = pageGeneratorManager.getDesktopPage(driver);

        desktopPage.clickToLinkProduct(driver , "Build your own computer");

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.selectValueInDropdownName(driver , "product_attribute_1" , processor);

        productDetailPage.selectValueInDropdownName(driver , "product_attribute_2" , ram);

        productDetailPage.checkToRadioBox(driver , hdd);

        productDetailPage.checkToRadioBox(driver ,os);

        productDetailPage.checkToRadioBox(driver , software);
        productDetailPage.checkToRadioBox(driver , software2);
        productDetailPage.checkToRadioBox(driver , software3);

        price = productDetailPage.getTextInField(driver , "price-value-1");

        productDetailPage.clickToButton(driver , "Add to cart");

        verifyEquals(productDetailPage.getSuccessMsgInBar(driver) , "The product has been added to your \nshopping cart");

        productDetailPage.clickToCloseMsgBar(driver);

        productDetailPage.hoverShoppingCartHeader(driver);

        verifyTrue(productDetailPage.isNumberWishlistOrCartCorrect(driver , "cart" , "1"));
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "count") , "There are \n1 item(s) \n in your cart");
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "name") , "Build your own computer");
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "attributes") , atributeMiniCart);
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "price") , "Unit price: \n" + price);
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "quantity") , "Quantity: \n" + "1");
        verifyEquals(Float.parseFloat(productDetailPage.getTextInMiniCart(driver , "total").replace("$" , "")) , "Sub-Total: +\n" +String.valueOf(Float.parseFloat(price.replace("$" , "")) * 1));

        productDetailPage.clickToButton(driver , "Go to cart");
    }

    @Test
    public void TC_19(){
        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        shoppingCartPage.clickToLink(driver , "Edit");

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        productDetailPage.selectValueInDropdownName(driver , "product_attribute_1" , "2.2 GHz Intel Pentium Dual-Core E2200");

        productDetailPage.selectValueInDropdownName(driver , "product_attribute_2" , "4GB [+$20.00]");

        productDetailPage.checkToRadioBox(driver , "320 GB");

        productDetailPage.checkToRadioBox(driver , "Vista Home [+$50.00]");

        productDetailPage.unCheckCheckbox(driver , software2);
        productDetailPage.unCheckCheckbox(driver , software3);

        productDetailPage.sendKeyToField(driver , "product_enteredQuantity_1" , "2");

        productDetailPage.clickToButton(driver , "Update");

        verifyEquals(productDetailPage.getSuccessMsgInBar(driver) , "The product has been added to your \nshopping cart");

        productDetailPage.clickToCloseMsgBar(driver);

        price = productDetailPage.getTextInField(driver , "price-value-1");

        verifyEquals(price , "$1,320.00");

        productDetailPage.hoverShoppingCartHeader(driver);

        verifyTrue(productDetailPage.isNumberWishlistOrCartCorrect(driver , "cart" , "2"));
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "count") , "There are \n2 item(s) \n in your cart");
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "name") , "Build your own computer");
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "attributes") , "Processor: 2.2 GHz Intel Pentium Dual-Core E2200" + "\nRAM: 4GB [+$20.00]" + "\nHDD: 320 GB" + "\nOS: Vista Home [+$50.00]" + "\nSoftware: Microsoft Office [+$50.00]");
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "price") , "Unit price: \n" + price);
        verifyEquals(productDetailPage.getTextInMiniCart(driver , "quantity") , "Quantity: \n" + "2");
        verifyEquals(Float.parseFloat(productDetailPage.getTextInMiniCart(driver , "total").replace("$" , "")) , "Sub-Total: +\n" +String.valueOf(Float.parseFloat(price.replace("$" , "")) * 2));

        productDetailPage.clickToButton(driver , "Go to cart");

        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        shoppingCartPage.clickToIconRemoveProduct(driver , "Build your own computer");
        verifyEquals(shoppingCartPage.getMsgNoDataInPage(driver , "shopping-cart").trim() , "Your Shopping Cart is empty!");
        verifyTrue(shoppingCartPage.isNumberWishlistOrCartCorrect(driver , "cart" , "0"));

    }
    @Test
    public void TC_20(){
        shoppingCartPage.clickToMenuHeader(driver , "Computer");
        computerPage = pageGeneratorManager.getComputerPage(driver);
        computerPage.clickToSubMenu(driver , "Desktops");
        desktopPage = pageGeneratorManager.getDesktopPage(driver);
        desktopPage.clickToLinkProduct(driver , "Lenovo IdeaCentre 600 All-in-One PC");
        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);
        price = productDetailPage.getTextInField(driver , "price-value-3");
        productDetailPage.clickToButton(driver , "Add to cart");
        productDetailPage.clickToLink(driver , "shopping cart");

        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        shoppingCartPage.sendKeyToField(driver , "itemquantity11231" , "5");

        shoppingCartPage.clickToButton(driver , "Update shopping cart");

        verifyEquals(shoppingCartPage.getTextInTable(driver , "cart", "Total" , "1").replace("$" , "") , "ToTal:\n" + String.valueOf(Float.parseFloat(price) * 5));

        shoppingCartPage.clickToIconRemoveProduct(driver , "Build your own computer");

        shoppingCartPage.clickToIconRemoveProduct(driver , "Lenovo IdeaCentre 600 All-in-One PC");

        shoppingCartPage.clickToMenuHeader(driver , "Computer");

        computerPage = pageGeneratorManager.getComputerPage(driver);

        computerPage.clickToSubMenu(driver , "Notebooks");

        notebookPage = pageGeneratorManager.getNotebookPage(driver);

        notebookPage.clickToLinkProduct(driver , productName);

        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        price = productDetailPage.getTextInField(driver  ,"price-value-4");
        SKU = productDetailPage.getTextInField(driver , "sku-4");
        quantity = productDetailPage.getTextInField(driver , "product_enteredQuantity_4");
    }

    @Test
    public void TC_21(){
        productDetailPage.checkToRadioBox(driver , "I agree with the terms of service and I adhere to them unconditionally");

        productDetailPage.clickToButton(driver , "Checkout");

        checkoutPage = pageGeneratorManager.getCheckoutPage(driver);

        checkoutPage.unCheckCheckbox(driver , "Ship to the same address");

        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FirstName" , billFN);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_LastName" , billLN);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Email" , billMail);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Company" , billCompany);
        checkoutPage.selectValueInDropdownName(driver , "BillingNewAddress.CountryId" , billCountry);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_City" , billCity);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address1" , billAdd1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address2" , billAdd2);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_ZipPostalCode" , billZip);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_PhoneNumber" , billPhone);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FaxNumber" , billFax);

        checkoutPage.clickToButton(driver , "Continue");

        checkoutPage.selectValueInDropdownName(driver , "shipping_address_id" , "New Address");

        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FirstName" , shipFN);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_LastName" , shipLN);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Email" , shipMail);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Company" , shipCompany);
        checkoutPage.selectValueInDropdownName(driver , "ShippingNewAddress.CountryId" , shipCountry);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_City" , shipCity);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address1" , shipAdd1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address2" , shipAdd2);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_ZipPostalCode" , shipZip);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_PhoneNumber" , shipPhone);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FaxNumber" , shipFax);
        checkoutPage.clickToButton(driver , "Continue");
    }

    @Test
    public void TC_22(){
        checkoutPage.clickToButton(driver , "Continue");

        checkoutPage.clickToButton(driver , "Continue");

        checkoutPage.clickToButton(driver , "Continue");

        checkoutPage.clickToButton(driver , "Continue");

        log.info("Verify value in bill address");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver ,"billing-info") , "Billing Address");

        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "name") , billFN + " " + billLN);

        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "email") , "Email: " + billMail);

        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "phone") , "Phone: " + billPhone);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "fax") , "Fax: " + billFax);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "company") , billCompany);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "address1") , billAdd1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "address2") , billAdd2);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "city-state-zip") , billCity + "," + billZip);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"billing-info" ,"info-list", "country") , billCountry);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"payment-method-info" ,"info-list", "payment-method") , "Payment Method:\n" + payMethod);

        log.info("Verify value in shipping address list");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver ,"shipping") , "Shipping Address");
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "name") , shipFN + " " + shipLN);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "email") , "Email: " + shipMail);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "phone") , "Phone: " + shipPhone);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "fax") , "Fax: " + shipFax);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "company") , shipCompany);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "address1") , shipAdd1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "address2") , shipAdd2);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "city-state-zip") , shipCity + "," + shipZip);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-info" ,"info-list", "country") , shipCountry);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver ,"shipping-method-info" ,"info-list", "shipping-method") , "Shipping Method:\n" + shipMethod);

        log.info("Verify info product");
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "SKU" , "1") , "SKU:\n" + SKU);
        verifyTrue(checkoutPage.getValueInTable(driver ,"cart", "Image" , "alt" , "1").contains(srcImage));
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Product(s)" , "1") , productName);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Price" , "1") , "Price:\n" + price);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Qty." , "1") , "Qty.:\n" + quantity);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Total" , "1").replace("$" , "") , "Total:\n" + String.valueOf(Float.parseFloat(price) * Float.parseFloat(quantity)));

        log.info("Check wrapping info");
        verifyEquals(checkoutPage.getTextWrappingInfo(driver) , "Gift wrapping: No");

        log.info("Check info in cart total");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Sub-Total:" , "2") , "$3,600.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Shipping::" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Tax:" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Total:" , "2") , "$3,600.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "You will earn:" , "2") , "360 points");

        checkoutPage.clickToButton(driver , "Confirm");


        log.info("Verify info in page thank you");
        verifyTrue(checkoutPage.isPageTitleCorrect(driver , "Thank you"));
        verifyEquals(checkoutPage.getMsgBodyCheckoutSuccessPage("title") , "Your order has been successfully processed!");
        orderID = checkoutPage.getMsgBodyCheckoutSuccessPage("order-number").split(" ")[2];
        checkoutPage.clickToButton(driver , "Continue");
        homePage = pageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_23() {
        verifyTrue(homePage.isHomePageTitleShow());

        homePage.clickToHeaderLink(driver, "My account");
        customerInfoPage = pageGeneratorManager.getCustomerInfoPage(driver);
        customerInfoPage.clickToMenuSideByName(driver, "Orders");
        orderPage = pageGeneratorManager.getOrderPage(driver);
        verifyTrue(orderPage.isPageTitleCorrect(driver, "My account - Orders"));

        orderPage.clickToButtonDetailOrder(orderID);

        orderDetailPage = pageGeneratorManager.getOrderDetailPage(driver);
        verifyTrue(orderDetailPage.isPageTitleCorrect(driver, "Order information"));

        log.info("Verify value in order overview");
        verifyEquals(orderDetailPage.getOrderNumberInOverview(), "Order #" + orderID);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-date"), "Order Date: " + dateCalendar);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-status"), "Order Status: Pending");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-total"), "Order Total:\n$3,600.00");


        log.info("Verify value in billing address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "billing"), "Billing Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "name"), billFN + " " + billLN);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "email"), "Email: " + billMail);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "phone"), "Phone: " + billPhone);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "fax"), "Fax: " + billFax);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "company"), billCompany);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address1"), billAdd1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address2"), billAdd2);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "city-state-zip"), billCity + "," + billZip);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "country"), billCountry);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method"), "Payment Method:\nCheck / Money Order");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method-status"), "Payment Status:\nPending");

        log.info("Verify value in shipping address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "shipping"), "Shipping Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "name"), shipFN + " " + shipLN);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "email"), "Email: " + shipMail);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "phone"), "Phone: " + shipPhone);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "fax"), "Fax: " + shipFax);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "company"), shipCompany);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address1"), shipAdd1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address2"), shipAdd2);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "city-state-zip"), shipCity + "," + shipZip);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "country"), shipCountry);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-method"), "Shipping Method:\nGround");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-status"), "Shipping Status:\nNot yet shipped");

        log.info("Verify value in table product");
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "SKU", "1"), "SKU:\n" + SKU);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Name", "1"), productName);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Price", "1"), "Price:\n" + price);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Quantity", "1"), "Quantity:\n2");
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Total", "1"), "Total:\n$3,600.00");

        log.info("Verify gift wrapping");
        verifyEquals(orderDetailPage.getTextWrappingInfo(driver), "Gift wrapping: No");

        log.info("Verify info in cart total");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Sub-Total:", "2"), "$3,600.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Shipping:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Tax:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Order-Total:", "2"), "$3,600.00");

    }
    @Test
    public void TC_24(){
        log.info("Check out order with payment pay by card");
        orderDetailPage.clickToMenuHeader(driver , "Computer");
        computerPage = pageGeneratorManager.getComputerPage(driver);
        computerPage.clickToSubMenu(driver , "Notebooks");
        notebookPage = pageGeneratorManager.getNotebookPage(driver);
        notebookPage.clickToLinkProduct(driver , productName1);
        productDetailPage = pageGeneratorManager.getProductDetailPage(driver);

        priceProduct1 = productDetailPage.getTextInField(driver , "price-value-5").trim();
        SKU1 = productDetailPage.getTextInField(driver , "sku-5");
        quantity1 = "1";
        re_quantity = "10";
        total1 = String.valueOf(Float.parseFloat(priceProduct1.replace("$" , "")) * Float.parseFloat(quantity1));
        re_total = String.valueOf(Float.parseFloat(priceProduct1.replace("$" , "")) * Float.parseFloat(re_quantity));

        productDetailPage.clickToButton(driver , "Add to cart");
        productDetailPage.clickToLink(driver , "shopping cart");
        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        shoppingCartPage.checkToRadioBox(driver , "I agree with the terms of service and I adhere to them unconditionally");
        shoppingCartPage.clickToButton(driver , "Checkout");
        checkoutPage = pageGeneratorManager.getCheckoutPage(driver);

        log.info("Input value billing address");
        checkoutPage.unCheckCheckbox(driver , "Ship to the same address");
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FirstName" , billFN);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_LastName" , billLN);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Email" , billMail);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Company" , billCompany);
        checkoutPage.selectValueInDropdownName(driver , "BillingNewAddress.CountryId" , billCountry);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_City" , billCity);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address1" , billAdd1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address2" , billAdd2);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_ZipPostalCode" , billZip);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_PhoneNumber" , billPhone);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FaxNumber" , billFax);

        checkoutPage.clickToButton(driver , "Continue");

        log.info("Input value shipping address");
        checkoutPage.selectValueInDropdownName(driver , "shipping_address_id" , "New Address");
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FirstName" , shipFN);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_LastName" , shipLN);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Email" , shipMail);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Company" , shipCompany);
        checkoutPage.selectValueInDropdownName(driver , "ShippingNewAddress.CountryId" , shipCountry);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_City" , shipCity);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address1" , shipAdd1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address2" , shipAdd2);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_ZipPostalCode" , shipZip);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_PhoneNumber" , shipPhone);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FaxNumber" , shipFax);
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Select shipping method Ground");
        checkoutPage.checkToRadioBox(driver , "Ground ($0.00)");
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Select payment method by Card");
        checkoutPage.checkToRadioBox(driver , "Credit Card");
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Input value in credit card");
        checkoutPage.selectValueInDropdownName(driver , "CreditCardType" , typeCard);
        checkoutPage.selectValueInDropdownName(driver , "ExpireMonth" , expMonth);
        checkoutPage.selectValueInDropdownName(driver , "ExpireYear" , expYear);
        checkoutPage.sendKeyToField(driver , "CardholderName" , cardName);
        checkoutPage.sendKeyToField(driver , "CardNumber" , cardNumber);
        checkoutPage.sendKeyToField(driver , "CardCode" , cardCode);
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Verify value in billing address");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver , "billing") , "Billing Address");
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "name"), billFN + " " + billLN);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "email"), "Email: " + billMail);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "phone"), "Phone: " + billPhone);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "fax"), "Fax: " + billFax);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "company"), billCompany);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address1"), billAdd1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address2"), billAdd2);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "city-state-zip"), billCity + "," + billZip);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "country"), billCountry);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method"), "Payment Method:\nCredit Card");

        log.info("Verify value in shipping address");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver, "shipping"), "Shipping Address");
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "name"), shipFN + " " + shipLN);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "email"), "Email: " + shipMail);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "phone"), "Phone: " + shipPhone);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "fax"), "Fax: " + shipFax);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "company"), shipCompany);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address1"), shipAdd1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address2"), shipAdd2);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "city-state-zip"), shipCity + "," + shipZip);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "country"), shipCountry);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-method"), "Shipping Method:\nGround");

        log.info("Verify info product");
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "SKU" , "1") , "SKU:\n" + SKU);
        verifyTrue(checkoutPage.getValueInTable(driver ,"cart", "Image" , "alt" , "1").contains(srcImage1));
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Product(s)" , "1") , productName1);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Price" , "1") , "Price:\n" + priceProduct1);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Qty." , "1") , "Qty.:\n" + quantity1);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Total" , "1") , total1);

        log.info("Check wrapping info");
        verifyEquals(checkoutPage.getTextWrappingInfo(driver) , "Gift wrapping: No");

        log.info("Check info in cart total");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Sub-Total:" , "2") , "$" + total1);
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Shipping::" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Tax:" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Total:" , "2") , "$" + total1);
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "You will earn:" , "2") , "150 points");

        checkoutPage.clickToButton(driver  ,"Confirm");
        log.info("Verify info in page thank you");
        verifyTrue(checkoutPage.isPageTitleCorrect(driver , "Thank you"));
        verifyEquals(checkoutPage.getMsgBodyCheckoutSuccessPage("title") , "Your order has been successfully processed!");
        orderID1 = checkoutPage.getMsgBodyCheckoutSuccessPage("order-number").split(" ")[2];
        checkoutPage.clickToButton(driver , "Continue");
        homePage = pageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLink(driver , "My account");
        customerInfoPage = pageGeneratorManager.getCustomerInfoPage(driver);
        customerInfoPage.clickToMenuSideByName(driver , "Orders");

        orderPage = pageGeneratorManager.getOrderPage(driver);
        orderPage.clickToButtonDetailOrder(orderID1);

        orderDetailPage = pageGeneratorManager.getOrderDetailPage(driver);
        log.info("Verify value in order overview");
        verifyEquals(orderDetailPage.getOrderNumberInOverview(), "Order #" + orderID1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-date"), "Order Date: " + dateCalendar);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-status"), "Order Status: Pending");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-total"), "Order Total:\n$1,500.00");


        log.info("Verify value in billing address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "billing"), "Billing Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "name"), billFN + " " + billLN);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "email"), "Email: " + billMail);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "phone"), "Phone: " + billPhone);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "fax"), "Fax: " + billFax);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "company"), billCompany);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address1"), billAdd1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address2"), billAdd2);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "city-state-zip"), billCity + "," + billZip);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "country"), billCountry);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method"), "Payment Method:\nCredit Card");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method-status"), "Payment Status:\nPending");

        log.info("Verify value in shipping address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "shipping"), "Shipping Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "name"), shipFN + " " + shipLN);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "email"), "Email: " + shipMail);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "phone"), "Phone: " + shipPhone);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "fax"), "Fax: " + shipFax);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "company"), shipCompany);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address1"), shipAdd1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address2"), shipAdd2);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "city-state-zip"), shipCity + "," + shipZip);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "country"), shipCountry);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-method"), "Shipping Method:\nGround");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-status"), "Shipping Status:\nNot yet shipped");

        log.info("Verify value in table product");
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "SKU", "1"), "SKU:\n" + SKU);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Name", "1"), productName1);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Price", "1"), "Price:\n" + price);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Quantity", "1"), "Quantity:\n1");
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Total", "1"), "Total:\n$1,500.00");

        log.info("Verify gift wrapping");
        verifyEquals(orderDetailPage.getTextWrappingInfo(driver), "Gift wrapping: No");

        log.info("Verify info in cart total");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Sub-Total:", "2"), "$1,500.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Shipping:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Tax:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Order-Total:", "2"), "$1,500.00");

        orderDetailPage.clickToButton(driver , "Re-order");

        log.info("Check re-order");
        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        shoppingCartPage.sendKeyToField(driver , "itemquantity11221" , re_quantity);
        shoppingCartPage.clickToButton(driver , "Update shopping cart");

        log.info("Verify total price and quantity updated in table product");
        verifyEquals(shoppingCartPage.getTextInTable(driver , "cart" , "Total" , "1") , "Total:\n$" + re_total);
        verifyEquals(shoppingCartPage.getValueInTable(driver , "cart" , "Qty" , "value" , "1") , re_quantity);

        log.info("Check info in cart total after updating");
        verifyEquals(shoppingCartPage.getTextInTableByColumn(driver , "cart-total" , "Sub-Total:" , "2") , "$" + re_total);
        verifyEquals(shoppingCartPage.getTextInTableByColumn(driver , "cart-total" , "Shipping::" , "2") , "$0.00");
        verifyEquals(shoppingCartPage.getTextInTableByColumn(driver , "cart-total" , "Tax:" , "2") , "$0.00");
        verifyEquals(shoppingCartPage.getTextInTableByColumn(driver , "cart-total" , "Total:" , "2") , "$" + re_total);
        verifyEquals(shoppingCartPage.getTextInTableByColumn(driver , "cart-total" , "You will earn:" , "2") , "1500 points");


        shoppingCartPage.checkToRadioBox(driver  ,"I agree with the terms of service and I adhere to them unconditionally");
        shoppingCartPage.clickToButton(driver , "Checkout");
        checkoutPage = pageGeneratorManager.getCheckoutPage(driver);

        log.info("Input new address bill address");
        checkoutPage.unCheckCheckbox(driver , "Ship to the same address");
        checkoutPage.selectValueInDropdownName(driver , "billing_address_id" , "New Address");
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FirstName" , billFN1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_LastName" , billLN1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Email" , billMail1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Company" , billCompany1);
        checkoutPage.selectValueInDropdownName(driver , "BillingNewAddress.CountryId" , billCountry1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_City" , billCity1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address1" , billAdd11);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_Address2" , billAdd21);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_ZipPostalCode" , billZip1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_PhoneNumber" , billPhone1);
        checkoutPage.sendKeyToField(driver , "BillingNewAddress_FaxNumber" , billFax1);

        checkoutPage.clickToButton(driver , "Continue");

        log.info("Input new address ship address");
        checkoutPage.selectValueInDropdownName(driver , "shipping_address_id" , "New Address");
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FirstName" , shipFN1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_LastName" , shipLN1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Email" , shipMail1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Company" , shipCompany1);
        checkoutPage.selectValueInDropdownName(driver , "ShippingNewAddress.CountryId" , shipCountry1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_City" , shipCity1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address1" , shipAdd11);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_Address2" , shipAdd21);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_ZipPostalCode" , shipZip1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_PhoneNumber" , shipPhone1);
        checkoutPage.sendKeyToField(driver , "ShippingNewAddress_FaxNumber" , shipFax1);
        checkoutPage.clickToButton(driver , "Continue");
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Select shipping method");
        checkoutPage.checkToRadioBox(driver , "Next Day Air ($0.00)");

        log.info("Select payment method");
        checkoutPage.checkToRadioBox(driver , "Credit Card");
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Input value in credit card");
        checkoutPage.selectValueInDropdownName(driver , "CreditCardType" , typeCard);
        checkoutPage.selectValueInDropdownName(driver , "ExpireMonth" , expMonth);
        checkoutPage.selectValueInDropdownName(driver , "ExpireYear" , expYear);
        checkoutPage.sendKeyToField(driver , "CardholderName" , cardName);
        checkoutPage.sendKeyToField(driver , "CardNumber" , cardNumber);
        checkoutPage.sendKeyToField(driver , "CardCode" , cardCode);
        checkoutPage.clickToButton(driver , "Continue");

        log.info("Verify new bill address in page confirm after re-ordering");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver , "billing") , "Billing Address");
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "name"), billFN1 + " " + billLN1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "email"), "Email: " + billMail1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "phone"), "Phone: " + billPhone1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "fax"), "Fax: " + billFax1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "company"), billCompany1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address1"), billAdd11);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address2"), billAdd21);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "city-state-zip"), billCity1 + "," + billZip1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "country"), billCountry1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method"), "Payment Method:\nCredit Card");

        log.info("Verify new shipping address in page confirm after re-ordering");
        verifyEquals(checkoutPage.getTitleBillOrShipping(driver, "shipping"), "Shipping Address");
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "name"), shipFN1 + " " + shipLN1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "email"), "Email: " + shipMail1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "phone"), "Phone: " + shipPhone1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "fax"), "Fax: " + shipFax1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "company"), shipCompany1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address1"), shipAdd11);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address2"), shipAdd21);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "city-state-zip"), shipCity1 + "," + shipZip1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "country"), shipCountry1);
        verifyEquals(checkoutPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-method"), "Shipping Method:\nNext Day Air");

        log.info("Verify info product");
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "SKU" , "1") , "SKU:\n" + SKU1);
        verifyTrue(checkoutPage.getValueInTable(driver ,"cart", "Image" , "alt" , "1").contains(srcImage1));
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Product(s)" , "1") , productName1);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Price" , "1") , "Price:\n" + priceProduct1);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Qty." , "1") , "Qty.:\n" + re_quantity);
        verifyEquals(checkoutPage.getTextInTable(driver ,"cart", "Total" , "1") , "Total:\n$" + re_total);

        log.info("Check info in cart total in page confirm after re-ordering");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Sub-Total:" , "2") , "$" + re_total);
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Shipping::" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Tax:" , "2") , "$0.00");
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "Total:" , "2") , "$" + re_total);
        verifyEquals(checkoutPage.getTextInTableByColumn(driver , "cart-total" , "You will earn:" , "2") , "1500 points");

        checkoutPage.clickToButton(driver , "Confirm");

        log.info("Verify info in page thank you");
        verifyTrue(checkoutPage.isPageTitleCorrect(driver , "Thank you"));
        verifyEquals(checkoutPage.getMsgBodyCheckoutSuccessPage("title") , "Your order has been successfully processed!");
        orderID1 = checkoutPage.getMsgBodyCheckoutSuccessPage("order-number").split(" ")[2];
        checkoutPage.clickToButton(driver , "Continue");
        homePage = pageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLink(driver , "My Account");
        customerInfoPage = pageGeneratorManager.getCustomerInfoPage(driver);
        customerInfoPage.clickToMenuSideByName(driver , "Orders");
        orderPage = pageGeneratorManager.getOrderPage(driver);

        log.info("CLick button detail of order re-order");
        orderPage.clickToButtonDetailOrder(orderID1);

        orderDetailPage = pageGeneratorManager.getOrderDetailPage(driver);

        log.info("Verify value order overview re-order");
        verifyEquals(orderDetailPage.getOrderNumberInOverview(), "Order #" + orderID1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-date"), "Order Date: " + dateCalendar);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-status"), "Order Status: Pending");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "order-overview", "order-overview-content", "order-total"), "Order Total:\n$" + re_total);


        log.info("Verify value in billing address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "billing"), "Billing Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "name"), billFN1 + " " + billLN1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "email"), "Email: " + billMail1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "phone"), "Phone: " + billPhone1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "fax"), "Fax: " + billFax1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "company"), billCompany1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address1"), billAdd11);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "address2"), billAdd21);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "city-state-zip"), billCity1 + "," + billZip1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "billing-info", "info-list", "country"), billCountry1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method"), "Payment Method:\nNext Day Air");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "payment-method-info", "info-list", "payment-method-status"), "Payment Status:\nPending");

        log.info("Verify value in shipping address");
        verifyEquals(orderDetailPage.getTitleBillOrShipping(driver, "shipping"), "Shipping Address");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "name"), shipFN1 + " " + shipLN1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "email"), "Email: " + shipMail1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "phone"), "Phone: " + shipPhone1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "fax"), "Fax: " + shipFax1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "company"), shipCompany1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address1"), shipAdd11);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "address2"), shipAdd21);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "city-state-zip"), shipCity1 + "," + shipZip1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-info", "info-list", "country"), shipCountry1);
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-method"), "Shipping Method:\nGround");
        verifyEquals(orderDetailPage.getInfoListBillOrShipping(driver, "shipping-method", "info-list", "shipping-status"), "Shipping Status:\nNot yet shipped");

        log.info("Verify value in table product");
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "SKU", "1"), "SKU:\n" + SKU1);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Name", "1"), productName1);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Price", "1"), "Price:\n" + priceProduct1);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Quantity", "1"), "Quantity:\n" + re_quantity);
        verifyEquals(orderDetailPage.getTextInTable(driver, "data-table", "Total", "1"), "Total:\n$" + re_total);

        log.info("Verify gift wrapping");
        verifyEquals(orderDetailPage.getTextWrappingInfo(driver), "Gift wrapping: No");

        log.info("Verify info in cart total after re-ordering");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Sub-Total:", "2"), "$" + re_total);
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Shipping:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Tax:", "2"), "$0.00");
        verifyEquals(orderDetailPage.getTextInTableByColumn(driver, "cart-total", "Order-Total:", "2"), "$" + re_total);

    }


}
