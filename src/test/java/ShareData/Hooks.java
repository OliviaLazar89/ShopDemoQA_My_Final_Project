package ShareData;

import Logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import PropertyUtility.PropertyUtility;

import java.util.HashMap;

public class Hooks extends ShareData {
    public HashMap<String, String> testData;
    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testData = propertyUtility.getAllData();  //logica care ar trebui sa ne scoata dinamic datele
        LoggerUtility.startTestCase(testName);
        Setup();
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtility.error(result.getThrowable().getMessage());
        } else {
            clear();
            LoggerUtility.endTestCase(testName);

        }
    }
}
