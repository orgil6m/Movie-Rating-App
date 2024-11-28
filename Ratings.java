import java.util.List;

public class Ratings extends Db<Rating>{
    private final List<Rating> data;

    public Ratings(){
        super("db/ratings.txt");
        this.connectDb();
        this.data = this.getData();
    }

    

    @Override
    public Rating read(String line) {
        return new Rating(line);
    }

    @Override
    public void print() {
        for(Rating row: data){
            row.print();
        }
    }


    @Override
    public String write(Rating obj) {
        return "";
    }
    
}
