package ParticipantDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ZomatoTest2 {
	WebDriver driver = null;
	@Test
	public void KolkataZomato() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://www.zomato.com/akola?city_id=11434");
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement LocationTextbox = driver.findElement(By.xpath("//body/section[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/input[2]"));
			LocationTextbox.clear();
			LocationTextbox.sendKeys("kolkata");
			Thread.sleep(4000);
			WebElement imagebox = driver.findElement(By.xpath("/html/body"));
			imagebox.click();
			Thread.sleep(4000);
			WebElement imagebox1 = driver.findElement(By.xpath("/html/body"));
			imagebox1.click();
			Thread.sleep(4000);
			WebElement OnlineOrderbox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]"));
			OnlineOrderbox.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(1500, document.body.scrollHeight)");
			WebElement Pricebox = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[12]/div[2]/a[2]/div[1]"));
			Pricebox.click();
			Thread.sleep(3000);
			WebElement KFCbox = driver.findElement(By.xpath("//a[contains(text(),'KFC')]"));
			if(KFCbox.getText().equals("KFC")){
				System.out.println("KFC is Available.");
				KFCbox.click();
				Thread.sleep(5000);
			}
			else{
				System.out.println("KFC is Unavailable.");
			}
			
			driver.close();
			driver.quit();
			
	}

}
