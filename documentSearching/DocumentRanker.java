/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.ArrayList;
import java.util.TreeMap;

import project3.StemInfo;
import project3.StemInfo.StemInstance;

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
    public ArrayList<Document> generateResults(final ArrayList<String> words)
    {
    	// Get list of documents LD where each doc contains at least one of the query terms
    	ArrayList<Document> releventDocs = retrieveRelevantDocs(words);
    	
    	// Calculate query term vector
    	
    	// for each document doc in LD 
    	// {
    	// 	   compute dot_product(doc.vector, query_terms.vector)
    	// 	   Create document (which includes assigning rank
    	// 	   insert document into list rankedLD
    	// }
    	// return rankedLD
    	
        return new ArrayList<Document>();
    }
    
    // Retrieves all documents where each document contains at least one of the term words
    private ArrayList<Document> retrieveRelevantDocs(final ArrayList<String> words)
    {
    	ArrayList<StemInfo> stems = getStemInfos(words);
    	
    	ArrayList<StemInstance> instances = createStemInstanceList(stems);
    	
    	return createDocumentList(instances); //createDocumentList(stems);
    }
    
    // Maps terms to StemInfo's
    private ArrayList<StemInfo> getStemInfos(final ArrayList<String> words)
    {
    	ArrayList<StemInfo> stems = new ArrayList<StemInfo>();
    	
    	for (String word : words)
    	{
    		if(mMap.hasStemInfo(word))
    		{
    			stems.add(mMap.getStemInfo(word));
    		}
    	}

    	return stems;
    }
    
    // Creates a mapping from Stem to stem instances
    private ArrayList<StemInstance> createStemInstanceList(final ArrayList<StemInfo> stems)
    {
    	ArrayList<StemInstance> instances = new ArrayList<StemInstance>();
    	
    	for (StemInfo si : stems)
    	{
    		instances.addAll(si.getInstances());
    	}
    	
    	return instances;
    }
    
    private ArrayList<Document> createDocumentList(final ArrayList<StemInstance> instances)
    {
    	TreeMap<String, Document> docMap = new TreeMap<String, Document>();
    	
    	for (StemInstance si : instances)
    	{
    		String docName = si.getDocument().getAbsolutePath();
    		// If the doc map does not have a document name for this instance
    		if (!docMap.keySet().contains(docName))
    		{
    			Document d = new Document(docName);
    			d.addInstance(si);
    			docMap.put(docName, d);
    		}
    		else
    		{
    			docMap.get(docName).addInstance(si);
    		}
    	}
    	
    	return new ArrayList<Document>(docMap.values());
    }
    
    // Computes the weight vector for a document
    private ArrayList<Double> getDocVector(final Document doc)
    {
    	return new ArrayList<Double>();
    }

    // Computes the weight vector for a query
    private ArrayList<Double> getTermVector(final ArrayList<String> words)
    {
    	return new ArrayList<Double>();
    }
    
    // Computes a single element of a document vector
    private Double computeIndexWeight()
    {
    	return new Double(0);
    }
    
    // Computes a single element of a query
    private Double computeTermWeight()
    {
    	return new Double(0);
    }

    private final IndexMap mMap;
}
