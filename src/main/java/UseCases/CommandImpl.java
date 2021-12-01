package UseCases;

import java.util.HashMap;

/**
 * {
 *     "Fridge": "apple,carrot,milk,cookies"
 *     "Tags": "Gluten, Dairy"
 *     "addToFridge": "Apple, Milk"
 *
 *
 * }
 */
public class CommandImpl extends HashMap<String, String> implements Command {
}
