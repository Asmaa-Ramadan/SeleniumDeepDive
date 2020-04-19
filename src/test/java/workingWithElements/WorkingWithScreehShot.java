package workingWithElements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithScreehShot {

	ChromeDriver driver;

	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");

	}
	@Test
	public void TestTakeScreenShot() {
		// The Id of the element is wrong so that we can make the test failed and take a screenshot
		WebElement Searchtxt = driver.findElement(By.id("twotabsearchtextboxxx"));
		Searchtxt.sendKeys("selenium webdriver");
		Searchtxt.submit();

	}
	/* This Method only works when the Test Method is failing, In order to execute it, 
	You Must fail the test method */
	@AfterMethod
	public void TakeScreenShotWhenfailed (ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			//Take the screenshot

			TakesScreenshot ts = (TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File("./ScreenShots/"+result.getName()+".png"));
		}


	}

	@AfterTest
	public void CloseDriver()
	{
		driver.close();
	}

}
