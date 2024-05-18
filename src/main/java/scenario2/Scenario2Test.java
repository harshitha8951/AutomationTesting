package scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Scenario2Test{

	private WebDriver driver;
    private AutomationExercisePage automationExercisePage;

    @BeforeMethod
    public void beforeMethod() {
    	driver = new ChromeDriver(); //Initialize ChromeDriver
    	automationExercisePage = new AutomationExercisePage(driver);
    	automationExercisePage.open();
    	automationExercisePage.setDriver(driver);
    }
    
    @Test //Test method to execute the scenario
    public void test() throws InterruptedException {
    	
    	automationExercisePage.checkAd();
    	
    	automationExercisePage.clickProducts(); //Click on 'Products' button
    	
    	automationExercisePage.searchProduct(); //Enter product name in search input and click search button
    	
    	automationExercisePage.assertProduct(); //Verify the products related to search are visible
    	
    	automationExercisePage.addProductToCart(); //Add products to cart
    	
    	automationExercisePage.checkCart(); //Click 'Cart' button and verify the products are visible in cart
    	
    	automationExercisePage.clickLoginOrSignUp(); //Click 'Sign up / Login' button
    	
    	automationExercisePage.enterEmail(); //Enter Email
    	
    	automationExercisePage.enterPassword(); //Enter Password
    	
    	automationExercisePage.clickLoginButton(); //Submit login details
    	
    	automationExercisePage.clickCartPage(); //Again, go to Cart page
    	
    	automationExercisePage.checkProduct(); //Verify that those products are visible in cart after login as well
    
    }
    
    @AfterClass
    public void afterClass() {
    	automationExercisePage.quit();
    }
}
