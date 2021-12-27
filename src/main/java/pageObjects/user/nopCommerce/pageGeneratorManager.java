package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import java.util.WeakHashMap;

public class pageGeneratorManager {

    private pageGeneratorManager(){

    }

    public static homePO getHomePage(WebDriver driver){
        return new homePO(driver);
    }

    public static registerPO getRegisterPage(WebDriver driver){
        return new registerPO(driver);
    }

    public static loginPO getLoginPage(WebDriver driver){
        return new loginPO(driver);
    }

    public static customerInfoPO getCustomerInfoPage(WebDriver driver){
        return new customerInfoPO(driver);
    }

    public static changePassPO getChangePassPage(WebDriver driver){
        return new changePassPO(driver);
    }

    public static addressPO getAddressPage(WebDriver driver){
        return new addressPO(driver);
    }

    public static productReviewPO getProducReviewPage(WebDriver driver){
        return new productReviewPO(driver);
    }

    public static productDetailPO getProductDetailPage(WebDriver driver){
        return new productDetailPO(driver);
    }

    public static searchPO getSearchPage(WebDriver driver){
        return new searchPO(driver);
    }

    public static reviewPO getReviewPage(WebDriver driver){
        return new reviewPO(driver);
    }

    public static notebookPO getNotebookPage(WebDriver driver){
        return new notebookPO(driver);
    }

    public static computerPO getComputerPage(WebDriver driver){
        return new computerPO(driver);
    }

    public static wishlistPO getWishlistPage(WebDriver driver){
        return new wishlistPO(driver);
    }

    public static shoppingCartPO getShoppingCartPage(WebDriver driver){
        return new shoppingCartPO(driver);
    }

    public static recentlyViewProductPO getRecentlyViewProductPage(WebDriver driver){
        return new recentlyViewProductPO(driver);
    }

    public static compareProductPO getCompareProductPage(WebDriver driver){
        return new compareProductPO(driver);
    }

    public static desktopPO getDesktopPage(WebDriver driver){
        return new desktopPO(driver);
    }

    public static checkoutPO getCheckoutPage(WebDriver driver){
        return new checkoutPO(driver);
    }

    public static orderPO getOrderPage(WebDriver driver){
            return new orderPO(driver);}

    public static orderDetailPO getOrderDetailPage(WebDriver driver){
        return new orderDetailPO(driver);
    }
}
