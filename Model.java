public abstract class Model<T> {
    public int id;
    public abstract void parse(String line);
    public abstract String buildString();
    public abstract void print();
    
    public Model<T> getObjectById(int id){
        if(this.id == id){ 
            return null;
        } else return null;
    }

}
