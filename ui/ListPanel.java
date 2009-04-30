/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListPanel.java
 *
 * Created on Apr 9, 2009, 7:31:31 AM
 */

package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import documentSearching.Document;

/**
 * <b>ListPanel</b>
 *
 * <p>This class represents the window for viewing the search results of a query
 * in a list.</p>
 */
public class ListPanel extends javax.swing.JPanel implements ResultsDisplay
{

    /** Creates new form ListPanel */
    public ListPanel()
    {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Removes all search items contained in the visual panel for another query.
     */
    public void removeSearchItems()
    {
    }

    /**
     * Adds a search item that is to be displayed in the visual format.
     * @param doc - <code>Document</code> reference to displayed
     */
	@Override
	public void addDocument(Document doc) 
	{
		// TODO Implement this
		
		SearchResult result = new SearchResult(doc);
		
		this.add(result);
	}

	/**
	 * 
	 */
	@Override
	public void clear() 
	{
		
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
