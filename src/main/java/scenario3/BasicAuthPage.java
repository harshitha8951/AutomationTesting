package scenario3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class BasicAuthPage {
    private WebDriver driver;
    Wait<WebDriver> wait;
    
    By findbasicauth = By.linkText("Basic Auth");
    By text = By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']");

	public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/"); //Open the URL
        driver.manage().window().maximize(); //Maximize the browser window
    }
    
    public void setDriver(WebDriver driver){
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
	 }
    
    public void execute() {
        WebElement findBasicAuth = wait.until(ExpectedConditions.visibilityOfElementLocated(findbasicauth));
        findBasicAuth.click(); //Click on the Basic Auth (user and pass: admin) link
        
    	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth"); //Enter valid username and password
    	
    	String actual = driver.findElement(text).getText(); //Store the text 
    	String expected = "Congratulations! You must have the proper credentials.";
    	Assert.assertEquals(actual, expected); //Assert the text 
    	System.out.println(actual);
    }
    
    public void quit() {
        driver.quit(); //Close the browser
    }
}
