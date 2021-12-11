package Scorers;

public interface Scorer {
    /**
     * Returns a match score based on the composite score of a number of matchers.
     * @param recipe to score
     * @return match score
     */
    double score(Recipe recipe);
}
