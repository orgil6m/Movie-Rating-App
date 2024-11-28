import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public abstract class FileHandler<T> implements DbFile<T> {
    final private String fileName;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    final public void readFile(List<T> data){
        try {
            File file = new File(fileName);
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    T obj = this.buildObject(line);
                    data.add(obj);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read file: " + fileName);
        }
    };

    final public void writeFile(List<T> data){
        try {
            try (FileWriter myWriter = new FileWriter(fileName)) {
                for(T row: data) {
                    myWriter.write(this.buildString(row) + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't write file: " + fileName);
        }
    };
}
