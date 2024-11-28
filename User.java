
public final class User extends Model<User>{    
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String arg) {
        this.parse(arg);
    }
    
    public boolean isValidUser(User user){
        String u = user.getUsername();
        String p = user.getPassword();
        return username.equals(u) && password.equals(p);
    }

    @Override
    public void print(){
        System.out.println(id+": " + username);
    }

    @Override
    public void parse(String line) {
        String[] tokens = line.split(",") ;
        this.id = Integer.parseInt(tokens[0]);
        this.username = tokens[1];
        this.password = tokens[2];
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    @Override
    public String buildString() {
        return this.id + ","+this.username+","+this.password;
    }
}
