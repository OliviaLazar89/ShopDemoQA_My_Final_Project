package Pages;

import HelpMethods.ElementMethods;
import Logger.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShopSpecificItemPage extends BasePage {

    public ShopSpecificItemPage(WebDriver driver) {
        super(driver);
    }

    public String itemSize = "Medium";
    public String itemColor = "Black";
    public String itemQuantity = "2";
    public String expectedMessage1 = "View cart\n" +
            "2 × “black satin one shoulder cut out midi dress” have been added to your cart.";
    public String expectedMessage2 = "Returning customer? Click here to login";


    @FindBy(id = "pa_size")
    public WebElement chooseSize;

    @FindBy(id = "pa_color")
    public WebElement chooseColor;

    @FindBy(css = "input[name='quantity']")
    public WebElement quantity;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addCartButton;

    @FindBy(css = ".wc-block-components-notice-banner__content")
    public WebElement actualMessage;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = ".validate-required .checkbox")
    public WebElement agreeTermsButton;
    @FindBy(css = "button[id='place_order']")
    public WebElement placeOrderButton;

    @FindBy(css = "a[class='showlogin']")
    public WebElement goToLogin;



    public void chooseSizeDropDown(String size) {
        chooseSize.sendKeys(Keys.ENTER);
        Select chooseSizeDropDown = new Select(chooseSize);
        chooseSizeDropDown.selectByVisibleText(size);
        LoggerUtility.info("The user chooses a specific size for an item");
    }

    public void chooseColorDropDown(String color) {
        Select chooseColorDropDown = new Select(chooseColor);
        chooseColorDropDown.selectByVisibleText(color);
        LoggerUtility.info("The user chooses a specific color for an item");
    }

    public void chooseQuantity(String number) {
        quantity.clear();
        quantity.sendKeys(number);
        LoggerUtility.info("The user chooses a specific number of items");
    }

    public void addItemToCart() {
        addCartButton.click();
        LoggerUtility.info("The user adds to cart the selected item");
    }

    public void validateCartNotNull(WebElement element, String value) {
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, value);
        LoggerUtility.info("The user receives a message that the cart has successfully been updated with desired items");
    }

}
