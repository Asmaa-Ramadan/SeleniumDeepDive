package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingElementsBY {


	ChromeDriver driver;
	@Test
	public void FindingElementsBy () {
			//Get All links in the page
			List<WebElement> links = driver.findElements(By.tagName("a"));	
			
			//Verify there are 41 links in the page
    	    assertEquals(41, links.size());        

			// Print each link in the page
			for (WebElement link : links) {
				System.out.println(link.getAttribute("href"));

			}
		


	}

	@BeforeTest

	public void OPenURL() {

		String Chromepath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",Chromepath);
		driver = new ChromeDriver() ;
		driver.navigate().to("https://the-internet.herokuapp.com/");

	}

	@AfterTest
	public void CloseDriver() {

		driver.close();
	}


}
