/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.ArrayList;
import java.util.Collections;
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
    	
    	ArrayList<Document> rankedDocs = new ArrayList<Document>();
    	
    	// Compute the rank for the document.  
    	// Documents with the lowest ranks are the best matches.
    	for (Document d : relevantDocs)
    	{
    		ArrayList<Double> docVector = getDocVector(d, 
    												   mMap.getStems());
    		
    		Document ranked = new Document(d);
    		
    		ranked.setRank(computeRank(termVector, 
    								   docVector));
    		
    		rankedDocs.add(ranked);
    	}
    	
//    	Collections.sort
    	
        return rankedDocs;
    }
    
    /**
     * Returns all documents that have been indexed
     * @return <code>ArrayList&ltDocument&gt</code> containing all indexed
     * <code>Document</code> objects
     */
    public ArrayList<Document> returnAllDocuments()
    {
    	return retrieveRelevantDocs(mMap.getStems());
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
    		String docName = si.getDocument().getName();
    		// If the doc map does not have a document name for this instance
    		if (!docMap.keySet().contains(docName))
    		{
    			Document d = new Document(docName);
    			d.setPath(si.getDocument().getAbsolutePath());
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
    private ArrayList<Double> getDocVector(final Document doc,
    									   final ArrayList<String> indexes)
    {
    	ArrayList<Double> docVector = new ArrayList<Double>();
    	
    	int maxDocFrequency = maxIndexDocFrequency(indexes, doc);
    	
//    	for 
    	
    	return new ArrayList<Double>();
    }

    // Computes the weight vector for a query
    private ArrayList<Double> getTermVector(final ArrayList<String> words,
    										final ArrayList<String> indexes,
    										int totalDocs)
    {
    	ArrayList<Double> termVector = new ArrayList<Double>();
    	
    	int maxItFrequency = maxIndexQueryFrequence(indexes, 
    											    words);
    	
    	for (String index : indexes)
    	{
    		termVector.add(computeTermWeight(totalDocs, 
    										 maxItFrequency,
    										 index,
    										 words));
    	}
    	
    	return termVector;
    }
    
    // Computes a single element of a document vector
    private Double computeIndexWeight(final int totalDocs,
    								  final int maxDocFrequency,
    								  final String index,
    								  final Document doc)
    {
    	double tf = 0;
    	if (0 != maxDocFrequency)
    	{
    		tf = (double)indexDocFrequency(index, doc) / maxDocFrequency;
    	}
    	
    	double idf = 0;
    	
    	if (mMap.getStemDocumentCount(index) != 0)
    	{
    		idf = (double)totalDocs / mMap.getStemDocumentCount(index);
    	}
    	
    	double w = tf * idf;
    	
    	return new Double(0);
    }
    
    // Computes a single element of a query vector
    private Double computeTermWeight(int totalDocs,
    								 int maxIndexFreq,
    								 String index,
    								 final ArrayList<String> words)
    {
		double termFrequency = 0; 
		
		if (0 != maxIndexFreq)
		{
			termFrequency = indexQueryFrequency(index, words) / maxIndexFreq;
		}
		else
		{
			termFrequency = indexQueryFrequency(index, words);
		}
		
		if (totalDocs == 0)
		{
			totalDocs = 1;
		}
		
		int stemDocCount = 0;
		
		if ((stemDocCount = mMap.getStemDocumentCount(index)) == 0)
		{
			stemDocCount = totalDocs;
		}
    	
    	double w = 0.5 + (0.5 * termFrequency) * Math.log((double)totalDocs/stemDocCount);
    	
    	return new Double(w);
    }
    
    // Returns the max frequency of any index term in the query
    private int maxIndexQueryFrequence(final ArrayList<String> indexes,
    								   final ArrayList<String> query)
    {
    	ArrayList<Integer> frequencies = new ArrayList<Integer>();
    	
    	for (String word : indexes)
    	{
    		frequencies.add(new Integer(indexQueryFrequency(word, query)));
    	}
    	
    	// Sorts the collection such that the largest is at the end.
    	Collections.sort(frequencies);
    	
    	return frequencies.get(frequencies.size() - 1).intValue();
    }
    
    
    // This computes the frequency of an index term in a query
    private int indexQueryFrequency(final String index, 
    							    final ArrayList<String> query)
    {
    	int count = 0;
    	
    	if (index != null && query != null)
    	{
	    	for (String word : query)
	    	{
	    		if (word.equals(index))
	    		{
	    			++count;
	    		}
	    	}
    	}
    	
    	return count;
    }
    

    // Returns the frequency of a term in a document
    private int indexDocFrequency(final String index,
    							  final Document doc)
    {
    	int count = 0;
    	
    	if (index != null && doc != null)
    	{
    		count = doc.getInstances(index).size();
    	}
    	
    	return count;
    }
    
    // Returns the max frequency of all the index terms for the given document
    private int maxIndexDocFrequency(final ArrayList<String> indexes,
    								 final Document doc)
    {
    	ArrayList<Integer> frequencies = new ArrayList<Integer>();
    	
    	for (String index : indexes)
    	{
    		frequencies.add(new Integer(indexDocFrequency(index, doc)));
    	}
    	
    	Collections.sort(frequencies);
    	
    	return frequencies.get(frequencies.size() - 1);
    }

    private final IndexMap mMap;
}
