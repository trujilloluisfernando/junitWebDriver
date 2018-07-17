package imdb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentTest {
	
	protected WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}

	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	protected void validateMovieExists(String nombre) {
		//WebElement firstMovie = driver.findElement(By.xpath("//*[@class='result_text']"));
		driver.findElement(By.linkText(nombre));
		System.out.println("La película si existe!");
		
	}

	protected void searchMovie(String title) {
		WebElement searchBar = driver.findElement(By.id("navbar-query"));
		searchBar.sendKeys(title);
		searchBar.submit();
	}

	protected void validatePage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is Wrong");
			System.exit(-1);
		}
		
	}

	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
	protected void playTrailer() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement playButton = driver.findElement(By.xpath("//a[@itemprop='trailer']"));
		playButton.click();
		driver.wait(15);
		
	}

	protected void validateCorrectMovie(String expectedTitle) {
		// TODO Auto-generated method stub
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("Si es la película correcta");
		}
		
	}

	protected void selectMovie(String nombre) {
		WebElement movie = driver.findElement(By.linkText(nombre));
		movie.click();
		
	}
	
	protected void validateMovieStars() {
		// TODO Auto-generated method stub
		
	}


}
