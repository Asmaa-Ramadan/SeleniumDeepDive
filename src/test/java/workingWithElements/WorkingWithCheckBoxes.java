package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes {
	ChromeDriver driver;
/*
	@Test(enabled = false)
	public void WorkingWithCheckBox(){

		WebElement Check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		Check1.click();
		WebElement Check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (Check2.isSelected()) {
			Check2.click();
		}
	}
*/

	@Test
	public void ElementIsPresent() {

		if (IsElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {

			WebElement Check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if (!Check1.isSelected()) {

				Check1.click();
			}
		} 
		else {

			Assert.fail("Check Box one is not present");
		}

	}


	private boolean IsElementPresent (By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}


	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

	}


	@AfterTest
	public void CloseDriver()
	{
		driver.close();

	}


}


