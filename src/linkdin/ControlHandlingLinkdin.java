package linkdin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class ControlHandlingLinkdin 
{
	WebDriver driver;
  @BeforeTest
  public void invokeBrowse()
  {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AGRAMIT\\Downloads\\Divya\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

		driver.get("https://in.linkedin.com/");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Interrupted Exception Occur");
		}
		System.out.println("landed to Linkdin portal");  
  }
  @Test
  public void SignUpLink() 
  {
	  driver.findElement(By.linkText("Join now")).click();
	  driver.findElement(By.id("first-name")).sendKeys("Divya");
	  driver.findElement(By.id("last-name")).sendKeys("Agrawal");
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("divya9693@gmail.com");
	  driver.findElement(By.cssSelector("#join-password")).sendKeys("abcde@123");
	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(By.id("recaptcha-anchor")));
	  action.click();
	  
  }
}
