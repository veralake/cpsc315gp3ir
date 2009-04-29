/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.ArrayList;

/**
 * <b>DocumentRanker</b>
 *
 * <p>This class implements the tf-idf algorthm for search result analysis</p>
 */
public class DocumentRanker
{
    /**
     * Default Constructor
     */
    public DocumentRanker(final IndexMap map)
    {
        mMap = map;
    }

    /**
     * Runs the tf-idf ranking algorithm for a given query (i.e. list of words)
     * @param words - the keywords from a query
     * @return - <code>ArrayList</code> of ranked documents 
     */
    public ArrayList<Document> generateResults(ArrayList<String> words)
    {
        return new ArrayList<Document>();
    }
    
    private double tfidfWeight()
    {
    	return 0;
    }
    
    private double termWeight()
    {
    	return 0;
    }

    private final IndexMap mMap;
}
