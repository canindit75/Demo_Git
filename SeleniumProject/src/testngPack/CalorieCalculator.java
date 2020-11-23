package testngPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalorieCalculator {
	WebDriver driver = null;
	@Test
	public void EnterCalorieDetails() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize(); //maximizing window
		WebElement ageTextbox = driver.findElement(By.id("cage"));		
		ageTextbox.clear(); //clears the textbox
		ageTextbox.sendKeys("45"); //enters value into the textbox
		//I also want to retrieve the different attribute information
		System.out.println("Tagname of ageTextbox = " + ageTextbox.getTagName());
		System.out.println("id value of ageTextbox = " + ageTextbox.getAttribute("id"));
		System.out.println("name value of ageTextbox = " + ageTextbox.getAttribute("name"));
		System.out.println("type value of ageTextbox = " + ageTextbox.getAttribute("type"));
		System.out.println("class value of ageTextbox = " + ageTextbox.getAttribute("class"));
		//retrives value from the textbox
		System.out.println("value of ageTextbox = " + ageTextbox.getAttribute("value"));
		
		//Locate Elements by name attribute
		//import the package java.util.List
		List<WebElement> genderList = driver.findElements(By.name("csex"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals("f"))
				{
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}		
		//By class attribute
		WebElement table = driver.findElement(By.className("cinfoT"));
		table = driver.findElement(By.xpath("//*[@class='cinfoT ']"));
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
		Thread.sleep(3000);
		driver.close();
	}

}
