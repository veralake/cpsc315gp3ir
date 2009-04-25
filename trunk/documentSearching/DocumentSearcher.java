package documentSearching;


import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <b>DocumentReader</b>
 * 
 * <p>This class scans a given <code>IndexMap</code> for instances 
 * of terms from a query.</p>
 */
public class DocumentSearcher
{
	/**
	 * Creates an instance of a <code>DocumentSearcher</code>
	 * @param terms - A map of the primary index terms
	 */
    public DocumentSearcher()
    {
    }
	
    /**
     * Returns a set of documents that ranked highest given <code>indexTerms</code>
     * @param indexTerms - Terms from a user query
     * @return <code>Set</code> of documents that best fit the given index terms
     */
    public Set<Document> getResults(final List<String> indexTerms, 
    								final IndexMap terms)
    {
        return null;
    }
}
