package findingElements;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementIntableByTagename {

ChromeDriver driver ;
	
	
	@Test
	
	public  void findeelementbytagename() 
	{
		try {

			WebElement Findingtable = driver.findElement(By.id("table1"));
			java.util.List<WebElement>FindingRow = Findingtable.findElements(By.tagName("tr"));
			System.out.println(FindingRow.size());
			
		} catch (NoSuchElementException e) {
			
			System.out.println("No such element");
		}
		
		
	}
	
	@BeforeTest
	public void OpenURL() {
		
		String ChromePath= System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		
            driver = new ChromeDriver() ;
            driver.navigate().to("https://the-internet.herokuapp.com/tables");
		
	}
	
	
	@AfterTest
	
	public void CloseDriver() {
		
		driver.close();
	}
	

}

