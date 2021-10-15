/**
 * Public class FileReader that implements from ReaderImpl
 **/
package Readers;
import ReaderInterface.ReaderImpl;

public class FileReader implements ReaderImpl {
    String data;

    public FileReader(String data) {
        this.data = data;
    }
    /**
     * @param data      Contains a string of data for the FileReader to read
     **/

}
