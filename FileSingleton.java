import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSingleton {
    private static FileSingleton instance;
    private static File logging;

    private FileSingleton() {
        logging = new File("test.txt");
        try {
            logging.createNewFile();
            if(logging == null) {

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("File created");
    }

    public void writeMsg(String msg) {
        try {
            FileWriter fileWriter = new FileWriter("test.txt", true);
            fileWriter.write(msg);
            fileWriter.write("\n");
            fileWriter.close();
        }
        catch (IOException ex) {
            System.out.println("Unable to write to file");
            ex.printStackTrace();
        }
    }
    public static FileSingleton getInstance() {
        if (instance == null) {
            instance = new FileSingleton();
        }
        return instance;
    }

}

