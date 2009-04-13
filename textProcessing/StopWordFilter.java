package textProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * <b>StopWordFilter</b>
 * <p>Represents a list of words to eliminate from a token list.</p>
 */
public class StopWordFilter
{
	/**
	 * Constructor - Initialize list of stop-words
	 */
	public StopWordFilter()
	{
		mStopList = new ArrayList<String>();
		initList(mStopList);
		sortList(mStopList);
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
	
	private void initList(ArrayList<String> stopList)
	{
		// Find file and read it in
	}
	
	// Sort the list after reading in.  In case someone gets mischievous with the stop list.
	private boolean sortList(ArrayList<String> stopList)
	{
		boolean bSorted = false;
		
		if (mStopList != null && !mStopList.isEmpty())
		{
			Collections.sort(stopList);
			bSorted = true;
		}
		
		return bSorted;
	}
	
	private ArrayList<String> mStopList;
}
