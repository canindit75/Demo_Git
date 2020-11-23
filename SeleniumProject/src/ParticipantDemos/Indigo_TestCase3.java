package ParticipantDemos;

import java.io.File;

import org.apache.commons.io.FileUtils;

//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indigo_TestCase3 {

	static WebDriver driver;
	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		driver.manage().window().maximize();
		WebElement menu = driver.findElement(By.xpath("//body/div[@id='body']/section[1]/div[1]/nav[1]/div[1]/a[2]/i[1]"));
		menu.click();
		WebElement webcheckin=driver.findElement(By.xpath("//body/div[@id='body']/section[1]/div[1]/nav[1]/div[1]/div[5]/nav[1]/ul[1]/div[1]/li[3]/a[1]]"));
		webcheckin.click();
		WebElement pnr=driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		pnr.sendKeys("123456");
		WebElement mail = driver.findElement(By.xpath("//input[@id='checkin-emailorlast']"));
		mail.sendKeys("123456@gmail.com");
		WebElement checkin=driver.findElement(By.xpath("//button[contains(text(),'Check-in')]"));
		checkin.click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/Screenshots/CitibankPage.png"));
		
		Thread.sleep(3000);
		driver.close();

	}

}
