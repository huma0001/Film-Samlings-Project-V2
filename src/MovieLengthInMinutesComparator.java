import java.util.Comparator;

public class MovieLengthInMinutesComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){
        return m1.getLengthInMinutes() - m2.getLengthInMinutes();
    }


}