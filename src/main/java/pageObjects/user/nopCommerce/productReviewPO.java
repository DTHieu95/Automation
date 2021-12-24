package pageObjects.user.nopCommerce;

import commons.CommonFunctions;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.homePageUI;
import pageUIs.user.nopCommerce.productReviewPageUI;
import pageUIs.user.nopCommerce.reviewPageUI;

public class productReviewPO extends CommonFunctions {
    WebDriver driver;

    public productReviewPO(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomePageTitleShow(){
        waitElementVisible(driver , homePageUI.TITLE_HOME_PAGE);
        return isElementDisplayed(driver , homePageUI.TITLE_HOME_PAGE);
    }

    public String getReviewTitle(){
        waitElementVisible(driver , productReviewPageUI.REVIEW_TITLE);
        return getElementText(driver , productReviewPageUI.REVIEW_TITLE);
    }

    public String getReviewContent(){
        waitElementVisible(driver , productReviewPageUI.REVIEW_CONTENT);
        return getElementText(driver , productReviewPageUI.REVIEW_CONTENT);
    }

    public String getReviewInfo(){
        waitElementVisible(driver , productReviewPageUI.REVIEW_INFO);
        return getElementText(driver , productReviewPageUI.REVIEW_INFO);
    }
}
