package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadingFile {
	ChromeDriver driver;


	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", ChromePath);

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");

	}

	@Test
	public void UploadFile() {
		String ImageName = "Image.jpg";
		String ImagePath= System.getProperty("user.dir")+"/Uploads/"+ImageName;
		WebElement uploadfile = driver.findElement(By.id("file-upload"));
		uploadfile.sendKeys(ImagePath);
		WebElement FileSubmit = driver.findElement(By.id("file-submit"));
		FileSubmit.click();


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();

	}
}
