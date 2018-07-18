package imdbTotal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Locators;
import utils.Properties;


public class ParentTest {
	
	protected WebDriver driver;
	
	public void setUp() {
		System.setProperty(Properties.CHROME, Properties.CHROME_DRIVER_ADDRESS);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Properties.MEDIUM_WAIT, TimeUnit.SECONDS);
	}

	
	@After
	public void tearDown() {
		driver.quit();	
	}
	
	protected void validateMovieExists(String nombre, String expectedYear) {
		WebElement firstMovie = driver.findElement(Locators.FIRST_MOVIE_LOCATOR);
		assertNotNull(firstMovie);
		if (firstMovie.getText().contains(expectedYear)) 
			System.out.println("The movie exists");
		System.out.println(firstMovie.getText());
		
	}

	protected void searchMovie(String title) {
		WebElement searchBar = driver.findElement(Locators.NAVIGATION_BAR_LOCATOR);
		assertNotNull(searchBar);
		searchBar.sendKeys(title);
		searchBar.submit();
	}

	protected void validatePage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		/*if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is Wrong");
		}*/
		assertEquals(expectedTitle, actualTitle);
		
	}

	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
	protected void playTrailer() throws InterruptedException {
		WebDriverWait wait =  new WebDriverWait(driver,15);
		WebElement playButton = driver.findElement(Locators.TRAILER_LOCATOR);
		assertNotNull(playButton);
		playButton.click();
		
		//wait.until(ExpectedConditions.textToBe(locator, value))

		wait.until(ExpectedConditions.textToBe(By.xpath("\"//*[@id=\\\"imdb-jw-video-1\\\"]/div[9]/div[4]/div[2]/div[7]\")"), "00:15"));
		System.out.println("Espera");
		/*WebElement time = driver.findElement(By.xpath("//*[@id=\"imdb-jw-video-1\"]/div[9]/div[4]/div[2]/div[7]"));
		if(time.getText().equals("00:00"))
			System.out.println("Si se reprodujo el video");
		WebElement time2 = driver.findElement(By.xpath("//*[@id=\"imdb-jw-video-1\"]/div[9]/div[4]/div[2]/div[7]"));*/
		
	}

	protected void validateCorrectMovie(String expectedTitle) {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("Si es la película correcta");		
	}

	protected void selectMovie(String name) {
		WebElement movie = driver.findElement(By.linkText(name));
		assertNotNull(movie);
		movie.click();
		
	}
	
	protected void validateMovieStars(String [] expectedActor) {
		String [] actors = {"","",""};
		
		for (int i = 0; i < 3; i++) {
			WebElement actor = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[3]/div[1]/div[4]/span[" + (i+1) + "]/a/span"));
			actors[i] = actor.getText();
			assertEquals(actors[i], expectedActor[i]); 
			
		}
		
	}
}


