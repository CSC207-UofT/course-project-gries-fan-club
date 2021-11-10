package Matchers.Implementations;

import Entities.Recipe;
import Entities.RecipeItem;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.lang.String;

import java.util.List;

public class NameMatcher { //Non-regex representation
    String[] names;

    public NameMatcher(List<String> names) {
        this.names = ;
        this.regexPhrases =
    }

    /**
     * Checks if a list of ingredients contains all of the ingredients that a recipe needs
     * @param recipe is the recipe to check
     * @return whether or not the recipe has all of the required ingredients
     */
    @Override
    public boolean matches(Recipe recipe) {

        if (!this.ingredients.contains(recipeItem.ingredient()))
                return false;
        return true;
    }

    private List<Pattern> regexPhraseMaker (List<String> regexPhrases) {
        ArrayList<Pattern> regexPhrases = new ArrayList<>();
        for (String name : names)
            regexPhrases.add(Pattern.compile(name));
        return regexPhrases;
    }
}
