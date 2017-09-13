package utulities;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTranslateTest {
	// open google translate page
	// using a scanner take a sentence in english from user
	// select englis as from language and select ZULU toLanguage
	// read the translation into a variable then print it
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
//		
//		System.setProperty(Config.getProperty("drivertype"), Config.getProperty("driverpath"));
//		driver=new ChromeDriver();
		
		driver=Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
		
		
	}
	@Test
	public void test() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter text to be translated:");
		String inputText=scan.nextLine();
		
		driver.findElement(By.id("source")).sendKeys(inputText);
		driver.findElement(By.id("gt-tl-gms")).click();
		
		String toLang=Config.getProperty("toLanguage");
		WebElement toLanguage=driver.findElement(By.xpath("//div[.='"+ toLang+"']"));
		
		//WebElement toLanguage=driver.findElement(By.xpath("//div[.='Zulu']"));
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(toLanguage));
		toLanguage.click();
		
		driver.findElement(By.id("gt-submit")).click();
		
		
		String translatedText=driver.findElement(By.id("gt-res-dir-ctr")).getText();
		
		System.out.println("TRANSLATION TO ZULU:" + translatedText);
	
	}
@Test
public void test2(){
//	Driver.getDriver().get("http://etsy.com");
//	Driver.getDriver().get("http://google.com");
}

}
