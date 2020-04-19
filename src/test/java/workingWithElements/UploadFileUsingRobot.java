package workingWithElements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileUsingRobot {
	ChromeDriver driver;


	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", ChromePath);

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");

	}

	@Test
	public void UploadFileWithRobot() throws AWTException {
		String ImageName = "Image.jpg";
		String ImagePath= System.getProperty("user.dir")+"/Uploads/"+ImageName;
		WebElement uploadfile = driver.findElement(By.id("file-upload"));

		// Code using Robot class for file upload
		Robot robot = new Robot();

		// copy the ImagePath
		StringSelection selection = new StringSelection(ImagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);

		// Paste the ImagePath
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		uploadfile.sendKeys(ImagePath);
		WebElement FileSubmit = driver.findElement(By.id("file-submit"));
		FileSubmit.click();


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();

	}
}

