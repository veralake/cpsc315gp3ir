package controllers;

import textProcessing.QueryProcessor;

/**
 * <b>DataController</b>
 *
 * <p>The DataController is responsible for analyzing and shuffling queries from
 * the UI to text processing, to document searching, and to the UI again.
 */
public class DataController 
{
    // Thread-safe, static instance of controller
	private static class Holder
	{
		private static DataController mInstance = new DataController();
	}

    // Private constructor
	private DataController()
	{
	}

    /**
     * Call for singleton to gain access to the methods inside the DataController
     * @return Instance of the controller.
     */
	public static DataController getInstance()
	{
		return Holder.mInstance;
	}

    /**
     * Call in response to a user event to start a search.
     * @param query - Original query to be processed
     */
    public void analyzeQuery(String query)
    {
        // Use queryAnalyzer to genera
    }

    private QueryProcessor queryAnalyzer = new QueryProcessor();
}
