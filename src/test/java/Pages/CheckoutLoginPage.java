package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutLoginPage extends BasePage{
    public CheckoutLoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css= "input[id='username']")
    public WebElement existingEmail;

    public void loginExistingUser(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        existingEmail= myAccountPage.getEmailReg();

    }














}


