package documentSearching;


import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <b>DocumentReader</b>
 * <p>This class serves as the higher level object that scans documents for instances
 * of index terms returns the
 */
public class DocumentReader
{
    
    public Set<Document> getResults(File directory,
                                     List<String> indexTerms)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	private InvertedIndexer docIndexer = new InvertedIndexer();
    private RankAssigner rankAssigner = new RankAssigner();
    
}
