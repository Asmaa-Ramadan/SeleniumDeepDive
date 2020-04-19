package workingWithElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBrokenLinks {

	ChromeDriver driver;

	@BeforeClass
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir") +"\\Sources\\chromedriver.exe" ;
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Test
	public void TestBrokenLinks () {

		// To get all the links in the page, put it in a list.
		java.util.List<WebElement> ListLinks = driver.findElements(By.tagName("a")); 

		// Print the Size of the List 
		System.out.println("Total links are" +ListLinks.size());

		// loop and get all the links 
		for (int i = 0; i < ListLinks.size(); i++) {
			WebElement element =  ListLinks.get(i);
			String url = element.getAttribute("href");

			// Get the current url and check the status code 
			VerifyLink(url);
		}
	}


	public static void VerifyLink(String urlLink) 
	{
		try {
			URL link = new URL(urlLink);
			// Create connection using URL object 
			HttpURLConnection HttpConn = (HttpURLConnection) link.openConnection();
			HttpConn.setConnectTimeout(2000);
			HttpConn.connect();

			// Use the get response method to get the status code

			if (HttpConn.getResponseCode() == 200) 
			{
				System.out.println(urlLink + "- "+ HttpConn.getResponseMessage());
			}
			else
			{
				System.out.println(urlLink + "- "+ HttpConn.getResponseMessage());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@AfterClass
	public void CloseDriver() {
		driver.quit();
	}
}
