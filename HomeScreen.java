public class HomeScreen extends Screen{
    public HomeScreen(){
        String[] myNavs = {"Movies","Ratings", "Exit"};
        this.navs = myNavs;
    }
    
    @Override
    public void navigate(int navIndex){
        switch (navIndex) {
            case 1->{
                    MoviesScreen moviesScreen = new MoviesScreen();
                    moviesScreen.renderNavs();
                }
            case 2->{
                    RatingsScreen ratingsScreen = new RatingsScreen();
                    ratingsScreen.renderNavs();
            }
            case 3 -> this.isRunning = false;
            default -> System.out.println("Please enter valid input");
        }
    }

}
