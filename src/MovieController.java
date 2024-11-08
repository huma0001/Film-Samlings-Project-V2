import java.util.ArrayList;

public class MovieController {
    MovieCollection movieCollection = new MovieCollection();

    public void showAllMovies() {
        movieCollection.displayMovies();
    }

    public void addMovie1(Movie movie) {
        movieCollection.addMovie(movie);
    }

    public void searchMovie1(String search) {
        movieCollection.searchMovies(search);
    }

    public boolean editMovie(String search, String newTitle, String newDirector, int newYear, int newLength, boolean newIsInColor, String newGenre) {
        return movieCollection.editMovie(search, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
    }

    public boolean deleteMovie(String titleToDelete) {
        return movieCollection.deleteMovie(titleToDelete);
    }

    public void saveMovies(){
        movieCollection.saveMoviesFile();
    }

    public void loadMovies(){
        movieCollection.loadMoviesFile();
    }

    public void sortMovies(String userAtr){
        movieCollection.sortMovies(userAtr);
    }

    public void sortMoviesByTwoAttributes(String primaryAttribute, String secondaryAttribute) {
        movieCollection.sortMoviesByTwoAttributes(primaryAttribute, secondaryAttribute);
    }



}


