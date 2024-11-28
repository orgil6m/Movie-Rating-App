public final class Movie extends Model<Movie> {
    private String title;
    private String releasedYear;
    private double rating;

    public Movie(String arg) {
        this.parse(arg);
    }

    public Movie(String title, String year) {
        this.title = title;
        this.releasedYear = year;
        this.rating = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public String getReleasedYear() {
        return this.releasedYear;
    }

    @Override
    public void parse(String line) {
        String[] tokens = line.split("_");
        this.id = Integer.parseInt(tokens[0]);
        this.title = tokens[1];
        this.releasedYear = tokens[2];
        // this.rating = Double.parseDouble(tokens[3]);
    }

    @Override
    public void print() {
        System.out.println("   id: " + this.id);
        System.out.println("   Title: " + this.title);
        System.out.println("   Released Year: " + this.releasedYear);
        System.out.println("   Rating: " + this.rating);
        System.out.println("-----------------------------");
    }

    @Override
    public String buildString() {
        return this.id +"_"+ this.title +"_"+ this.releasedYear;
    }
}
