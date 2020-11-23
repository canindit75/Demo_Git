package ParticipantDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZomatoTest4 {
	WebDriver driver = null;
	@Test
	public void LoginTry() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.zomato.com/akola?city_id=11434");
		driver.manage().window().maximize();
		
		WebElement loginlink = driver.findElement(By.xpath("//*[@id='signin-link']"));
		loginlink.click();
		Thread.sleep(3000);
		
		WebElement loginclick = driver.findElement(By.xpath("//*[@id='login-email']"));
		loginclick.click();
		Thread.sleep(3000);
		
		WebElement mailTextbox = driver.findElement(By.xpath("//*[@id='ld-email']"));
		mailTextbox.clear();
		mailTextbox.sendKeys("riksingha1998@gmail.com");
		Thread.sleep(3000);
		
		WebElement submit1Textbox = driver.findElement(By.xpath("//*[@id='ld-submit-global']"));
		submit1Textbox.click();
		Thread.sleep(3000);
		
		WebElement passwordTextbox = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div[4]/div[2]/div/input"));
		passwordTextbox.clear();
		passwordTextbox.sendKeys("xyz123");
		Thread.sleep(3000);
		
		WebElement submit2Textbox = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div[4]/div[2]/a"));
		submit2Textbox.click();
		Thread.sleep(3000);
		
		WebElement msgTextbox = driver.findElement(By.xpath("//*[@id='login-otp-error']"));
		if(msgTextbox.getText().equals("Invalid verification code"))
			System.out.println("Login was not Successful");
		else
			System.out.println("Login was Successful");
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}
}
