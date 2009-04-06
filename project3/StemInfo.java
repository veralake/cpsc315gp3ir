/*
 * StemInfo.java
 */

package project3;

import java.io.File;
import java.util.HashSet;
import java.util.Set;



/**
 * Used for storing information about a particular word stem
 * and instances of that word stem.
 */
public class StemInfo
{

    /**
     * Used for storing information about a particular instance of a word stem.
     */
    public static class StemInstance
    {
	/** The text document containing the instance. */
	private File doc;
	/** The line number of the instance. */
	private int lineNum;
	/** The index of the first character on the line. */
	private int startIndex;
	/** The stem of the instance. */
	private String stem;
	/** The instance as it appears in the text document (no stemming). */
	private String instance;

	/**
	 * Constructs a stem instance with information about where the instance
	 * is located with respect to a collection of text documents.
	 * @param doc a text document
	 * @param lineNum a line number in the specified text document
	 * <code>doc</code>
	 * @param startIndex an index of a character on the specified line
	 * <code>lineNum</code> in the specified text document <code>doc</code>
	 * @param stem a word stem corresponding to this instance
	 * @param instance the word as it appeared in the document
	 */
	public StemInstance(File doc, int lineNum, int startIndex, String stem, String instance)
	{
	    this.doc = doc;
	    this.lineNum = lineNum;
	    this.startIndex = startIndex;
	    this.stem = stem;
	    this.instance = instance;
	}

	public boolean equals(Object obj)
	{
	    if(obj instanceof StemInstance)
	    {
		StemInstance stemInst = (StemInstance)obj;
		return (doc.equals(stemInst.doc) &&
			lineNum == stemInst.lineNum &&
			startIndex == stemInst.startIndex &&
			stem.equals(stemInst.stem) &&
			instance.equals(stemInst.instance));
	    }
	    return false;
	}

	/**
	 * Returns the document containing this word stem instance.
	 */
	public File getDocument()
	{
	    return doc;
	}

	/**
	 * Returns the line number on which this word stem instance occurs.
	 */
	public int getLineNumber()
	{
	    return lineNum;
	}

	/**
	 * Returns the index of the first character on the line number where
	 * this word stem instance occurs.
	 */
	public int getStartIndex()
	{
	    return startIndex;
	}

	/**
	 * Returns the stem of this word stem instance.
	 */
	public String getStem()
	{
	    return stem;
	}

	/**
	 * Returns the instance as it appeared in the text document.
	 */
	public String getInstance()
	{
	    return instance;
	}

	/**
	 * Returns the string representation of this word stem instance.
	 */
	public String toString()
	{
	    return stem + " : " + doc.getName() + ":" + lineNum + ":" + startIndex + ":" + instance;
	}
    }

    /** The stem of interest. */
    private String stem;
    /** A list of word stem instances. */
    private Set<StemInstance> instances;

    /**
     * Constructs a stem info object with zero instances.
     * @param stem a word stem
     */
    public StemInfo(String stem)
    {
	this.stem = stem;
	this.instances = new HashSet<StemInstance>();
    }

    /**
     * Returns the stem of interest for this stem info object.
     */
    public String getStem()
    {
	return this.stem;
    }

    /**
     * Adds a new instance of the word stem to this stem info object.
     */
    public void addInstance(File document, int lineNum, int startIndex, String instance)
    {
	this.instances.add(new StemInstance(document, lineNum, startIndex, stem, instance));
    }

    /**
     * Returns all of the instances of the word stem.
     */
    public Set<StemInstance> getInstances()
    {
	return instances;
    }
}