import java.util.Comparator;

public class MovieYearCreatedComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){
        return m1.getYearCreated() - m2.getYearCreated();
    }


}