import java.util.ArrayList;
import java.util.List;

public abstract class Db<T>{
    final private List<T> data = new ArrayList<>();
    final private FileHandler<T> fileHandler;

    abstract public T read(String line);
    abstract public void print();
    abstract public String write(T obj);

    public Db(String fileName){
        this.fileHandler = new FileHandler<T>(fileName){
            @Override
            public T buildObject(String line) {
                return read(line);
            }
            @Override
            public String buildString(T data) {
                return write(data);
            }
        };
    };

    public void connectDb(){
        fileHandler.readFile(data);
    }

    public void writeDb(){
        fileHandler.writeFile(data);
    }
    
    public List<T> getData(){
        return data;
    }

    public void add(T newObj){
        data.add(newObj);
        this.writeDb();
    };

    public void delete(T obj){
        data.remove(obj);
    }

}
