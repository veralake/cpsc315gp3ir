/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;


import java.util.ArrayList;
import project3.DocumentInfo;
import project3.StemInfo.StemInstance;

/**
 * <b>Document</b>
 * 
 * <p>This class encapsulates rank and subset of a file's text.  This is returned
 * to the UI to create <code>SearchResult</code>.</p>
 */
public class Document implements DocumentInfo
{
	/**
	 * Constructor that sets name only.
	 * Useful for when the name is known but the rank is not
	 * @param name
	 */
	public Document(String name)
	{
		mName = name;
		mRank = 0;
	}
	
	/**
	 * Create a <code>Document</code> for a file
	 * @param name - title of the document, which is typically the file path
	 * @param rank - the rank of the file
	 */
	public Document(String name, 
					double rank)
	{
		mName = name;
		mRank = rank;
	}
	
	/**
	 * Copy constructor
	 * @param doc - <code>Document</code> to be copied
	 */
	public Document(Document doc)
	{
		mRank = doc.mRank;
		mName = doc.mName;
		mStems = doc.mStems;
	}

	/**
	 * Returns the rank of the document
	 * @return
	 */
    public double getRank()
    {
        return mRank;
    }
    
    public void setRank(double rank)
    {
    	mRank = rank;
    }
	
	public String getName()
	{
		return mName;
	}

	/**
	 * Adds adds an instance of a stem to the list
	 * @param s
	 */
    public void addInstance(StemInstance s)
    {
    	if (!mIndexes.contains(s.getStem()))
    	{
    		mIndexes.add(s.getStem());
    	}
    	
        mStems.add(s);
    }

    /**
     * Gets a list of all the index terms a document contains
     * @return <code>ArrayList&ltString&gt</code> where each string is 
     * is an index term in the map 
     */
    public ArrayList<String> getIndexWords()
    {
        return new ArrayList<String>(mIndexes);
    }
	
	/**
	 * Return all instances of a stem in the document
	 */
	@Override
    public ArrayList<StemInstance> getInstances(String stem)
    {
        ArrayList<StemInstance> instances = new ArrayList<StemInstance>();

        for (StemInstance si : mStems)
        {
            if (si.getStem().equals(stem))
            {
                instances.add(si);
            }
        }

        return instances;
    }

	// Private members for name, rank, index terms and instances of index terms
    private double mRank;
    private String mName;

    private ArrayList<String> mIndexes = new ArrayList<String>();
    private ArrayList<StemInstance> mStems = new ArrayList<StemInstance>();
}
