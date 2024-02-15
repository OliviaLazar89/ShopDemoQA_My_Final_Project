package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String expectedMessage = "There has been a critical error on this website.";


    @FindBy(id = "reg_username")
    private WebElement userNameReg;

    @FindBy(xpath = "//div[@class='wp-die-message']")
    private WebElement actualMessage;

    @FindBy(id = "reg_email")
    private WebElement emailReg;

    @FindBy(id = "reg_password")
    private WebElement passwordReg;

    @FindBy(css= "button[name='register']")
    private WebElement registerButton;

    public WebElement getUserNameReg() {
        return userNameReg;
    }

    public WebElement getEmailReg() {
        return emailReg;
    }

    public WebElement getPasswordReg() {
        return passwordReg;
    }

    public WebElement getActualMessage() {
        return actualMessage;
    }

    public void registerForm(){

        userNameReg.sendKeys("Olivia" + System.currentTimeMillis());
        LoggerUtility.info("The user enters a user name");
        emailReg.sendKeys("olivia" +  System.currentTimeMillis() + "@yahoo.com");
        LoggerUtility.info("The user enters a valid e-mail address");
        passwordReg.sendKeys("password1@#$%%^^&");
        LoggerUtility.info("The user enters a password");
        registerButton.click();

    }

    public void validateMethod(WebElement element, String expectedMessage) {
        String actualMessage = element.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        LoggerUtility.info("The user validates the message after creating an account");
    }



}
