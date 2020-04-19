package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID {

	ChromeDriver driver;	

	@BeforeTest
	public void OPenURL()
	{

		String ChromePath =System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");


	}

	@Test
	public void FindElementByIDMethod()
	
	{
		try {

			WebElement UserNameElement = driver.findElement(By.id("username"));
			WebElement PasswordElement = driver.findElement(By.id("password"));
			System.out.println(UserNameElement.getTagName());
			System.out.println(PasswordElement.getTagName());
			
		} catch (NoSuchElementException e) {
			System.out.println("No found, Please try another identifier");
			
		}
	}
	

	@AfterTest

	public void CloseDriver() 
	{
		driver.close();
	}

}
