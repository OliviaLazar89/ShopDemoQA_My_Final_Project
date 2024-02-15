package Tests;

import HelpMethods.ElementMethods;
import Pages.HomePage;
import Pages.SearchPage;
import Pages.ShopSpecificItemPage;
import ShareData.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchShopTest extends Hooks {

    @Test
    public void testMethod() {

        HomePage homePage = new HomePage(getDriver());
        homePage.searchButton();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.searchItem(searchPage.itemSearchType, Keys.ENTER);
        searchPage.searchSpecificItem(searchPage.indexItemSearch);

        ShopSpecificItemPage shopSpecificItem = new ShopSpecificItemPage(getDriver());
        ElementMethods elementMethods = new ElementMethods(getDriver());

        elementMethods.waitVisibleElement(shopSpecificItem.chooseSize);
        shopSpecificItem.chooseSizeDropDown(shopSpecificItem.itemSize);

        elementMethods.waitVisibleElement(shopSpecificItem.chooseColor);
        shopSpecificItem.chooseColorDropDown(shopSpecificItem.itemColor);

        shopSpecificItem.chooseQuantity(shopSpecificItem.itemQuantity);

        shopSpecificItem.addItemToCart();

        shopSpecificItem.validateCartNotNull(shopSpecificItem.actualMessage, shopSpecificItem.expectedMessage1);

    }
}
