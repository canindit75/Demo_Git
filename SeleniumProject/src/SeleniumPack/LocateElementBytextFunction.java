package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocateElementBytextFunction {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		System.out.println("identify all the options in the dropdown that have Active - will require use of contains function");
		List<WebElement> containsActiveList = 
		driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
		for(WebElement element : containsActiveList){
			System.out.println(element.getText());
		}
		System.out.println("identify the option that starts with Extra - this will require use of starts-with function");
		
		List<WebElement> startswithExtraList = 
		driver.findElements(By.xpath("//*[@id='cactivity']/option[starts-with(text(),'Extra')]"));
		for(WebElement element : startswithExtraList){
			System.out.println(element.getText());
		}
		System.out.println("Identify the element with text - Very Active: intense exercise 6-7 times/week - this will require to perform an exact match");
		WebElement VeryActiveElement = 
		driver.findElement(By.xpath("//*[@id='cactivity']/option[text()='Very Active: intense exercise 6-7 times/week']"));
		System.out.println(VeryActiveElement.getText());
	}
}
