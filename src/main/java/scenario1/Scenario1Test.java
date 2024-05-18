package scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario1Test {

	private WebDriver driver;
    private ProgressBarPage progressBarPage;

    @BeforeMethod
    public void beforeMethod() {
    	driver = new ChromeDriver(); //Initialize ChromeDriver
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.open();
    }

    @Test //Test method to execute the scenario
    public void test() throws InterruptedException {
    	progressBarPage.execute();
    }

    @AfterClass
    public void afterClass() {
    	progressBarPage.quit();
    }
}