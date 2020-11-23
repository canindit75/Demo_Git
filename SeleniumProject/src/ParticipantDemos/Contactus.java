package ParticipantDemos;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Contactus {
		
			WebDriver driver=null;
			@Test
			public void screen() throws IOException, InterruptedException {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.travolook.in/");
				driver.manage().window().maximize(); 
				
				WebElement contact=driver.findElement(By.xpath("//*[@id='myNavbar']/ul[1]/li[4]/a"));
				contact.click();
				
				WebElement username=driver.findElement(By.xpath("//*[@id='txtFName']"));
				username.sendKeys("Mythri");
				
				WebElement email=driver.findElement(By.xpath("//*[@id=\'txtEmail\']"));
				email.sendKeys("abc@gmail.com");
				
				WebElement phone=driver.findElement(By.xpath("//*[@id=\'txtPhone\']"));
				phone.sendKeys("1234567890");
				
				WebElement message=driver.findElement(By.xpath("//*[@id=\'MsgTextBox\']"));
				message.sendKeys("nothing");
				
				//WebElement submit=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/div[4]/input"));
				WebElement submit = driver.findElement(By.xpath("//*[@value='Send Now']"));
				submit.click();
				//Thread.sleep(2000);
				WebDriverWait wait=new WebDriverWait(driver,30);
				try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert(); // switch to alert

				String alertMessage= alert.getText();
				Thread.sleep(2000);
				alert.accept(); 

				System.out.println(alertMessage); 
				}
				catch(NoAlertPresentException e) {
					System.out.println("Alert Not found");
				}catch(UnhandledAlertException e){
					System.out.println("Alert Open");
				}
				// Print Alert Message
				
				
				

		}
}
