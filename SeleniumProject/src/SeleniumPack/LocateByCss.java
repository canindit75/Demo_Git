package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCss {

static WebDriver driver;
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.calculator.net/calorie-calculator.html");
	driver.manage().window().maximize(); //maximizing window
	WebElement ageLabelByCss = 
	driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
	System.out.println(ageLabelByCss.getText());
	WebElement ageTextbox = driver.findElement(By.cssSelector("#cage"));
	ageTextbox.clear();
	ageTextbox.sendKeys("65");
	System.out.println("Get Css Value of width of Age Textbox = " + ageTextbox.getCssValue("width"));
			
	WebElement table = driver.findElement(By.cssSelector(".cinfoT "));
	//all this while we were using findElement and findElements with respect to driver object
	//here we will use it with respect to the table element
	//if i identify rows by driver object - it will rows of all tables in the web page - we
	//want only rows of the table which is identified by cinfoT and only the first table
	List<WebElement> rows = table.findElements(By.tagName("tr")); //all rows with respect to table element
	for(WebElement row : rows){
		List<WebElement> cols = row.findElements(By.tagName("td")); //identifies all cols for the current row
		for(WebElement col : cols){
			System.out.print(col.getText() + "\t"); //this is to print all the cellss of a particular row in the same line
		}
		System.out.println(""); //go to the next line before print the cell values of next row
	}		

}

}
