package scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProgressBarPage {
    private WebDriver driver;
    
    By start = By.id("startButton");
    By stop = By.id("stopButton");
    By progressbar = By.id("progressBar");

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://uitestingplayground.com/progressbar"); //Open the URL
        driver.manage().window().maximize(); //Maximize the browser window
    }
    
    public WebElement getStartButton() {
    	WebElement startbutton = driver.findElement(start);
        return startbutton; //Find the start button
    }

    public WebElement getStopButton() {
    	WebElement stopbutton = driver.findElement(stop);
        return stopbutton; //Find the stop button
    }

    public WebElement getProgressBar() {
    	WebElement progressBar = driver.findElement(progressbar);
        return progressBar; //Find the progress bar
    }
    
    public void execute() throws InterruptedException {
    	String progressBarValue;
        getStartButton().click(); //Click the start button to initiate progress

        while (true) {
            progressBarValue = getProgressBar().getAttribute("aria-valuenow");
            if (!progressBarValue.equals("65")) {
                continue; //Continuously check the progress until it reaches 65%
            } else {
                getStopButton().click(); //Click stop button to halt progress
                break; //Break out of the loop once progress reaches 65%
            }
        }
        Assert.assertEquals(progressBarValue, "65"); //Assert the result is as expected
        System.out.println("Progress bar stopped at " + progressBarValue + "%"); //Print the expected result
    }
    
    public void quit() {
        driver.quit(); //Close the browser
    }

}