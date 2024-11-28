import java.util.List;

public class Users extends Db<User>{
    private final List<User> data;

    public Users(){
        super("db/users.txt");
        this.connectDb();
        this.data = this.getData();
    }

    
    @Override
    public User read(String line) {
        return new User(line);
    }

    @Override
    public void print() {
        for(User row: this.getData()){
            row.print();
        }
    }

    public boolean login(User u){
        for(User user :data){
            if(user.isValidUser(u)) return true;
        }
        return false;
    }

    public User getUserById(int id){
        for(User user:data){
            System.out.println("userId:" + user.id  );
            if(user.id == id) return user;
        }
        return null;
    }


    @Override
    public String write(User obj) {
        return "";
    }
}
