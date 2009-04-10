/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.SortedMap;
import project3.StemInfo;

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
		
	}
	
	/**
	 * Indicates whether the index map contains <code>index</code>
	 * @param index - String to test whether it is in the map
	 * @return false if <code>index</code> is not in the map
	 */
	public boolean containsStem(String index)
	{
		return false;
	}
	
	/**
	 * Returns the information describing <code>index</code>
	 * @param index - String you want to get info on
	 * @return <code>StemInfo</code> object for <code>index</code>
	 */
	public StemInfo getInfo(String index)
	{
		return new StemInfo("");
	}
	
	private SortedMap<String, StemInfo> mIndexMap;
}
