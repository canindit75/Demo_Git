package ParticipantDemos;

import java.util.concurrent.TimeUnit;

//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indigo_TestCase2 {

	static WebDriver driver;
	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goindigo.in/aff.html?cid=Display|Affiliate|Icubes|2050_1007768-DM-1627574838277222475");
		driver.manage().window().maximize();

		WebElement offers = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[4]/a"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		offers.click();
		
		WebElement flightoffers = driver.findElement(By.xpath("//*[text()='Offers']"));
		//WebElement flightoffers=driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"));
		flightoffers.click();
		
		WebElement APB=driver.findElement(By.xpath("//input[@id='mobilePass']"));
		APB.click();
		WebElement dest = driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/input[1]"));
		dest.sendKeys("Abu Dhabi");
		WebElement search = driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[6]/div[2]/button[1]"));
		search.click();
		Thread.sleep(3000);
		driver.close();

	}

}
