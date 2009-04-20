package textProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
	}
	
	public void Initialize()
	{
		try
		{
			mStopList = initList();
			sortList(mStopList);
			// 
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
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
	
	private ArrayList<String> initList()
		throws IOException
	{
		ArrayList<String> stopList = new ArrayList<String>();
		BufferedReader listReader = null;
		
		try 
		{
			listReader = new BufferedReader(new FileReader("StopList.txt"));
			
			String word = null;
			while((word = listReader.readLine()) == null)
			{
				stopList.add(word);
			}
		} 
		finally
		{
			if (listReader != null)
			{
				listReader.close();
			}
		}
		return stopList;
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
