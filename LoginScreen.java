public class LoginScreen extends Screen {
    int maxAttempt = 3;
    
    public void login(){
        int attempt = 0;
        line();
        
        while(attempt < maxAttempt){
            System.out.print("username: ");
            String username = scanner.nextLine();    
            System.out.print("password: " );
            String password = scanner.nextLine();
            Users users = new Users();
            User user = new  User(username, password);
            if(users.login(user)){
                HomeScreen homeScreen = new HomeScreen();
                homeScreen.renderNavs();
                return;
            } else{
                clearScreen();
                line();
                System.out.println("Wrong password! " + (maxAttempt- ++attempt) + " attempt(s) left" );
            }
        }
    }

    @Override
    public void navigate(int navIndex) {   
    }
}
