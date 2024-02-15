package ShareData;

import Logger.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {

        return driver;
    }

    public void Setup() {
        driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // asteapta pana se incarca  max 10 secunde
        LoggerUtility.info("The browser was opened with success");

    }


    public void clear() {
        driver.quit();
        LoggerUtility.info("The browser was closed with success");
    }

}
