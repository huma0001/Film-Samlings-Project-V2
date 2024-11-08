import java.util.Comparator;

public class MovieDirectorComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){
        return m1.getDirector().compareTo(m2.getDirector());
    }


}