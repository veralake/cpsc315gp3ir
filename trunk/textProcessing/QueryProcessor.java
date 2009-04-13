package textProcessing;

import java.util.ArrayList;
import java.util.List;
import project3.WordTokenizer;

/**
 * <b>QueryProcessor</b>
 * 
 *  <p>This class takes a query and formats it into a list of terms that
 *  are appropriate for searching text documents.</p> 
 */
public class QueryProcessor implements WordTokenizer 
{
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
	public List<String> tokenize(String query) 
	{
		List<String> indexWords = new ArrayList<String>();
	
		
		
		// Continue making passes on our words until we have index words
		
		return indexWords;
	}
	
	private Tokenizer tokenizer = new Tokenizer();
	private StopWordFilter stopFilter = new StopWordFilter();
	private StemFilter wordStemmer = new StemFilter();
}
