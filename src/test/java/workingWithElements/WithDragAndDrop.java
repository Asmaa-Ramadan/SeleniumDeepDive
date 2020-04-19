package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithDragAndDrop {



	ChromeDriver driver;

	@BeforeTest  
	public void OpenURL() {

		String ChromPath= System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromPath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");

	}

	@Test

	public void DragAndDrop() {

		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Target = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(Source, Target).perform();
		Assert.assertEquals("Dropped!", Target.getText());	

	}

	@AfterTest

	public void CloseDriver() {

		driver.close();
	}
}
