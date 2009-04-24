package textProcessing;

import java.util.ArrayList;
import java.util.List;

import project3.WordTokenizer;

/**
 * <b>Tokenizer</b>
 * <p>Handles breaking the original query into a list of tokens that are void of 
 * negligible punctuation</p>
 */
public class Tokenizer implements WordTokenizer 
{
    /**
     * Default constructor
     */
	public Tokenizer()
	{
	}

	/**
	 * Tokenizes a string and eliminates erroneous punctuation.
	 * @param bodyOfText - String to be tokenized
	 * @return a <code>List</code> of strings representing tokens
	 */
	@Override
	public List<String> tokenize(String bodyOfText) 
	{
		String[] words = tokenizeQuery(bodyOfText);

        String[] trimmedWords = removePunctuation(words);
		
		return makeWordList(trimmedWords);
	}

	// Splits the original query into whole-grain, bite-sized tokens covered in frosting
	private String[] tokenizeQuery(final String query)
	{
		String[] words = null;
		
		// if hasQuotesOperator(a query) equals true
        //     call String.split on quotes, set equal to words
        // else
        //     call split on spaces (default), set equal to words
		
		return words;
	}

    private String[] removePunctuation(final String[] words)
    {
        return new String[5];
    }

    private boolean hasQuotesOperator(final String query)
    {
        // Any query that contains a chunk of text surrounded by
        // double quotes should be treated unconditionally as a
        // single token.

        // if contains "...stuff..."
        //     split on quotes
        // else
        //     call split on spaces

        return false;
    }

    private ArrayList<String> makeWordList(final String[] words)
    {
        ArrayList<String> list = new ArrayList<String>();

        for (String s : words)
        {
            list.add(s);
        }

        return list;
    }
}
