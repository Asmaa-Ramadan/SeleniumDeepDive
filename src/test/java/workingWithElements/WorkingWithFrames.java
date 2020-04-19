package workingWithElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithFrames {

	ChromeDriver driver;

	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir") +"\\Sources\\chromedriver.exe" ;
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void TestFrames () {
		// You need to Say switch to the desired frame so that you can access it's elements.
		driver.switchTo().frame("left");
		WebElement Message = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Left Frame", Message.getText());
		System.out.println(Message.getText());

		/* We need to add this step, to make sure the driver go back to the default
		content and existing from the selected frame  */
		driver.switchTo().defaultContent();

		//Switching to a second frame
		driver.switchTo().frame("right");
		WebElement Message2 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Right Frame", Message2.getText());
		System.out.println(Message2.getText());
		driver.switchTo().defaultContent();

		// To switch to another frame

		driver.switchTo().frame(1);
		WebElement Message3 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This Frame doesn't have id or name", Message3.getText());
		System.out.println(Message3.getText());
		driver.switchTo().defaultContent();




	}


	@AfterTest
	public void CloseDriver() {

		driver.close();
	}




}
