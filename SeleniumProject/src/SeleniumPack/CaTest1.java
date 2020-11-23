package SeleniumPack;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CaTest1 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void caTest1() {
    driver.get("https://www.calculator.net/calorie-calculator.html");
    driver.manage().window().setSize(new Dimension(783, 720));
    driver.findElement(By.cssSelector("tbody:nth-child(3) > tr:nth-child(1)")).click();
    driver.findElement(By.id("cage")).sendKeys("45");
    driver.findElement(By.cssSelector("td > .cbcontainer:nth-child(2) > .rbmark")).click();
    driver.findElement(By.id("metricheightweight")).click();
    driver.findElement(By.id("cheightmeter")).sendKeys("200");
    driver.findElement(By.id("metricweight")).click();
    driver.findElement(By.id("ckg")).sendKeys("89");
    driver.findElement(By.id("cactivity")).click();
    {
      WebElement dropdown = driver.findElement(By.id("cactivity"));
      dropdown.findElement(By.xpath("//option[. = 'Active: daily exercise or intense exercise 3-4 times/week']")).click();
    }
    driver.findElement(By.id("cactivity")).click();
    driver.findElement(By.cssSelector("td:nth-child(2) > input:nth-child(2)")).click();
  }
}
