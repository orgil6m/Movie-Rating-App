import java.util.List;

public class MoviesScreen extends Screen{
    Movies movies = new Movies();

    public MoviesScreen(){
        String[] myNavs = {"Movies List", "Search movie", "Add Movie", "Edit Movie", "Delete Movie", "Go Back"};
        this.navs = myNavs;
    }

    @Override
    public void navigate(int navIndex){
        switch (navIndex) {
            case 1 -> movies.print();
            case 2 -> {
                clearScreen();
                line();
                scanner.nextLine();
                System.out.print("Enter query: ");
                String query = scanner.nextLine();
                List<Movie> result = movies.search(query);
                line();
                if(result.isEmpty()){ 
                    System.out.println("No results");
                } else{
                    System.out.println("Results (" + result.size() +") :");
                    for(Movie row: result) row.print();
                }
            }
            case 3 -> {
                clearScreen();
                line();
                scanner.nextLine();
                System.out.print("Enter movie title: ");
                String title = scanner.nextLine();
                System.out.print("Enter movie released year: ");
                String year = scanner.nextLine();
                Movie newMovie = new Movie(title, year);
                movies.add(newMovie);
            }
            case 4 -> System.out.println("Edit Movie");
            case 5 -> System.out.println("Delete Movie");
            case 6 -> { 
                this.isRunning = false;
            }
        }
    }

}
