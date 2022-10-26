import java.io.File;
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
        System.out.println("Fisierul a fost creeat");
    }

    public static FileSingleton getInstance() {
        if (instance == null) {
            instance = new FileSingleton();
        }
        return instance;
    }

}

