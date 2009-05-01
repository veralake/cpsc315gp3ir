package controllers;

import java.io.File;
import java.util.ArrayList;

import textProcessing.QueryProcessor;
import documentSearching.Document;
import documentSearching.DocumentRanker;
import documentSearching.IndexBuilder;
import documentSearching.IndexMap;

/**
 * <b>DataController</b>
 *
 * <p>The DataController is responsible for analyzing and shuffling queries from
 * the UI to text processing, to document searching, and to the UI again.</p>
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
    public ArrayList<Document> runQuery(String query)
    {
        // Use queryAnalyzer to generate a list of documents

        ArrayList<String> list = mQueryAnalyzer.tokenize(query,true);

        DocumentRanker rankAlgorithm = new DocumentRanker(mIndexSet);

        ArrayList<Document> documents = null;
        
        if(!list.isEmpty())
    	{
    		documents = rankAlgorithm.generateResults(list);
    	}
        else
        {
        	documents = rankAlgorithm.returnAllDocuments();
        }
        
        return documents;
    }
    
    /**
     * @return - Returns a <code>File</code> containing the current
     * directory the app is searching in
     */
    public File getSearchDirectory()
    {
    	return mWorkingDirectory;
    }
    
    /**
     * Sets the directory of files to be searched and automatically runs the indexing algorithm.
     * @param directory - name of directory containing text files that the user wants to search.
     */
    public void setSearchDirectory(File directory)
    {
    	if (directory != null &&
            mWorkingDirectory != directory)
        {
            mWorkingDirectory = directory;
            
            IndexBuilder indexer = new IndexBuilder(directory,
                                                    mQueryAnalyzer);

            mIndexSet = indexer.createIndexMap();
        }
    }

    private File mWorkingDirectory = null;
    private IndexMap mIndexSet = null;
    private QueryProcessor mQueryAnalyzer = new QueryProcessor();
}
