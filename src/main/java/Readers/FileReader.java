package main.java.Readers;
import main.java.ReaderInterface.ReaderImpl;

public class FileReader implements ReaderImpl {
    String data;

    public FileReader(String data) {
        this.data = data;
    }

}
