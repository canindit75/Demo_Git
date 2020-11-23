package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByXpath {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		
		WebElement ageLabelByAbsPath = driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/table[1]/tbody/tr[1]/td[1]"));
		System.out.println("Identifying Label Value of Absolute path : " +ageLabelByAbsPath.getText());
		
		WebElement ageLabelBYRelPath = driver.findElement(By.xpath("//table[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println("Identifying Label Value of Relative path : " +ageLabelBYRelPath.getText());
	}
}

