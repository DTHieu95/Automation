package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class pageGenerator {

    private pageGenerator(){

    }

    public static customerSearchPO getCustomerSearchPage(WebDriver driver){
        return new customerSearchPO(driver);
    }

    public static addNewCustomerPO GetAddNewCustomerPage(WebDriver driver){
        return new addNewCustomerPO(driver);
    }

    public static editCustomerPO getEditCustomerPage(WebDriver driver){
        return new editCustomerPO(driver);
    }

    public static loginPO getLoginPage(WebDriver driver){
        return new loginPO(driver);
    }

    public static productSearchPO getProductSearchPage(WebDriver driver){
        return new productSearchPO(driver);
    }

    public static dashboardPO getDashboardPage(WebDriver driver){
        return new dashboardPO(driver);
    }

    public static editProductPO getEditProductPage(WebDriver driver){
        return new editProductPO(driver);
    }

    public static addNewAddressPO getAddNewAddressPage(WebDriver driver){
        return new addNewAddressPO(driver);
    }

    public static editAddressPO getEditAddressPage(WebDriver driver){
        return new editAddressPO(driver);
    }


}
