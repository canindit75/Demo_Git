package ParticipantDemos;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZomatoTest3 {

	WebDriver driver = null;
	@Test
	public void ZomatoOrder() throws InterruptedException{
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
		WebElement Searchbox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/div[3]/input[1]"));
		Searchbox.click();
		Searchbox.sendKeys("Biriyani");
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(1000, document.body.scrollHeight)");
		WebElement OnlineOrderbox = driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[3]/div[2]/div[2]/div[1]/div[3]/div[1]/i[1]/*[1]"));
		OnlineOrderbox.click();
		Thread.sleep(3000);
		WebElement Suggestionbox = driver.findElement(By.xpath("//p[contains(text(),'Arsalan')]"));
		try{
			if(Suggestionbox.getText().equals("Arsalan")){
				System.out.print("Arsalan is Avalable.");
				Suggestionbox.click();
				Thread.sleep(3000);
			}
		}catch(NoSuchElementException e){
			System.out.print("Arsalan is Unavalable.");
		}
		
		driver.close();
		driver.quit();
	}

}
