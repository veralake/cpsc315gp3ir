package textProcessing;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a list of words to eliminate from a token list.
 */
public class StopWordFilter
{
	/**
	 * Constructor - Initialize list of stop-words
	 */
	public StopWordFilter()
	{
		// Connect/initialize list
	}
	
	/**
	 * Takes a list of tokens and eliminates words too common to search on
	 * @param query - A list of strings that comprises a query from the user
	 * @return A <code>List</code> of strings that is a subset of the original query but
	 * without stop words
	 */
	public List<String> filterWords(final List<String> query)
	{
		return new ArrayList<String>();
	}
}
