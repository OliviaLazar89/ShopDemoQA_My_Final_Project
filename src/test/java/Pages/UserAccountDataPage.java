package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountDataPage extends BasePage{
    public UserAccountDataPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="input[id='billing_first_name']")
    public WebElement firstName;

    @FindBy(css="input[id='billing_last_name']")
    public WebElement lastName;

    @FindBy(css="span[id='select2-billing_country-container']")
    public WebElement country;

    @FindBy(css="input[class='select2-search__field']")
    public WebElement countrySelection;

    @FindBy(css="input[id='billing_address_1']")
    public WebElement address;

    @FindBy(css="input[id='billing_city']")
    public WebElement city;

    @FindBy(xpath = "//span[text()='Select an option…']")
    public WebElement county;

    @FindBy(css = "input[class='select2-search__field']")
    public WebElement countySelection;

    @FindBy(css = "input[id='billing_postcode']")
    public WebElement postCode;

    @FindBy(css = "input[id='billing_phone']")
    public WebElement phone;
    @FindBy(css = "input[id='billing_email']")
    public WebElement email;

    public void fillUserInfo(){
        firstName.sendKeys("Olivia");
        lastName.sendKeys("Lazar");
        country.click();
        countrySelection.clear();
        countrySelection.sendKeys("Romania");
        countrySelection.sendKeys(Keys.ENTER);
        address.sendKeys("x str,nr.5");
        city.sendKeys("Timisoara");
        county.click();
        countySelection.clear();
        countySelection.sendKeys("Timis");
        countySelection.sendKeys(Keys.ENTER);
        postCode.sendKeys("300782");
        phone.sendKeys("0721000000");
        email.sendKeys("olaz@gmail.com");

    }
}


