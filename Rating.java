
import java.util.Objects;

public final class Rating extends Model<Rating> {

    private int movieId;
    private int userId;
    private double rating;

    private Movie movie;
    private User user;

    public Rating(String arg) {
        this.parse(arg);
        this.getUser();
        this.getMovie();
    }

    @Override
    public void parse(String line) {
        String[] tokens = line.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.movieId = Integer.parseInt(tokens[1]);
        this.userId = Integer.parseInt(tokens[2]);
        this.rating = Double.parseDouble(tokens[3]);
    }

    public void getUser() {
        Users users = new Users();
        System.out.println("getting user with id " + id);
        this.user = users.getUserById(this.userId);

    }

    public void getMovie() {
        Movies movies = new Movies();
        this.movie = movies.getMovieById(this.movieId);
    }

    @Override
    public void print() {
        if (Objects.nonNull(this.user) && Objects.nonNull(this.movie)) {
            String username = this.user.getUsername();
            String movieTitle = this.movie.getTitle();
            System.out.println("User: " + username);
            System.out.println("Movie:" + movieTitle);
            System.out.println("Rating:" + this.rating);
            System.out.println("-----------------------------------");
        }
    }

    @Override
    public String buildString() {
        return this.id + "," + this.movieId + "," + this.userId + "," + this.rating;
    }
}
