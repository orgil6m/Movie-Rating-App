import java.util.ArrayList;
import java.util.List;

public class Movies extends Db<Movie>{
    private final List<Movie> data;

    public Movies(){
        super("db/movies.txt");
        this.connectDb();
        this.data = this.getData();
    }

    public List<Movie> search(String query){
        List<Movie> result = new ArrayList<>();
        for(Movie row: data){
            String title = row.getTitle();
            if(title.contains(query)){
                result.add(row);
            }
        }
        return result;
    }


    @Override
    public Movie read(String line) {
        return new Movie(line);
    }

    @Override
    public void print() {
        for(Movie row: data) row.print();
    }

    public Movie getMovieById(int id){
        for(Movie movie:data){
            if(movie.id == id) return movie;
        }
        return null;

    }

    @Override
    public String write(Movie obj) {
        return obj.buildString();
    }
}
