package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementBylinkText {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		WebElement bmilink = driver.findElement(By.linkText("BMI"));
		bmilink.click(); //navigate to the BMI page
		System.out.println("Title of the BMI Page = " + driver.getTitle());
		//go back to the previous
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Title of Calorie Page = " + driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement weightLink = driver.findElement(By.partialLinkText("Weight"));
		weightLink.click();
		Thread.sleep(2000);
		System.out.println("PageSource = " + driver.getPageSource());
		driver.navigate().back(); //Calorie Calculator 
		Thread.sleep(2000);
		driver.navigate().forward();//IdealWeight
		driver.navigate().refresh();
		Thread.sleep(2000); //Reloading my Page
		//bmilink.click(); //this is going to give me an error - StaleElementReferenceException
		driver.findElement(By.linkText("BMI")).click();
		
		
		
	}
}
