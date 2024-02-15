package Tests;

import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.ShopSpecificItemPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class CreateAccountInvalidTest extends Hooks {

    @Test
    public void testMethod() {

        HomePage homePage = new HomePage(getDriver());
        homePage.dismissButton();
        homePage.myAccountButton();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.registerForm();
        myAccountPage.validateMethod(myAccountPage.getActualMessage(), myAccountPage.expectedMessage);

    }
}
