package textProcessing;

import java.util.ArrayList;
import java.util.List;

// TODO Test the QueryProcessor as a single unit

/**
 * <b>QueryProcessor</b>
 * 
 * <p>This class takes a query and formats it into a list of terms that
 * are appropriate for searching text documents.</p> 
 */
public class QueryProcessor
{
	/**
	 * Default constructor
	 */
	public QueryProcessor()
	{
	}

	/**
	 * Processes a user query via stemming, eliminating stop words, etc... and 
	 * returns a concise basis (set of index words) upon which to search textual media.
	 * @param query - The user's original query
	 * @return A <code>List</code> of index words for searching text documents
	 */
	public ArrayList<String> tokenize(String query, boolean stem)
	{
		List<String> tokens = mTokenizer.tokenize(query);
	
        ArrayList<String> indexWords = mStopFilter.filterWords(tokens);
		if(stem)indexWords = mWordStemmer.stems(indexWords);
		
		return indexWords;
	}
	
	/**
	 * method to return the 
	 * @param word String 
	 * @return the stem of word
	 * @author Andrew Johnson
	 */
	public String stem(String word)
	{
		return mWordStemmer.stem(word);
	}
	private Tokenizer mTokenizer = new Tokenizer();
	private StopWordFilter mStopFilter = new StopWordFilter();
	private StemFilter mWordStemmer = new StemFilter();
}
