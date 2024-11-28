import java.util.Scanner;

public abstract class Screen {
    public Scanner scanner = new Scanner(System.in);
    String[] navs;
    boolean isRunning = true;

    public abstract void navigate(int navIndex);

    public void renderNavs(){
        clearScreen();
        line();
        while(isRunning){
            for (int i = 0; i < navs.length; i++) {
                System.out.println((i+1) + ". "+ navs[i]);
            }
            line();
            print("Select: ");
            int navIndex = scanner.nextInt();
            clearScreen();
            line();
            this.navigate(navIndex);
        }
    }
    

    public void print(String val){
        System.err.print(val);
    }
    
    public void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void line(){
        System.out.println("-----------------------------------");
    }



}

    
