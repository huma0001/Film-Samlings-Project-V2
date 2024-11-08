import java.util.Comparator;

public class MovieGenreComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){
        return m1.getGenre().compareTo(m2.getGenre());
    }


}