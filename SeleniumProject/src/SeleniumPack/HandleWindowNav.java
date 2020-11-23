package SeleniumPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindowNav {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		driver.manage().window().maximize(); //maximizing window
		//now i want to get the window id of the main window 
		String ParentWindowId = driver.getWindowHandle();
		System.out.println("Parent Window ID = " + ParentWindowId);
		//Click on Login Now button
		WebElement LoginNow = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
		LoginNow.click(); //It will open another new window 
		//At this point of time, there are 2 windows open via script
		//NOw, I need to get window handles or window ids of both the windows
		//Please note whenever you are performing an operation that is leading to opening up
		//another window -you need to make sure to getWindowHandles to know the current number
		//of open windows and window ids
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of Open Windows = " + winids.size());
		//If i want to iterate through the set of window ids - can use the Iterator 
		//iTerator is used to iterator the set of window ids 
		Iterator<String> iter = winids.iterator();
		String mainWindowId = iter.next().toString();
		String subWindowId = iter.next().toString();
		System.out.println("mainWindowId = " + mainWindowId);
		System.out.println("subWindowId = " + subWindowId);
		//Switch control to sub window 
		driver.switchTo().window(subWindowId);
		WebDriverWait wait = new WebDriverWait(driver,30);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
			driver.findElement(By.id("User_Id")).sendKeys("Selenium");
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(mainWindowId);
			driver.findElement(By.id("topMnuinsurance")).click();
		}catch(Exception e){
			System.out.println("Element User_Id is not found");
		}
	}
}
