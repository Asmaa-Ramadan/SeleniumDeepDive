package workingWithElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WorkingWithDropDown {

	ChromeDriver driver;



	@Test
	public void DropDown() throws InterruptedException {
		WebElement OptionList = driver.findElement(By.id("dropdown"));

		Select SelectDropDown = new Select(OptionList);
		Assert.assertFalse(SelectDropDown.isMultiple());
		Assert.assertEquals(3, SelectDropDown.getOptions().size());
		//	SelectDropDown.selectByIndex(0);
		SelectDropDown.selectByVisibleText("Option 2");
		Assert.assertEquals("Option 2",SelectDropDown.getFirstSelectedOption().getText());
		//SelectDropDown.selectByValue(value);

	}



	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", ChromePath);

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

	}

	@AfterTest
	public void CloseDriver() {
		driver.close();

	}
}
