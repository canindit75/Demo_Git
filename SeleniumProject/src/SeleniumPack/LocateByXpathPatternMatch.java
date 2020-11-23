package SeleniumPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpathPatternMatch {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Identify all elements by attribute id that start with c using xpath");
		
		List<WebElement> startswithidcxpath = driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		System.out.println(startswithidcxpath.size());
		for(WebElement element :startswithidcxpath ){
			System.out.println(element.getAttribute("id"));
		}

		System.out.println("Identify all elements by attribute id containing height");
		List<WebElement> containsidheightxpath = driver.findElements(By.xpath("//*[contains(@id,'height')]"));
		System.out.println(containsidheightxpath.size());
		for(WebElement element :containsidheightxpath ){
			System.out.println(element.getAttribute("id"));
		}

		System.out.println("Identify all elements by attribute id that ends with weight");
		List<WebElement> endsswithnameweightxpath = driver.findElements(By.xpath("//*[ends-with(@id,'weight')]"));
		for(WebElement element :endsswithnameweightxpath ){
			System.out.println(element.getAttribute("id"));
		}

	}

}
