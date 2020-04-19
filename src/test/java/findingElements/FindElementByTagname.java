package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTagname {
	ChromeDriver driver ;
	
	
	@Test
	
	public  void findeelementbytagename() 
	{
		try {

			WebElement Tagname = driver.findElement(By.tagName("input"));
			System.out.println(Tagname.getTagName());
			
		} catch (NoSuchElementException e) {
			
			System.out.println("No such element");
		}
		
		
	}
	
	@BeforeTest
	public void OpenURL() {
		
		String ChromePath= System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		
            driver = new ChromeDriver() ;
            driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	
	
	@AfterTest
	
	public void CloseDriver() {
		
		driver.close();
	}
	

}

