package Scorers;

public interface Scorer {
    /**
     * Returns a match score based on the composite score of a number of matchers.
     * Currently, only score for TagMatcher and NameMatcher
     * @return match score
     */
    double score ();
}
