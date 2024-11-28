public class RatingsScreen extends Screen{
    Ratings ratings = new Ratings();

    public RatingsScreen(){
        String[] myNavs = {"Ratings List", "Add Rating", "Edit Rating", "Delete Rating", "Go Back"};
        this.navs = myNavs;
    }

    @Override
    public void navigate(int navIndex) {
        switch (navIndex) {
            case 1 -> ratings.print();
            case 2 -> System.out.println("Add Rating");
            case 3 -> System.out.println("Edit Rating");
            case 4 -> System.out.println("Delete Rating");
            case 5 -> this.isRunning = false;
        }
    }
}
