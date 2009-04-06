/*
 * WordStemmer.java
 */

package project3;

/**
 * Implemented by classes that can find the stem of an English word.
 */
public interface WordStemmer
{
    
    /**
     * Finds the stem of a specified <code>word</code>.
     * @param word a single English word
     * @return the step of <code>word</code>
     */
    public String stem(String word);
}