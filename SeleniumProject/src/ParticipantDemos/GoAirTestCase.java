package ParticipantDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoAirTestCase {
	
	WebDriver driver;

	@Test
	public void GoAirTC1() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goair.in/");
		driver.manage().window().maximize();
		WebElement PlanMyTripLink = driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/li[3]/p/span"));
		PlanMyTripLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainmenu\"]/li[3]/ul/li[6]/a")));
		WebElement FlightSchedule = driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/li[3]/ul/li[6]/a"));
		actions.moveToElement(FlightSchedule).click().build().perform();
		// PrinterElement.click();
		} catch (NoSuchElementException e) {
		System.out.println("Flight Schedule element is not found");
		}
		
		try{ // By class attribute
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='txtOrigin'][@value='BKK']")));
			WebElement b = driver.findElement(By.xpath("//*[@class='txtOrigin'][@value='BKK']"));
			// WebElement
			// b=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div/div/div/div/div[1]/button[7]"));

			 b.click();
			Thread.sleep(2000);

		}catch (NoSuchElementException e) {
			System.out.println("No Such Element");
			}

		//WebElement table = driver.findElement(By.className("umb-table-tabl"));
		//List<WebElement> rows = table.findElements(By.tagName("tr")); // all rows with respect to table element
		 List<WebElement> countryList = driver.findElements(By.xpath("//*[@class='umb-table-tabl']//tr"));
		 System.out.println("row size=" + countryList.size());
	}
}
