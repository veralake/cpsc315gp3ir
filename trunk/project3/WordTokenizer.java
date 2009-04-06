/*
 * WordTokenizer.java
 */

package project3;

import java.util.List;

/**
 * Interface for classes that extract single English word tokens from bodies 
 * of ASCII text. Implementing classes differ from basic tokenizing classes, 
 * such as {@link java.util.Scanner}, because tokens cannot be separated by a
 * single delimiter or pattern. This is because English words sometimes
 * contain punctuation such as a period or hyphen, but these same punctuation
 * characters may also not be part of a word.
 */
public interface WordTokenizer
{
    /**
     * Extracts words from the text content of <code>bodyOfText</code> and 
     * returns a list consisting of all words in the order that they occur
     * in <code>bodyOfText</code>. Punctuation is removed unless it is part
     * of a word. For example, periods at the end of a sentence should be 
     * removed but a period after a commonly used abreviation (e.g. Dr. or 
     * Mrs.) should not be removed.
     * @param bodyOfText a string containing a body of ASCII text
     * @return a list of tokens (i.e. English words) in the order that they
     * appear in <code>bodyOfText</code>
     */
    public List<String> tokenize(String bodyOfText);
}