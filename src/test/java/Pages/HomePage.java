package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='My Wishlist']")
    private WebElement myWishlist;

    @FindBy(xpath = "//a[text()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkout;

    @FindBy(css = ".icon_bag_alt")
    private WebElement cart;

    @FindBy(xpath = "//a[@class='noo-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='Dismiss']")
    private WebElement dismissButton;

    public void searchButton(){
        searchButton.click();
        LoggerUtility.info("The user clicks on search button");
    }

    public void dismissButton(){
        dismissButton.click();
        LoggerUtility.info("The user clicks on dismiss button");
    }

    public void myAccountButton(){
        myAccount.click();
        LoggerUtility.info("The user clicks on myAccount button");
    }


}
