package Controllers;

import Entities.Serializers.IngredientSerializer;
import Loaders.Implementations.JSONFileIO;
import Loaders.Row;
import Loaders.RowWriter;
import Storages.IngredientStorage;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Collection;

public class WritingController {

    public void saveIngredients(IngredientStorage ingredientStorage, String filePath) throws Exception {
        // create writer
        Writer writer = new FileWriter(filePath);

        // serialize rows
        IngredientSerializer serializer = new IngredientSerializer();
        Collection<Row> serializedData = serializer.serializeAll(ingredientStorage);

        // save
        RowWriter loader = new JSONFileIO();
        loader.save(serializedData, writer);
        writer.close();
    }
}
