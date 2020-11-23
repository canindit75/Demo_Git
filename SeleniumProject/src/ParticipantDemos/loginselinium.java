package ParticipantDemos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 
public class loginselinium 
{
 
    public static void main(String[] args) 
    {
        
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trivago.in/");
        //WebElement login=driver.findElement(By.id("header-login")); 
        WebElement login=driver.findElement(By.xpath("//*[text()='Log in']"));
        login.click();
        
        String expectedUrl="https://www.trivago.in/";
        String actualUrl= driver.getCurrentUrl();
        
        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }
        
        
        
    }
 
}
