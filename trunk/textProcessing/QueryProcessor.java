package textProcessing;

import java.util.ArrayList;
import java.util.List;
import project3.WordTokenizer;

// TODO Test the QueryProcessor as a single unit

/**
 * <b>QueryProcessor</b>
 * 
 * <p>This class takes a query and formats it into a list of terms that
 * are appropriate for searching text documents.</p> 
 */
public class QueryProcessor implements WordTokenizer 
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
	@Override
	public ArrayList<String> tokenize(String query)
	{
		List<String> tokens = mTokenizer.tokenize(query);
	
        ArrayList<String> indexWords = mStopFilter.filterWords(tokens);
		
		//indexWords = mWordStemmer.stems(indexWords);
		
		return indexWords;
	}
	public String stem(String word)
	{
		return mWordStemmer.stem(word);
	}
	private Tokenizer mTokenizer = new Tokenizer();
	private StopWordFilter mStopFilter = new StopWordFilter();
	private StemFilter mWordStemmer = new StemFilter();
}
