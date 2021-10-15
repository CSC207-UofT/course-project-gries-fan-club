package Readers;
import ReaderInterface.ReaderImpl;

public class FileReader implements ReaderImpl {
    String data;

    public FileReader(String data) {
        this.data = data;
    }

}
