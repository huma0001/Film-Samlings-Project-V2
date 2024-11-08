import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    Scanner scan = new Scanner(System.in);
    MovieController controller = new MovieController();


    public void Start() {

        System.out.println("Welcome to your movie collection!");

        boolean running = true;
        while (running) {
            displayMenu();
            int userResponse = validateInt();
            switch (userResponse) {
                case 1 -> {
                    String userResponse1 = scan.nextLine();
                    createMovie(userResponse1);
                }
                case 2 -> {
                    if (!controller.movieCollection.getMovieList().isEmpty()) {
                        controller.showAllMovies();
                    } else {
                        System.out.println("Movie list is empty");
                    }
                }
                case 3 -> {
                    System.out.println("Please write the title of the movies you are looking for");
                    scan.nextLine();
                    String titleSearch = scan.nextLine();
                    if (!titleSearch.isEmpty()) {
                        controller.searchMovie1(titleSearch);
                    } else {
                        System.out.println("You have to write at least one letter to search");
                    }
                }
                case 4 -> editMovie();
                case 5 -> deleteMovie();
                case 6 -> controller.saveMovies();
                case 7 -> controller.loadMovies();
                case 8 -> {
                    System.out.println("How would you like to sort your movie list?");
                    System.out.println("\nTitle|Director|Year|Color|Length|Genre|");
                    scan.nextLine();
                    String userSearch = scan.nextLine();
                    controller.sortMovies(userSearch);

                    controller.showAllMovies();
                }
                case 9 -> {
                    System.out.println("How would you like to sort your movie list?");
                    System.out.println("\nAvailable attributes: Title, Director, Year, Color, Length, Genre");
                    String primaryAttribute = "";
                    System.out.println("Please enter a primary-sorting-attribute");
                    primaryAttribute = validateAttributeFirst();
                    System.out.println("Please enter a secondary-sorting-attribute");
                    String secondaryAttribute = validateAttributeSecond();
                    controller.sortMoviesByTwoAttributes(primaryAttribute, secondaryAttribute);
                    System.out.println("Sucessfully sorted movies by primary attribute: '" + primaryAttribute + "' and secondary attribute: '" + secondaryAttribute + "'");
                    controller.showAllMovies();
                }
                case 10 -> running = false;
            }
        }
    }

    private void deleteMovie() {
        System.out.println("Enter the title of the movie you want to delete:");
        scan.nextLine();
        String titleToDelete = scan.nextLine();

        boolean success = controller.deleteMovie(titleToDelete);
        if (success) {
            System.out.println("Movie '" + titleToDelete + "' has been deleted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    private void editMovie() {
        System.out.println("Enter the title of the movie you want to edit");
        scan.nextLine();
        String searchTitle = scan.nextLine();

        System.out.println("Enter new title: ");
        String newTitle = scan.nextLine();

        System.out.println("Enter new director: ");
        String newDirector = scan.nextLine();

        System.out.println("Enter new creation year: ");
        int newYear = validateInt();

        System.out.println("Is the movie in color? (yes/no): ");
        scan.nextLine();
        boolean newIsInColor = validateBoolean();

        System.out.println("Enter new length in minutes: ");
        int newLength = validateInt();


        System.out.println("Enter new genre: ");
        scan.nextLine();
        String newGenre = scan.nextLine();

        // Redigerer filmen via controlleren
        boolean success = controller.editMovie(searchTitle, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
        if (success) {
            System.out.println("Movie updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    private void displayMenu() {
        System.out.println();
        System.out.println(newLine());
        System.out.println("1. Create movie entry");
        System.out.println("2. See movie list");
        System.out.println("3. Search movie, by title");
        System.out.println("4. Edit movie by searching after title");
        System.out.println("5. Delete movie from list");
        System.out.println("6. Save movies");
        System.out.println("7. Load movies");
        System.out.println("8. Sort Movies");
        System.out.println("9. Sort Movies By Primary And Secondary Search Criteria");
        System.out.println("10. Exit");
        System.out.println(newLine());
    }

    private int validateInt() {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value.");
                scan.nextLine(); // Remove the next line
            }
        }
    }

    private boolean validateBoolean(){
        while (true){
            try{
                String userResponse = scan.nextLine();
                if (userResponse.equalsIgnoreCase("yes")){
                    return true;
                } else if (userResponse.equalsIgnoreCase("no")){
                    return false;
                } else {
                    System.out.println("Please enter yes/no");
                }
            }
            catch (Exception e){
                System.out.println("An error has occured: " + e.getMessage());
                scan.nextLine();
            }
        }
    }


    // Validerer første primary attribute til sorting
    private String validateAttributeFirst() {
        scan.nextLine(); // next line bug
        String userAttribute = scan.nextLine();
        boolean running = true;
        while (running) {
            if (!userAttribute.equalsIgnoreCase("genre") && !userAttribute.equalsIgnoreCase("director") && !userAttribute.equalsIgnoreCase("title") && !userAttribute.equalsIgnoreCase("year") &&
                    !userAttribute.equalsIgnoreCase("length")) {
                System.out.println("Please enter a valid primary-sorting-attribute");
                userAttribute = scan.nextLine();
            }else {
                return userAttribute;
            }
        }
        System.out.println("Primary criteria recieved");
        return userAttribute;
    }

    // Validerer første secondary attribute til sorting
    private String validateAttributeSecond() {
        String userAttribute = scan.nextLine();
        boolean running = true;
        while (running) {
            if (!userAttribute.equalsIgnoreCase("genre") && !userAttribute.equalsIgnoreCase("director") && !userAttribute.equalsIgnoreCase("title") && !userAttribute.equalsIgnoreCase("year") &&
                    !userAttribute.equalsIgnoreCase("length")) {
                System.out.println("Please enter a valid secondary-sorting-attribute");
                userAttribute = scan.nextLine();
            }else {
                return userAttribute;
            }
        }
        System.out.println("Secondary criteria recieved");
        return userAttribute;
    }




    public String createMovie(String user){
        System.out.println("Enter Title:");
        String userTitle = scan.nextLine();

        System.out.println("Enter a director");
        String userDirector = scan.nextLine();

        System.out.println("Enter the year the movie was made: ");
        int movieYear = validateInt();

        System.out.println("Is the movie colored?");
        scan.nextLine();
        boolean userColor = validateBoolean();

        System.out.println("Enter how long the movies is in minutes");
        int movieLength = validateInt();

        System.out.println("Enter the movie's genre: ");
        scan.nextLine();
        String movieGenre = scan.nextLine();

        Movie userMovie = new Movie(userTitle, userDirector, movieYear, userColor, movieLength, movieGenre);

        controller.addMovie1(userMovie);
        System.out.println("Your movie " + userMovie.getTitle() + "has been added to the collection!");
        return null;
    }


    public String newLine(){
        return "------------------------------------------------------------";
    }
}








