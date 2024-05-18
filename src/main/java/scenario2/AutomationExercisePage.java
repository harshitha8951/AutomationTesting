package scenario2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class AutomationExercisePage {
			private WebDriver driver;
			Wait<WebDriver> wait;
			
			By frame1 = By.cssSelector("iframe[id='aswift_6']");
			By frame2 = By.cssSelector("iframe[id='ad_iframe']");
			By close = By.xpath("//span[text()='Close']");
			
			By products = By.xpath("//a[normalize-space(text())='Products']");
			By searchproduct = By.id("search_product");
			By submitsearch = By.id("submit_search");
			By assertproduct1 = By.xpath("(//p[text()='Men Tshirt'])[position()=1]");
			By addproduct = By.cssSelector(".btn.btn-default.add-to-cart");
			By clickcontinue = By.cssSelector(".btn.btn-success.close-modal.btn-block");
			By clickcart = By.xpath("//a[text()=' Cart']");
			By tshirtbefore = By.xpath("//a[text()='Men Tshirt']");
			By login = By.xpath("//a[normalize-space(text())='Signup / Login']");
			By enteremail = By.xpath("(//input[@placeholder='Email Address'])[position()=1]");
			By enterpassword = By.xpath("(//input[@placeholder='Password'])[position()=1]");
			By tshirtafter = By.xpath("//a[text()='Men Tshirt']");
			By clicklogin = By.xpath("//button[text()='Login']");
			
		
		    public AutomationExercisePage(WebDriver driver) {
		        this.driver = driver;
		    }
		
			public void open() {
		        driver.get("http://automationexercise.com"); //Open the URL
		        driver.manage().window().maximize(); //Maximize the browser window
		    }
			
			public void setDriver(WebDriver driver){
				this.driver = driver;
				wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
			 }
			
			public void checkAd() {
				try {
			            WebElement iframe = driver.findElement(frame1);
			            driver.switchTo().frame(iframe);
				           
			            WebElement iframe2 = driver.findElement(frame2);
			        	driver.switchTo().frame(iframe2);
			        	
			        	WebElement dismissButton = driver.findElement(close);
			            dismissButton.click();
			     
			        	driver.switchTo().defaultContent();
			        	System.out.println("Advertisement closed successfully.");     
			             
					} catch (NoSuchElementException e) {
			            System.out.println("No advertisement found, continuing...");
					}
			        
			}
			
			public void clickProducts() {
				WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(products));
		        product.click(); //Click on 'Products' button
		        System.out.println("Navigated to ALL PRODUCTS page successfully");
			}
			
			public void searchProduct() {
				WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchproduct));
		        search.click();
		        search.sendKeys("tshirt"); //Enter product name in search input
		        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(submitsearch));
		        submit.click(); // Click on search button
		        System.out.println("All the products related to search are visible");
			}
			
			public void assertProduct() {
				String actualproduct1 = driver.findElement(assertproduct1).getText();
		        String expectedproduct1 = "Men Tshirt";
		        Assert.assertEquals(actualproduct1, expectedproduct1); //Verify the products related to search are visible
		        
		        System.out.println("Searched products are : " +actualproduct1); 
			}
			
			public void addProductToCart() {
				WebElement addProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(addproduct));
		        addProduct.click(); //Add products to cart
			    WebElement clickContinue = wait.until(ExpectedConditions.visibilityOfElementLocated(clickcontinue));
			    clickContinue.click();
			}
			
			String tshirtInCartBeforeLogin;
			public void checkCart() {
				WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(clickcart));
		        cart.click(); //Click 'Cart' button
		        tshirtInCartBeforeLogin = driver.findElement(tshirtbefore).getText(); //verify the products are visible in cart
		        System.out.println("Products in cart before login: " + tshirtInCartBeforeLogin);
			}
			
			public void clickLoginOrSignUp() {
				WebElement loginn = wait.until(ExpectedConditions.visibilityOfElementLocated(login));
		        loginn.click(); //Click 'Sign up / Login' button
			}
			
			public void enterEmail() {
				WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(enteremail));
		        email.click();
		        email.sendKeys("hershies120@gmail.com"); //Enter email
			}
			
			public void enterPassword() {
				WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(enterpassword));
		        password.click();
		        password.sendKeys("Harshitha@1"); //Enter password
			}
			
			public void clickLoginButton() {
				WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(clicklogin));
		        loginButton.click(); //Submit login details
			}
			
			public void clickCartPage() {
				WebElement cartPage = wait.until(ExpectedConditions.visibilityOfElementLocated(clickcart));
		        cartPage.click(); //Again, go to Cart page
			}
			
			public void checkProduct() {
				String tshirtInCartAfterLogin = driver.findElement(tshirtafter).getText();
		        Assert.assertEquals(tshirtInCartBeforeLogin,tshirtInCartAfterLogin); //Verify that those products are visible in cart after login as well
		        System.out.println("Product in cart after login: " + tshirtInCartAfterLogin); 
			}
			
			public void quit() {
			    driver.quit(); //Close the browser
			}
}
