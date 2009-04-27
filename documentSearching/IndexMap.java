/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.Set;
import java.util.TreeMap;
import project3.StemInfo;
import project3.StemInfo.StemInstance;

// TODO IndexMap is completed.  Needs testing

/**
 * <b>IndexMap</b>
 * 
 * <p>Data structure for mapping an index term to its <code>StemInfo</code> object.</p>
 */
public class IndexMap
{
	/**
	 * Create a container for holding inverted indexes
	 */
	public IndexMap()
	{
	}
	
	/**
	 * Add a new index term to the list
	 * @param index - String to add as an index
	 * @param info - <code>StemInfo</code> associated with <code>index</code> 
	 */
	public void addStemInfo(String index, StemInfo info)
	{
		if (mIndexMap != null)
		{
			mIndexMap.put(index, info);
		}
	}
	
	/**
	 * Indicates whether the index map contains <code>index</code>
	 * @param index - String to test whether it is in the map
	 * @return false if <code>index</code> is not in the map
	 */
	public boolean hasStemInfo(String index)
	{
		boolean hasIndex = false;
		
		if (mIndexMap != null)
		{
			hasIndex = mIndexMap.containsKey(index);
		}
		
		return hasIndex;
	}
	
	/**
	 * Returns the information describing <code>index</code>
	 * @param index - String you want to get info on
	 * @return <code>StemInfo</code> object for <code>index</code>
	 */
	public StemInfo getStemInfo(String index)
	{
		StemInfo info = null;
		
		if (mIndexMap != null)
		{
			info = mIndexMap.get(index);
		}
		
		return info;
	}

    /**
     * Removes the
     * @param index
     */
    public void removeStemInfo(String index)
    {
        mIndexMap.remove(index);
    }

    public void clearAll()
    {
        mIndexMap.clear();
    }

    public String toString()
    {
    	String output = null;
    	Set<String> keys = mIndexMap.keySet();
    	for(String key: keys)
    	{
    		StemInfo si;
    		output+= key+"\n"; 
    		for(StemInstance sInstance: mIndexMap.get(key).getInstances())
    		{
    			output+="\t"+sInstance+"\n";
    		}
    	}
    	return output;
    	
    }
	private TreeMap<String, StemInfo> mIndexMap = new TreeMap<String, StemInfo>();
}
