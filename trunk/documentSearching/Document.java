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
	public Document(String name)
	{
		mName = name;
		mRank = 0;
	}
	
	/**
	 * Create a <code>Document</code> for a file
	 * @param rank - the rank of the file
	 */
	public Document(String name, double rank)
	{
		mName = name;
		mRank = rank;
	}
	
	public Document(Document doc)
	{
		mRank = doc.mRank;
		mName = doc.mName;
		mStems = doc.mStems;
	}

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

    public void addInstance(StemInstance s)
    {
    	if (!mIndexes.contains(s.getStem()))
    	{
    		mIndexes.add(s.getStem());
    	}
    	
        mStems.add(s);
    }

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

    private double mRank;
    private String mName;

    private ArrayList<String> mIndexes = new ArrayList<String>();
    private ArrayList<StemInstance> mStems = new ArrayList<StemInstance>();
}
