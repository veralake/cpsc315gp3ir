/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import documentSearching.Document;

/**
 * <b>ResultsDisplay</b>
 *
 * <p>Represents any object that maintains the ranked documents from a
 * search query</p>
 * @author Zachary Edens
 */
public interface ResultsDisplay
{
    /**
     * Adds a ranked document to a search results list
     * @param doc - document to be displayed
     */
    public void addDocument(Document doc);
    
    
    /**
     * Clears all documents contained in the display
     */
    public void clear();
}
