package imdb;

import org.junit.Test;

public class ImdbTest extends ParentTest{
	
/*	@Test
	public void testSearchMovie() {
		String nombre = "Titanic (1997)";
		navigateToPage("http://imdb.com");
		validatePage("IMDb - Movies, TV and Celebrities - IMDb");
		searchMovie(nombre);
		validateMovieExists(nombre,"1997");
	}*/
	
	/*
	@Test
	public void testPlayTrailer() throws InterruptedException {
		String nombre = "McQueen";
		String pageTitle = "McQueen (2018) - IMDb";
		navigateToPage("http://imdb.com");
		validatePage("IMDb - Movies, TV and Celebrities - IMDb");
		searchMovie(nombre);
		validateMovieExists(nombre,"2018");
		selectMovie(nombre);
		validateCorrectMovie(pageTitle);
		playTrailer();
		 
		
		
	}
	
*/

	@Test
	public void testValidateMovieStars() {
		String [] expectedActor = {"Leonardo DiCaprio","Kate Winslet","Billy Zane"};
		navigateToPage("http://imdb.com");
		validatePage("IMDb - Movies, TV and Celebrities - IMDb");
		searchMovie("Titanic");
		validateMovieExists("Titanic", "1997");
		selectMovie("Titanic");
		validateCorrectMovie("Titanic (1997) - IMDb");
		validateMovieStars(expectedActor);
	}
	


	

}
