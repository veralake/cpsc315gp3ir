/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.TreeMap;
import project3.StemInfo;

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
	public void add(String index, StemInfo info)
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
	public boolean containsStem(String index)
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
	public StemInfo getInfo(String index)
	{
		StemInfo info = null;
		
		if (mIndexMap != null)
		{
			info = mIndexMap.get(index);
		}
		
		return info;
	}
	
	private TreeMap<String, StemInfo> mIndexMap = new TreeMap<String, StemInfo>();
}
