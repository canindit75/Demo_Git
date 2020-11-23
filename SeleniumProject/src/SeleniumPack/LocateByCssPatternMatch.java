package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCssPatternMatch {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		System.out.println("Identify all elements by attribute id that start with c using css");
		
		List<WebElement> startswithidccss = driver.findElements(By.cssSelector("[id^='c']"));
		System.out.println(startswithidccss.size());
		for(WebElement element :startswithidccss ){
			System.out.println(element.getAttribute("id"));
		}

		System.out.println("Identify all elements by attribute id containing height using css");
		List<WebElement> containsidheightcss = driver.findElements(By.cssSelector("[id*='height']"));
		System.out.println(containsidheightcss.size());
		for(WebElement element :containsidheightcss ){
			System.out.println(element.getAttribute("id"));
		}

		System.out.println("Identify all elements by attribute id that ends with weight using css");		
		List<WebElement> endsswithnameweightcss = driver.findElements(By.cssSelector("[id$='weight']"));
		System.out.println(endsswithnameweightcss.size());
		for(WebElement element :endsswithnameweightcss ){
			System.out.println(element.getAttribute("id"));
		}

	}
}
