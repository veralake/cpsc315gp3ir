/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.io.File;

import textProcessing.QueryProcessor;

/**
 * <b>IndexBuilder</b>
 * 
 * <p>Builds an <code>IndexMap</code> given a working directory. This class will
 * contain the inverted index algorithm</p>
 * @author Zachary Edens
 */
public class IndexBuilder
{
	/**
	 * Constructor to instantiate the IndexBuilder with a directory
	 * in which to search for files.
	 * @param directory - directory in which to search
	 * @param processor - a processor for applying the stemming algorithm to document samples
	 */
    public IndexBuilder(File directory, 
    					QueryProcessor processor)
    {
    	mMainDirectory = directory;
    	mLineProcessor = processor;
    }
    
    /**
     * Generates an data structure containing the index words for the documents in
     * <code>mMainDirectory</code>.  To be called by the DataController shortly after start-up.
     * @return - <code>IndexMap</code> of index terms
     */
    public IndexMap createIndexMap()
    {
    	return new IndexMap();
    }
    
    private File mMainDirectory;
    private QueryProcessor mLineProcessor;
}
