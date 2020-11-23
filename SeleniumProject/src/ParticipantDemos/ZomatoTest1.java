package ParticipantDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZomatoTest1 {
	WebDriver driver = null;
	@Test
	public void SelectingKolkata() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://www.zomato.com/akola?city_id=11434");
			driver.manage().window().maximize();
			WebElement Indialink = driver.findElement(By.xpath("/html[1]/body[1]/footer[1]/div[1]/div[5]/div[3]/ul[1]/li[1]/a[1]"));
			Indialink.click();
			Thread.sleep(4000);
			WebElement ver1link = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/h2[1]"));
			WebElement Kolkatalink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]/div[43]/a[1]/div[1]/div[1]/h5[1]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			if(ver1link.getText().equals("Find the best restaurants, cafés and bars in India")){
				System.out.println("We can select any location. I'm going to select Kolkata.");
				js.executeScript("window.scrollTo(1500, document.body.scrollHeight)");
				Thread.sleep(3000);
				Kolkatalink.click();
				Thread.sleep(3000);
			}
			else{
				System.out.println("Oops, Something is Wrong.");
			}
			Thread.sleep(3000);
			driver.close();
			driver.quit();
			
	}

		
}
