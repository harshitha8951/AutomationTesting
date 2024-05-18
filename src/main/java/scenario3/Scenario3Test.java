package scenario3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario3Test {

	private WebDriver driver;
    private BasicAuthPage basicauthpage;

    @BeforeMethod
    public void beforeMethod() {
    	driver = new ChromeDriver(); //Initialize ChromeDriver
        basicauthpage = new BasicAuthPage(driver);
        basicauthpage.open();
        basicauthpage.setDriver(driver);
    }
    
    @Test //Test method to execute the scenario
    public void test() {
    	basicauthpage.execute();
    }
    
    @AfterClass
    public void afterClass() {
    	basicauthpage.quit();
    }
}
