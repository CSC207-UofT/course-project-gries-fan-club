package Loaders;

import LoaderInterfaces.Loader;

public class FileLoader implements Loader {
    String data;

    public FileLoader(String data) {
        this.data = data;
    }

}
