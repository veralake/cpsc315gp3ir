/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.ArrayList;
import java.util.TreeMap;

import project3.StemInfo;
import project3.StemInfo.StemInstance;

// TODO Move vector functions to a static class, probably in a linear algebrish package

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
    	ArrayList<Document> relevantDocs = retrieveRelevantDocs(words);
    	
    	// Compute Additional parameters
    	int totalDocs = relevantDocs.size();

    	ArrayList<String> indexes = mMap.getStems();
    	    	
    	// Calculate query term vector
    	ArrayList<Double> termVector = getTermVector(words,
    												 indexes,
    												 totalDocs);
//    	
//    	ArrayList<Document> rankedDocs = new ArrayList<Document>();
//    	
//    	for (Document d : relevantDocs)
//    	{
//    		
//    	}
    	
    	// for each document doc in LD 
    	// {
    	// 	   compute dot_product(doc.vector, query_terms.vector)
    	// 	   Create document (which includes assigning rank
    	// 	   insert document into list rankedLD
    	// }
    	// return rankedLD
    	
        return relevantDocs;//rankedDocs;
    }
    
    // Retrieves all documents where each document contains at least one of the term words
    private ArrayList<Document> retrieveRelevantDocs(final ArrayList<String> words)
    {
    	ArrayList<StemInfo> stems = getStemInfos(words);
    	
    	ArrayList<StemInstance> instances = createStemInstanceList(stems);
    	
    	return createDocumentList(instances);
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
    
    // Creates mapping from stem instances to documents
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
    
    // Computes the angle between a term and document vector, i.e. the rank of the document
    private double computeRank(final ArrayList<Double> termVector,
    						   final ArrayList<Double> docVector)
    {
    	return Math.acos((dotProduct(termVector, 
    								 docVector)) / (magnitude(termVector) * magnitude(docVector)));
    }
    
    // Computes the magnitude of a vector v
    private double magnitude(final ArrayList<Double> v)
    {
    	return Math.sqrt(dotProduct(v, v));
    }
    
    // Computes the dot product of two vectors
    private double dotProduct(final ArrayList<Double> v1, 
    						  final ArrayList<Double> v2)
    {
    	double scalar = 0;
    	
    	if (v1.size() == v2.size())
    	{
    		int size = v1.size();
    		
    		for (int i = 0; i < size; ++i)
    		{
    			scalar = scalar + v1.get(i).doubleValue() + v2.get(i).doubleValue();
    		}
    	}
    	
    	return scalar;
    }
    
    // Computes the weight vector for a document
    private ArrayList<Double> getDocVector(final Document doc)
    {
    	return new ArrayList<Double>();
    }

    // Computes the weight vector for a query
    private ArrayList<Double> getTermVector(final ArrayList<String> words,
    										final ArrayList<String> indexes,
    										int totalDocs)
    {
    	ArrayList<Double> termVector = new ArrayList<Double>();
    	
    	for (String index : indexes)
    	{
    		
    	}
    	
    	return termVector;
    }
    
    // Computes a single element of a document vector
    private Double computeIndexWeight()
    {
    	double w = 0;
    	
    	return new Double(0);
    }
    
    // Computes a single element of a query vector
    private Double computeTermWeight(int totalDocs,
    								 String index,
    								 final ArrayList<String> words)
    {
    	
    	double w = (0.5 + ((0.5 * 1) / 1)) * Math.log(totalDocs/mMap.getStemDocumentCount(index));
    	
    	return new Double(w);
    }
    
    // write functions for index frequence

    private final IndexMap mMap;
}
