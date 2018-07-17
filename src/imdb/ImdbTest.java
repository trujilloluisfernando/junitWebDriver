package imdb;

import org.junit.Test;

public class ImdbTest extends ParentTest{
	
	/*@Test
	public void testSearchMovie() {
		String nombre = "Titanic";
		navigateToPage("http://imdb.com");
		validatePage("IMDb - Movies, TV and Celebrities - IMDb");
		searchMovie(nombre);
		validateMovieExists(nombre);
	}*/
	
	
	@Test
	public void testPlayTrailer() throws InterruptedException {
		String nombre = "McQueen";
		String pageTitle = "McQueen (2018) - IMDb";
		navigateToPage("http://imdb.com");
		validatePage("IMDb - Movies, TV and Celebrities - IMDb");
		searchMovie(nombre);
		validateMovieExists(nombre);
		selectMovie(nombre);
		validateCorrectMovie(pageTitle);
		playTrailer();
		
		
	}
	
	
/*
	@Test
	public void testValidateMovieStars() {
		navigateToPage("http://imdb.com");
		validatePage();
		searchMovie();
		validateMovieExists();
		selectMovie();
		validateCorrectMovie();
		validateMovieStars();
	}
	*/

	

}
