/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.util.Comparator;

/**
 *
 * @author Justin
 */
public class DocumentComparator implements Comparator {

    /**
     * Creates a comparator to compare document ranks
     */
    public DocumentComparator(){

    }

    /**
     * Compairs Document ranks
     * @param o1
     * Any document
     * @param o2
     * Any document
     * @return
     * Returns 1 if o1 rank is higher than o2 rank.
     * Returns 0 if they are equal.
     * Returns -1 if o1 rank is less than o2 rank.
     */
    public int compare(Object o1, Object o2) {
        Document a = (Document) o1;
        Document b = (Document) o2;

        if(a.getRank() > b.getRank())
            return 1;

        else if (a.getRank() == b.getRank())
            return 0;
        
        else
            return -1;
    }



}
