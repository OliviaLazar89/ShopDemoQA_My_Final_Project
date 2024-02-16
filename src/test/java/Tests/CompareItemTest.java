package Tests;

import HelpMethods.ElementMethods;
import Pages.HomePage;
import Pages.SearchPage;
import Pages.ShopSpecificItemPage;
import ShareData.Hooks;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CompareItemTest extends Hooks {
    @Test
    public void testMethod() {

        HomePage homePage = new HomePage(getDriver());
        homePage.searchButton();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.searchItem(searchPage.itemSearchType, Keys.ENTER);

        //Am gasit un bug din automation
        searchPage.compareItem();

        searchPage.validateCompareItems();
    }
}
