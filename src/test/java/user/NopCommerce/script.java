package user.NopCommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

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

    String firstName , lastName , email , password , newPass , product;
    String addFN , addLN , addEmail , addCompany , addCountry , addState , city , add1 , add2 , zip , phone , fax;
    String SKU , quantity , price , totalAmount , productName , srcImage , productName1;
    String CPU , screen , memory, price1 , CPU1 , screen1 , memory1 , hardDrive;

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
        productName1 = "Asus N551JK-XO076H Laptop";

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

        verifyEquals(wishlistPage.getTextInTable(driver , "SKU" , "1") , SKU);

        verifyEquals(wishlistPage.getTextInTable(driver , "Product(s)" , "1") , productName);

        verifyTrue(wishlistPage.getValueInTable(driver , "Image" , "src" ,"1").contains(srcImage));

        verifyEquals(wishlistPage.getTextInTable(driver  ,"Price" , "1") , "Price:\n" + price);

        verifyEquals(wishlistPage.getValueInTable(driver , "Qty." , "value" , "1") , "Qty.:\n" + quantity);

        verifyEquals(wishlistPage.getValueInTable(driver , "Total" , "value" , "1") , "Total:\n" + totalAmount);

    }

    @Test
    public void TC_15(){
        wishlistPage.checkToCheckBoxProductName(driver , productName);

        wishlistPage.clickToButton(driver , "Add to cart");

        shoppingCartPage = pageGeneratorManager.getShoppingCartPage(driver);

        verifyTrue(shoppingCartPage.isNumberWishlistOrCartCorrect(driver , "wishlist" , "0"));

        verifyTrue(shoppingCartPage.isNumberWishlistOrCartCorrect(driver , "cart" , "2"));

        verifyTrue(shoppingCartPage.isPageTitleCorrect(driver , "Shopping cart"));

        verifyEquals(shoppingCartPage.getTextInTable(driver , "SKU" , "1") , SKU);

        verifyEquals(shoppingCartPage.getTextInTable(driver , "Product(s)" , "1") , productName);

        verifyTrue(shoppingCartPage.getValueInTable(driver , "Image" , "src" ,"1").contains(srcImage));

        verifyEquals(shoppingCartPage.getTextInTable(driver  ,"Price" , "1") , "Price:\n" + price);

        verifyEquals(shoppingCartPage.getValueInTable(driver , "Qty." , "value" , "1") , "Qty.:\n" + quantity);

        verifyEquals(shoppingCartPage.getValueInTable(driver , "Total" , "value" , "1") , "Total:\n" + totalAmount);

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

        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Name" , "2") , productName1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Price" , "2") , price1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Screensize" , "2") , screen1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "CPU Type" , "2") , CPU1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Memory" , "2") , memory1);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Hard drive" , "2") , hardDrive);

        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Name" , "3") , productName);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Price" , "3") , price);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Screensize" , "3") , screen);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "CPU Type" , "3") , CPU);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Memory" , "3") , memory);
        verifyEquals(compareProductPage.getTextInTableByColumn(driver , "Hard drive" , "3") , "");

        compareProductPage.clickToLink(driver , "Clear list");

        verifyEquals(compareProductPage.getMsgNoDataInPage(driver , "compare-products").trim() , "You have no items to compare.");
    }

    @Test
    public void TC_17(){

    }

}
