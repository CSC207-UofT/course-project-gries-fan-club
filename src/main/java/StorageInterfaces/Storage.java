package StorageInterfaces;

import java.util.Map;

public interface Storage {

    /**
     * This type determines what data is accepted / rejected from loaders.
     *
     * @return The type of entity this storage contains.
     */
    String type();

    boolean loadEntity(Map<String, ?> row);

}
