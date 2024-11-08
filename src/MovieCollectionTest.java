import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        MovieCollection gg = new MovieCollection();
        Movie inception = new Movie("Inception", "gg", 2003, true, 22, "Drama");
        gg.addMovie(inception);
        String expectedResult = "Inception";
        String actualResult = inception.getTitle();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getMovieNumber(){
        MovieCollection movieCollection = new MovieCollection();
        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, true, 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, true, 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);
        int expectedResult = 3;
        int actualResult = movieCollection.getMovieNumber();
        assertEquals(expectedResult,actualResult);

    }


    @Test
    void getMovieList() {
        MovieCollection movieCollection = new MovieCollection();

        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, true, 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, true, 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");

        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);

        ArrayList actualResult1 = movieCollection.getMovieList();
        int expectedResult1 = 3;


        // Title expected/result
        String expectedTitle1 = movie1.getTitle();
        String actualTitle1 = movieCollection.getMovieList().get(0).getTitle();

        String expectedTitle2 = movie2.getTitle();
        String actualTitle2 = movieCollection.getMovieList().get(1).getTitle();

        String expectedTitle3 = movie3.getTitle();
        String actualTitle3 = movieCollection.getMovieList().get(2).getTitle();


        // Confirm movie list length
        assertEquals(actualResult1.size(),expectedResult1);

        // Confirm movie 1, movie 2 and movie 3 are correctly placed in the array list
        assertEquals(expectedTitle1, actualTitle1);
        assertEquals(expectedTitle2, actualTitle2);
        assertEquals(expectedTitle3, actualTitle3);
    }


    @Test
    void searchMovieExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);
        Movie searchFound = movieCollection.searchMovie("Hunger Games");
        String actualResult = movie3.getTitle();
        String expectedResult = "Hunger Games";

        // Assert - Vi gemmer search resultatet i en Movie type og sætter den op mod en "notNull"
        // Derefter laver vi en AssertEquals med en direkte string titel mod den fundnens film titel**VIGTIGT
        // Gamle kode = assertEquals(expectedResult, actualResult);
        // Gamle kode gøre ikke hvad vi forventer Issue: searchMovie("Hunger Games") doesn’t store or check its result, so the test would pass even if searchMovie is broken or unimplemented.
        // Her finder vi faktisk en film - ser om den fundne film er = null // hvis ikke er den fundet. derefter sammenligner vi fundet films titel med actual film titel.
        assertNotNull(searchFound);
        assertEquals(expectedResult, searchFound.getTitle());

    }


    @Test
    void searchMovieDoesNotExist(){
        // Arrange
        MovieCollection movieCollection = new MovieCollection();

        // Act
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);

        //Tester for CAPS-sensitivity og wrong spelling
        Movie movie = movieCollection.searchMovie("Bruno");
        Movie movie1 = movieCollection.searchMovie("bruno");
        Movie movie2 = movieCollection.searchMovie("hunnger games");


        // Assert - Brug Assertion metoden assertNull og giv den actualResult som argument .
        Assertions.assertNull(movie);
        Assertions.assertNull(movie1);
        Assertions.assertNull(movie2);

    }




    // Vi skal lave en *SearchMovies* metode da vi kun har searchMovie
    @Test
    void searchMoviesExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act - Brug PlayList's findTrack metode til at finde dit nylavede Track objekt. Kald metoden getTitle på det track du har fundet og gem resultatet i en String variabel med navnet actualResult.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");

        movieCollection.addMovie(movie3);
        movieCollection.addMovie(movie4);
        Movie searchResult = movieCollection.searchMovie("H");
        String actualResult = movieCollection.getMovieList().get(0).getTitle() + "" + movieCollection.getMovieList().get(1).getTitle();
        String expectedResult = "Hunger Games" + "Harry Potter 3";

        // Assert - først tjekker vi om den overhovedet fandt film ved at bruge assertNotNull
        assertNotNull(searchResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void displayMovies(){
        MovieCollection movieCollection = new MovieCollection();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);
        movieCollection.addMovie(movie4);

        String expectedResult = movie3 + " " + movie4;
        String actualResult = movieCollection.getMovieList().get(0).toString() + " " + movieCollection.getMovieList().get(1).toString();


        assertEquals(expectedResult, actualResult);
    }


    @Test
    void editMovie(){
        MovieCollection movieCollection = new MovieCollection();
        ArrayList<Movie> arrayListMovies = movieCollection.getMovieList();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");

        arrayListMovies.add(movie3);
        movie3.setTitle("Stuck in the dryer");
        String expectedResult = "Stuck in the dryer";
        String actualResult = arrayListMovies.get(0).getTitle();

        assertEquals(expectedResult,actualResult);
    }



    @Test
    void deleteMovie(){
        MovieCollection movieCollection = new MovieCollection();
        ArrayList<Movie> movieArrayList = movieCollection.getMovieList();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");
        movieArrayList.add(movie3);
        movieArrayList.add(movie4);

        movieArrayList.remove(0);

        int expectedResult = 1;
        int actualResult = movieArrayList.size();

        assertEquals(expectedResult, actualResult);
    }




}

