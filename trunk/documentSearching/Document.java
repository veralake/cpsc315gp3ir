/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;


import java.util.Set;
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
	 * Create a <code>Document</code> for a file
	 * @param rank - the rank of the file
	 */
	public Document(String name, double rank)
	{
		mName = name;
		mRank = rank;
	}
	
	/**
	 * Return all instances of a stem in the document
	 */
	@Override
    public Set<StemInstance> getInstances(String stem)
    {
        return null;
    }

    private double mRank;
    private String mName;
}
