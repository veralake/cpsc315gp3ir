package controllers;

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

    public void analyzeQuery(String query)
    {
        
    }

    
}
