package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String itemSearchType = "dress";
    public Integer indexItemSearch = 8;

    @FindBy(xpath = "//div[@class='products noo-row']/div[contains(@class,'noo-product-item one noo-product')]")
    private List<WebElement> shopItems;

    @FindBy(css = ".form-control")
    private WebElement enterSearchWord;

    @FindBy(xpath = "//div[@class='noo-product-meta']/div/a[@class='compare button']")
    public List<WebElement> compareItem;

    @FindBy(xpath = "//button [@id='cboxClose']")
    public WebElement closeCompareBox;

    @FindBy(xpath = "//div[@class='product-essential__specification']")
    public List<WebElement> productSpecification;

    @FindBy(xpath = "//iframe[@class='cboxIframe']")
    public WebElement iframe1;


    public void searchItem(String value, Keys keyboardPress) {
        enterSearchWord.sendKeys(value);
        enterSearchWord.sendKeys(keyboardPress);
        LoggerUtility.info("The user searches for specific item");
    }

    public void searchSpecificItem(Integer index) {
        shopItems.get(index).click();
        LoggerUtility.info("The user chooses a specific item from a list returned after a specific search");

    }

    public void compareItem() {
        compareItem.get(2).click();
        LoggerUtility.info("The user adds the first item to be compared");

        elementMethods.moveToElement(closeCompareBox);
        closeCompareBox.sendKeys(Keys.ENTER);
        LoggerUtility.info("The user closes first window in compare table");

        elementMethods.waitVisibleElement(compareItem.get(3));
        elementMethods.moveToElement(compareItem.get(3));
        compareItem.get(3).click();
        LoggerUtility.info("The user adds the second item to be compared");
    }

    public void validateCompareItems() {
        driver.switchTo().frame(iframe1);
        System.out.println("First item to be compared is : " + productSpecification.get(0).getText());
        LoggerUtility.info("The user visualizes info about first item");
        System.out.println("Second item to be compared is : " + productSpecification.get(1).getText());
        LoggerUtility.info("The user visualizes info about second item");

        Assert.assertNotNull(productSpecification.get(0).getText());
        Assert.assertNotNull(productSpecification.get(1).getText());

    }
}
