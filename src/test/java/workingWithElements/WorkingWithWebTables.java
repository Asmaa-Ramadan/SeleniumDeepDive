package workingWithElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithWebTables {
	ChromeDriver  driver;

	@Test 

	public void WorkingWithTables() {
		WebElement WebTable = driver.findElement(By.id("table1"));

		// Get all Rows
		List<WebElement> Rows = WebTable.findElements(By.tagName("tr"));
		Assert.assertEquals(5, Rows.size());

		//Get all celss data (cols & rows)
		for (WebElement row : Rows) {

			List<WebElement> Cols = row.findElements(By.tagName("td"));
			//System.out.println(row.getText() + "\t");
			for (WebElement Col : Cols) {
				System.out.println(Col.getText()+ "\t" + "\t");

			}
			System.out.println();
		}

	}


	@BeforeTest
	public void OpenURL() {

		String Chromepath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", Chromepath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");

	}



	@AfterTest
	public void CloseDriver() {

		driver.close();
	}

}