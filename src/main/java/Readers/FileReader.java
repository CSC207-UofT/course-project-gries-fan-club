package Readers;
import ReaderInterface.ReaderImpl;

public class FileReader implements ReaderImpl {
    String data;

    /**
     * Reads data of a file in the form of a string
     * @param data      Contains a string of data for the FileReader to read
     **/
    public FileReader(String data) {
        this.data = data;
    }


}
