package findingElements;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXpath {

	ChromeDriver driver;


	@Test

	public void FindingElementByXpath () {
		
		try {
			
			WebElement username = driver.findElementByXPath("//*[@id=\"username\"]");
			System.out.println(username.getTagName());
			
		} 
		catch (NoSuchElementException e) {
			System.out.println("No Such Element");
			
		}
		

	}

	@BeforeTest
	public void OpenURl()
	{

		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}


	@AfterTest
	public void CloseDriver()
	{
		driver.close();
	}

}

