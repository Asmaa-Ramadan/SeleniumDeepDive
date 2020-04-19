package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {

	ChromeDriver driver;

	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir") +"\\Sources\\chromedriver.exe" ;
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void TestContextmenu () {

		WebElement Clickmebtn = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement ContextMenu = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
		Actions builder = new Actions(driver);
		builder.contextClick(Clickmebtn).moveToElement(ContextMenu).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert  = wait.until(ExpectedConditions.alertIsPresent());
		assertEquals("clicked: edit", alert.getText());
		alert.dismiss();
	}



	@AfterTest
	public void CloseDriver() {
		driver.close();
	}




}
