package commons;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jsoup.Connection;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.user.nopCommerce.BaseUserUI;
import pageUIs.user.nopCommerce.checkoutPageUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    private Alert alert;
    private WebDriverWait explicitWait;
    private long timeout = 15;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private Actions action;

    public static CommonFunctions getCommonFunctionsPage(){
        return new CommonFunctions();
    }

    public void openPageURL(WebDriver driver, String pageURL) {
        driver.get(pageURL);
    }


    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();

    }

    public String getPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
        for (Cookie cookie : allCookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public Alert waitAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, timeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        alert = waitAlertPresence(driver);
        alert.accept();
    }

    public void cancelAlert(WebDriver driver) {
        alert = waitAlertPresence(driver);
        alert.dismiss();
    }

    public void sendKeyToAlert(WebDriver driver, String value) {
        alert = waitAlertPresence(driver);
        alert.sendKeys(value);

    }

    public String getAlertText(WebDriver driver) {
        alert = driver.switchTo().alert();
        return alert.getText();

    }

    public void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindowsID = driver.getWindowHandles();

        for (String id : allWindowsID) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String tabtitle) {
        Set<String> AllWindowID = driver.getWindowHandles();

        for (String id : AllWindowID) {
            driver.switchTo().window(id);
            String ActualTitle = driver.getTitle();
            if (ActualTitle.equals(tabtitle)) {
                break;
            }
        }
    }

    public void CloseAllWindowExceptParent(WebDriver driver, String parentID) {
        Set<String> AllWindowID = driver.getWindowHandles();

        for (String id : AllWindowID) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    public void sleepInSecond(long timeoutInSecond) {
        try {
            Thread.sleep(timeoutInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... params) {
        return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
    }


    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).click();

    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
        ;
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).clear();
        getElement(driver, getDynamicLocator(locator, params)).sendKeys(value);
        ;
    }

    public int getElementsize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    public int getElementsize(WebDriver driver, String locator, String... params) {
        return getElements(driver, getDynamicLocator(locator, params)).size();
    }

    public void selectDropDownByText(WebDriver driver, String locator, String Text) {
        select = new Select(getElement(driver, locator));
        select.selectByVisibleText(Text);
    }

    public void selectDropDownByText(WebDriver driver, String locator, String Text, String... params) {
        select = new Select(getElement(driver, getDynamicLocator(locator, params)));
        select.selectByVisibleText(Text);
    }

    public String getSelectedItemFromDropDown(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.getFirstSelectedOption().getText();

    }

    public String getSelectedItemFromDropDown(WebDriver driver, String locator, String... params) {
        select = new Select(getElement(driver, getDynamicLocator(locator, params)));
        return select.getFirstSelectedOption().getText();

    }

    public boolean isDropDownMultiPle(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        explicitWait = new WebDriverWait(driver, timeout);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childLocator);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
            }
        }
    }

    public void selectMultiItemInDropdown(WebDriver driver, String parentLocator, String childLocator, String[] expectedValueItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, timeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

        for (WebElement childElement : allItems) {
            for (String item : expectedValueItem) {
                if (childElement.getText().trim().equals(item)) {
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    sleepInSecond(1);

                    childElement.click();
                    sleepInSecond(1);
                }
            }
        }
    }


    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {

        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... params) {

        return getElement(driver, locator).getText();
    }

    public void checktoCheckBoxOrRadio(WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void checktoCheckBoxOrRadio(WebDriver driver, String locator, String... params) {
        if (!isElementSelected(driver, getDynamicLocator(locator, params))) {
            getElement(driver, getDynamicLocator(locator, params)).click();
        }
    }

    public void unCheckCheckBox(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void unCheckCheckBox(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        if (isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> elements = getElements(driver, locator);
        overrideGlobalTimeout(driver, longTimeout);

        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM But not displayed");
            return true;

        } else {
            return false;
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public boolean isElementEnable(WebDriver driver, String locator) {

        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementEnable(WebDriver driver, String locator, String... params) {

        return getElement(driver, getDynamicLocator(locator, params)).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).isSelected();
    }

    public boolean isResultContainKeyword(WebDriver driver, String locator, String keyword) {
        boolean status;
        if (!getElementText(driver, locator).contains(keyword)) {
            status = false;
            return status;
        } else {
            status = true;
        }
        return status;
    }


    public WebDriver switchToFrameByElement(WebDriver driver, String locator) {
        return driver.switchTo().frame(getElement(driver, locator));
    }

    public WebDriver switchToDefaultContent(WebDriver driver) {

        return driver.switchTo().defaultContent();
    }

    public void hoverElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    public void hoverElement(WebDriver driver, String locator, String... params) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
    }


    public void doubleClick(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    public void DragAndDrop(WebDriver driver, String sourcelocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, sourcelocator), getElement(driver, targetLocator)).perform();

    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
        action = new Actions(driver);
        action.sendKeys(getElement(driver, getDynamicLocator(locator, params)), key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJqueryandJSLoadSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, timeout);
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryload = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> JSLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryload) && explicitWait.until(JSLoad);

    }

    public boolean isJQueryLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
        return explicitWait.until(jQueryLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));

    }

    public void waitElementVisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));

    }

    public void waitAllElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));

    }

    public void waitElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitElementClickable(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));

    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return day + "";
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return month + "";
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        return now.getYear() + "";
    }

    public String getDateCalendarWithNoTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before Formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;

    }

    protected String getToday() {
        return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
    }

    public String getCurrentDate(WebDriver driver){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // User NopCommerce
    public void sendKeyToField(WebDriver driver , String fieldID , String value ){
        waitElementVisible(driver , BaseUserUI.INPUT_FIELD_ID , fieldID);
        sendKeyToElement(driver, BaseUserUI.INPUT_FIELD_ID , fieldID , value);
        pressKeyToElement(driver , BaseUserUI.INPUT_FIELD_ID ,Keys.TAB, fieldID);
    }

    public void clickToButton(WebDriver driver, String buttonName){
        waitElementClickable(driver , BaseUserUI.BUTTON_NAME , buttonName);
        clickToElement(driver , BaseUserUI.BUTTON_NAME , buttonName);
    }

    public String getErrorMessageInField(WebDriver driver , String fieldID){
        waitElementVisible(driver , BaseUserUI.ERROR_MSG_FIELD , fieldID);
        return getElementText(driver , BaseUserUI.ERROR_MSG_FIELD, fieldID);
    }

    public String getErrorMsgSummary(WebDriver driver){
        waitElementVisible(driver , BaseUserUI.ERROR_MSG_SUMMARY);
        return getElementText(driver ,  BaseUserUI.ERROR_MSG_SUMMARY);
    }

    public void checkToRadioBox(WebDriver driver , String label){
        waitElementClickable(driver , BaseUserUI.RADIO_BOX_LABEL , label);
        checktoCheckBoxOrRadio(driver , BaseUserUI.RADIO_BOX_LABEL , label);
    }

    public void checkToCheckbox(WebDriver driver , String label){
        waitElementClickable(driver , BaseUserUI.CHECK_BOX_LABEL , label);
        checktoCheckBoxOrRadio(driver , BaseUserUI.CHECK_BOX_LABEL , label);
    }

    public void clickToHeaderLink(WebDriver driver , String linkName){
        waitElementClickable(driver , BaseUserUI.HEADER_LINK , linkName);
        clickToElement(driver , BaseUserUI.HEADER_LINK, linkName);
    }

    public boolean isPageTitleCorrect(WebDriver driver , String title){
        waitElementVisible(driver , BaseUserUI.PAGE_TITLE, title);
        return isElementDisplayed(driver , BaseUserUI.PAGE_TITLE, title);
    }

    public void clickToLink(WebDriver driver , String linkText){
        waitElementClickable(driver , BaseUserUI.LINK_TEXT , linkText);
        clickToElement(driver , BaseUserUI.LINK_TEXT , linkText);
    }

    public void selectValueInDropdownName(WebDriver driver , String dropdownName , String value){
        waitElementClickable(driver , BaseUserUI.DROP_DOWN_NAME , dropdownName);
        selectDropDownByText(driver , BaseUserUI.DROP_DOWN_NAME , dropdownName , value);
    }

    public String getSelectedInDropdown(WebDriver driver , String dropdownName){
        waitElementVisible(driver , BaseUserUI.DROP_DOWN_NAME , dropdownName);
        return getSelectedItemFromDropDown(driver , BaseUserUI.DROP_DOWN_NAME , dropdownName);
    }

    public String getValueInField(WebDriver driver , String fieldID){
        waitElementVisible(driver , BaseUserUI.INPUT_FIELD_ID , fieldID);
        return getAttributeValue(driver , BaseUserUI.INPUT_FIELD_ID , "value" , fieldID);
    }

    public String getTextInField(WebDriver driver , String fieldID){
        waitElementVisible(driver , BaseUserUI.INPUT_FIELD_ID , fieldID);
        return getElementText(driver , BaseUserUI.INPUT_FIELD_ID , fieldID);
    }

    public boolean isRadioBoxSelected(WebDriver driver , String label){
        waitElementVisible(driver , BaseUserUI.RADIO_BOX_LABEL , label);
        return isElementSelected(driver , BaseUserUI.RADIO_BOX_LABEL , label);
    }

    public boolean isCheckBoxSelected(WebDriver driver , String label){
        waitElementVisible(driver , BaseUserUI.CHECK_BOX_LABEL , label);
        return isElementSelected(driver , BaseUserUI.CHECK_BOX_LABEL , label);
    }

    public void clickToMenuSideByName(WebDriver driver , String menuName){
        waitElementClickable(driver , BaseUserUI.MENU_SIDE , menuName);
        clickToElement(driver , BaseUserUI.MENU_SIDE , menuName);
    }

    public boolean isMsgNoDataDisplayed(WebDriver driver , String message){
        waitElementVisible(driver , BaseUserUI.MSG_NO_DATA , message);
        return isElementDisplayed(driver , BaseUserUI.MSG_NO_DATA , message);
    }

    public String getSuccessMsgInBar(WebDriver driver ){
        waitElementVisible(driver , BaseUserUI.BAR_SUCCESS_MSG);
        return getElementText(driver , BaseUserUI.BAR_SUCCESS_MSG);
    }

    public void clickToCloseMsgBar(WebDriver driver){
        waitElementClickable(driver , BaseUserUI.ICON_CLOSE_IN_BAR);
        clickToElement(driver , BaseUserUI.ICON_CLOSE_IN_BAR);
    }

    public int getNumberProduct(WebDriver driver){
        waitElementVisible(driver , BaseUserUI.PRODUCT_NAME);
        return getElementsize(driver , BaseUserUI.PRODUCT_NAME);
    }

    public void clickToLinkProduct(WebDriver driver , String productName){
        waitElementVisible(driver , BaseUserUI.LINK_PRODUCT);
        clickToElement(driver , BaseUserUI.LINK_PRODUCT);
    }

    public void clickToLinkFooter(WebDriver driver , String linkName){
        waitElementClickable(driver , BaseUserUI.FOOTER_LINK , linkName);
        clickToElement(driver , BaseUserUI.FOOTER_LINK , linkName);
    }

    public String getProductName(WebDriver driver){
        waitElementVisible(driver , BaseUserUI.PRODUCT_NAME);
        return getElementText(driver , BaseUserUI.PRODUCT_NAME);
    }

    public boolean isSearchProductCorrect(WebDriver driver , String keyWord){
        List<WebElement> listProduct =  getElements(driver , BaseUserUI.PRODUCT_NAME);
        boolean status = false;
        for (WebElement product : listProduct){
            if (!product.getText().contains(keyWord)){
                status = false;
                return status;
            }else {
                status = true;
                break;
            }
        }
        return status;
    }

    public void clickToMenuHeader(WebDriver driver , String menuName){
        waitElementClickable(driver , BaseUserUI.MENU_HEADER , menuName);
        clickToElement(driver , BaseUserUI.MENU_HEADER , menuName);
    }

    public void clickToSubMenu(WebDriver driver , String subMenu){
        waitElementClickable(driver , BaseUserUI.SUB_LIST , subMenu);
        clickToElement(driver , BaseUserUI.SUB_LIST , subMenu);
    }

    public boolean isProductSortAscending(WebDriver driver){
        List<WebElement> productNameElement = getElements(driver , BaseUserUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName : productNameElement){
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<String>(productNameText);
        Collections.sort(productNameTextClone);

        return productNameText.equals(productNameTextClone);
    }

    public boolean isProductSortDescending(WebDriver driver){
        List<WebElement> productNameElement = getElements(driver , BaseUserUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName : productNameElement){
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<String>(productNameText);
        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);

        return productNameText.equals(productNameTextClone);
    }

    public boolean isProductPriceSortAscending(WebDriver driver){
        List<WebElement> productPriceElement = getElements(driver , BaseUserUI.PRODUCT_PRICE);

        List<Float> productPriceList = new ArrayList<Float>();

        for (WebElement productPrice : productPriceElement){
            productPriceList.add(Float.parseFloat(productPrice.getText().replace("$" , "")));
        }

        List<Float> productPriceListClone = new ArrayList<Float>(productPriceList);
        Collections.sort(productPriceListClone);

        return productPriceList.equals(productPriceListClone);
    }

    public boolean isProductPriceSortDescending(WebDriver driver){
        List<WebElement> productPriceElement = getElements(driver , BaseUserUI.PRODUCT_PRICE);

        List<Float> productPriceList = new ArrayList<Float>();

        for (WebElement productPrice : productPriceElement){
            productPriceList.add(Float.parseFloat(productPrice.getText().replace("$" , "")));
        }

        List<Float> productPriceListClone = new ArrayList<Float>(productPriceList);
        Collections.sort(productPriceListClone);
        Collections.reverse(productPriceListClone);

        return productPriceList.equals(productPriceListClone);
    }

    public boolean isNumberProductDisplayedCorrect(WebDriver driver , int expectedNumber){
        boolean status = false;
        if (getNumberProduct(driver) > expectedNumber){
            status = false;
            return status;
        }else {
            status = true;
        }
        return status;
    }

    public boolean isIconPreviousOrNextDisplayed(WebDriver driver , String type){
        waitElementVisible(driver , BaseUserUI.ICON_NEXT_PREVIOUS , type);
        return isElementDisplayed(driver , BaseUserUI.ICON_NEXT_PREVIOUS , type);
    }

    public void clickToDifferentPage(WebDriver driver , String numberPage){
        waitElementClickable(driver , BaseUserUI.NUMBER_PAGE , numberPage);
        clickToElement(driver , BaseUserUI.NUMBER_PAGE , numberPage);
    }

    public boolean isNumberWishlistOrCartCorrect(WebDriver driver , String type , String number){
        waitElementVisible(driver , BaseUserUI.NUMBER_WISHLIST_CART_HEADER , type , number);
        return isElementDisplayed(driver , BaseUserUI.NUMBER_WISHLIST_CART_HEADER , type , number);
    }

    public String getTextInTable(WebDriver driver , String className , String headerName , String rowIndex){
        int columnIndex = getElementsize(driver , BaseUserUI.TABLE_COLUMN , className , headerName) + 1;
        waitElementVisible(driver , BaseUserUI.TABLE_ROW , className , rowIndex , String.valueOf(columnIndex));
        return getElementText(driver , BaseUserUI.TABLE_ROW , className ,  rowIndex , String.valueOf(columnIndex));
    }

    public String getValueInTable(WebDriver driver ,String className , String headerName , String typeValue , String rowIndex){
        int columnIndex = getElementsize(driver , BaseUserUI.TABLE_COLUMN ,className , headerName) + 1;
        waitElementVisible(driver , BaseUserUI.TABLE_ROW , className , rowIndex , String.valueOf(columnIndex));
        return getAttributeValue(driver , BaseUserUI.TABLE_ROW , typeValue, className , rowIndex , String.valueOf(columnIndex));
    }

    public void checkToCheckBoxProductName(WebDriver driver , String productName){
        waitElementClickable(driver , BaseUserUI.CHECKBOX_BY_PRODUCT_NAME , productName);
        checktoCheckBoxOrRadio(driver , BaseUserUI.CHECKBOX_BY_PRODUCT_NAME , productName);
    }

    public void clickToIconRemoveProduct(WebDriver driver , String producName){
        waitElementClickable(driver , BaseUserUI.ICON_REMOVE_BY_PRODUCT_NAME , producName);
        clickToElement(driver , BaseUserUI.ICON_REMOVE_BY_PRODUCT_NAME , producName);
    }

    public String getMsgNoDataInPage(WebDriver driver , String typePage){
        waitElementVisible(driver , BaseUserUI.MSG_NO_DATA_WISHLIST_CART , typePage);
        return getElementText(driver , BaseUserUI.MSG_NO_DATA_WISHLIST_CART , typePage);
    }

    public void clickToButtonProduct(WebDriver driver , String productName , String buttonName){
        waitElementClickable(driver , BaseUserUI.BUTTON_PRODUCT , productName , buttonName);
        clickToElement(driver , BaseUserUI.BUTTON_PRODUCT , productName , buttonName);
    }

    public String getTextInTableByColumn(WebDriver driver , String className , String name , String columnIndex){
        int rowIndex = getElementsize(driver , BaseUserUI.TABLE_BY_ROW , className , name) + 1;
        waitElementVisible(driver , BaseUserUI.TABLE_BY_COLUMN , className , String.valueOf(rowIndex) , columnIndex);
        return getElementText(driver , BaseUserUI.TABLE_BY_COLUMN , className , String.valueOf(rowIndex) , columnIndex);
    }

    public void hoverShoppingCartHeader(WebDriver driver){
        waitElementVisible(driver , BaseUserUI.SHOPPING_CART_HEADER);
        hoverElement(driver , BaseUserUI.SHOPPING_CART_HEADER);
    }

    public String getTextInMiniCart(WebDriver driver , String className){
        waitElementVisible(driver , BaseUserUI.VALUE_IN_CART , className);
        return getElementText(driver , BaseUserUI.VALUE_IN_CART , className);
    }

    public void unCheckCheckbox(WebDriver driver , String label){
        waitElementClickable(driver , BaseUserUI.RADIO_BOX_LABEL , label);
        unCheckCheckBox(driver , BaseUserUI.RADIO_BOX_LABEL , label);
    }

    public String getTitleBillOrShipping(WebDriver driver , String type){
        waitElementVisible(driver , BaseUserUI.TITLE_BILL_SHIPPING , type);
        return getElementText(driver , BaseUserUI.TITLE_BILL_SHIPPING, type);
    }

    public String getInfoListBillOrShipping(WebDriver driver ,String type , String content , String className){
        waitElementVisible(driver , BaseUserUI.VALUE_BILL_SHIPPING_INFO_lIST , type , content ,className);
        return getElementText(driver , BaseUserUI.VALUE_BILL_SHIPPING_INFO_lIST , type , content , className).trim();
    }

    public String getTextWrappingInfo(WebDriver driver){
        waitElementVisible(driver , BaseUserUI.GIFT_WRAPPING);
        return getElementText(driver , BaseUserUI.GIFT_WRAPPING).trim();
    }


}
