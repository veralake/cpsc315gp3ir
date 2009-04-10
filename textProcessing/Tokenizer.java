package textProcessing;

import java.util.List;

import project3.WordTokenizer;

/**
 * <b>Tokenizer</b>
 * <p>Handles breaking the original query into a list of tokens that are void of 
 * negligible punctuation</p>
 */
public class Tokenizer implements WordTokenizer 
{
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
		String[] queryWords = tokenizeQuery(bodyOfText);

		
		return null;
	}

	// Splits the original query into whole-grain, bite-sized tokens covered in frosting
	private String[] tokenizeQuery(final String query)
	{
		String[] words = null;
		
		// Call String.split();
		
		return words;
	}

}
