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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	
	@After
	public void tearDown() {
		//driver.quit();
		
	}
	protected void validateMovieExists(String nombre, String expectedYear) {
		WebElement firstMovie = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]"));
		if (firstMovie.getText().contains(expectedYear)) 
			System.out.println("YES!");
		System.out.println(firstMovie.getText());
		
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
		/*WebElement time = driver.findElement(By.xpath("//*[@id=\"imdb-jw-video-1\"]/div[9]/div[4]/div[2]/div[7]"));
		if(time.getText().equals("00:00"))
			System.out.println("Si se reprodujo el video");
		WebElement time2 = driver.findElement(By.xpath("//*[@id=\"imdb-jw-video-1\"]/div[9]/div[4]/div[2]/div[7]"));*/
		
	}

	protected void validateCorrectMovie(String expectedTitle) {
		// TODO Auto-generated method stub
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("Si es la pel�cula correcta");
		}
		
	}

	protected void selectMovie(String nombre) {
		WebElement movie = driver.findElement(By.linkText(nombre));
		movie.click();
		
	}
	
	protected void validateMovieStars(String [] expectedActor) {
		String [] actors = {"","",""};
		
		for (int i = 0; i < 3; i++) {
			WebElement actor = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[3]/div[1]/div[4]/span[" + (i+1) + "]/a/span"));
			actors[i] = actor.getText();
			if(expectedActor[i].equals(actors[i])){
				System.out.println(actors[i]);
				System.out.println("Todo Bien");
			} else {
				System.out.println("Error");
			}
			
		}
		
	}
}


