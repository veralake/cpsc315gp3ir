/*
 * DocumentInfo.java
 */

package project3;

import java.util.Set;

/**
 * Used for obtaining information about a particular text document.
 */
public interface DocumentInfo
{
    /**
     * Returns all of the instances of a stem in the given document.
     * @param stem a word stem
     * @return a set of all instances of the provided <code>stem</code> or null
     * if no instances of the stem exist in the document.
     */
    public Set<StemInfo.StemInstance> getInstances(String stem);
}

