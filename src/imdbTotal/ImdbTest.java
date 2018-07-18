package imdbTotal;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class ImdbTest extends ParentTest{
	
	
	@Test
	@FileParameters("./data/imdbTotal/movieData.csv")
	public void testSearchMovie(String name,String url,String title,String year) {
		setUp();
		navigateToPage(url);
		//validatePage(title);
		searchMovie(name);
		validateMovieExists(name,year);
	}
	
	
	@Test
	@FileParameters("./data/imdbTotal/movieData.csv")
	public void testPlayTrailer(String name,String url,String title,String year) throws InterruptedException {
		setUp();
		navigateToPage(url);
		validatePage(title);
		searchMovie(name);
		validateMovieExists(name,year);
		selectMovie(name);
		validateCorrectMovie(name + " (" + year + ") - IMDb");
		playTrailer();
		 
		
	}
	

	@Test
	@FileParameters("./data/imdbTotal/movieStars.csv")
	public void testValidateMovieStars (String name,String url,String title,String year,String[] expectedActor) {
		setUp();
		navigateToPage(url);
		validatePage(title);
		searchMovie(name);
		validateMovieExists(name,year);
		selectMovie(name);
		validateCorrectMovie(name + " (" + year + ") - IMDb");
		validateMovieStars(expectedActor);
	}
	

	

}
