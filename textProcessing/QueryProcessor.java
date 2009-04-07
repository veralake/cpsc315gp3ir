package textProcessing;

import java.util.List;
import project3.WordTokenizer;

/**
 *  This class takes a query and formats it into a list of terms that
 *  are appropriate for searching text documents. 
 */
public class QueryProcessor implements WordTokenizer 
{
	public QueryProcessor()
	{
		
	}

	@Override
	public List<String> tokenize(String bodyOfText) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private StopWordFilter stopFilter = new StopWordFilter();
	private StemFilter wordStemmer = new StemFilter();
}
