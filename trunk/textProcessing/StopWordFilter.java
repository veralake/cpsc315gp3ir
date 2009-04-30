package textProcessing;

import java.io.BufferedReader;
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
		Initialize();	
	}
	
	/**
	 * Was the stop list sorted properly
	 * @return - returns true if the list was sorted during initialization
	 */
	public boolean isSorted()
	{
		return mIsSorted;
	}
	
	/**
	 * Takes a list of tokens and eliminates words too common to search on
	 * @param query - A list of strings that comprises a query from the user
	 * @return A <code>List</code> of strings that is a subset of the original query but
	 * without stop words, or null if no stop word file was present.
	 */
	public ArrayList<String> filterWords(final List<String> query)
	{
		ArrayList<String> newList = null;
		
		if (mStopList != null && 
			query != null &&
			isSorted())
		{
			newList = new ArrayList<String>();
			
			// If the word is not in the stop list, add it to the list 
			// of keywords to return.
			for (String word : query)
			{
				if (Collections.binarySearch(mStopList, word.toLowerCase()) <= -1)
				{
					newList.add(word);
				}
			}
		}
		
		return newList;
	}
	
	// Initializes the stop list and sorts the stop words read from StopList.txt
	private void Initialize()
	{
		try
		{
			mStopList = initList();
			sortList(mStopList);
		}
		catch (FileNotFoundException fnf)
		{
			mStopList = new ArrayList<String>();
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
	}

    // Reads in the StopWords.txt file that comprises of common English words
	private ArrayList<String> initList()
		throws IOException, FileNotFoundException
	{
		ArrayList<String> stopList = null;
		BufferedReader listReader = null;
		
		try 
		{
			stopList = new ArrayList<String>();
			listReader = new BufferedReader(new FileReader("StopList.txt"));
			
			String word = null;
			while((word = listReader.readLine()) != null)
			{
				stopList.add(word.trim());
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
	private void sortList(ArrayList<String> stopList)
	{
		if (mStopList != null && 
			!mStopList.isEmpty())
		{
			Collections.sort(stopList);
			mIsSorted = true;
		}
		else
		{
			mIsSorted = false;
		}
	}
	
	// Member variables
	private ArrayList<String> mStopList = null;
	private boolean mIsSorted = false;
}
