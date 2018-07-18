package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookBaseTest {
	
	protected WebDriver driver;
	
	protected void setUp(String browser, String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		System.out.println("Arranca el browser porfa y navega a la pagina.");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		System.out.println("Destruye la configuracion");
		driver.quit();
	}
	
	protected void likeAllPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void gotoPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void searchFacebookFriend(String friendName) {
		// TODO Auto-generated method stub
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.clear();
		searchBar.sendKeys(friendName);
		searchBar.submit();
	}

	protected void logIntoFacebook(String user, String password) {
		// TODO Auto-generated method stub
		WebElement userBox = driver.findElement(By.id("email"));
		WebElement passBox = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		userBox.clear();
		userBox.sendKeys(user);
		passBox.clear();
		passBox.sendKeys(password);
		loginButton.click();
	}

}
