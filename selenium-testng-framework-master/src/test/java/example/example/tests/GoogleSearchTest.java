package example.example.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.GooglePage;

@Test(testName = "Google search test", description = "Test description")
public class GoogleSearchTest extends BaseTest {

	/**
	 * Google search test.
	 * @throws IOException 
	 */
	@Test
	public void googleSearchTest() throws IOException {
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//div[contains(text(),'I agree')]")).click();
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.searchText("abc");
		Assert.assertTrue(driver.getTitle().contains("abc"), "Title doesn't contain abc : Test Failed");
		   // wait until the google page shows the result
	    WebElement myDynamicElement = (new WebDriverWait(driver, 20))
	              .until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

	    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//a"));

	    // this are all the links you like to visit
	    FileWriter writer = new FileWriter("C:\\Users\\35389\\Downloads\\TestNGTutorial+(1)\\TestNGTutorial\\joy.txt"); 
	    for (WebElement webElement : findElements)
	    {
	        System.out.println(webElement.getAttribute("href"));
	        writer.write(webElement.getAttribute("href") + System.lineSeparator() + System.lineSeparator());
	    }
	    
	 
	 
	    writer.close();
	}
	
}
