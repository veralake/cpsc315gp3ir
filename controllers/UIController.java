/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.util.ArrayList;

import javax.swing.JFileChooser;

import documentSearching.Document;
import ui.ListPanel;
import ui.MainFrame;
import ui.QueryPanel;
import ui.VisualPanel;

/**
 * <b>UIController</b> 
 * <p>Handles UI events.  The main purpose of the UIController
 * is to logically separate UI upkeep from the UI classes while providing a seamless
 * transition between visualization and traditional UI to the user.</p>
 */
public class UIController
{
	// Private, thread safe instance of the controller.
    private static class Holder
    {
        private static UIController instance = new UIController();
    }

    // Private constructor
    private UIController()
    {
    }

     /**
     * Call for singleton to gain access to the methods inside the DataController
     * @return Instance of the controller.
     */
    public static UIController getInstance()
    {
        return Holder.instance;
    }

    /**
     * Set the application's frame to be managed.
     * @param frame - Frame for the application
     */
    public void setFrame(MainFrame frame)
    {
        mFrame = frame;
    }

    /**
     * Get a reference to the frame
     */
    public MainFrame getFrame()
    {
        return mFrame;
    }

    /**
     * Adds the panel to the UI that enables the user to make text-based
     * queries.
     * @param searcher - QueryPanel for entering queries
     */
    public void setSearcher(QueryPanel searcher)
    {
        mSearcher = searcher;
    }

    /**
     * Retrieves a handle to the panel for entering searches
     * @return the JPanel for searching
     */
    public QueryPanel getSearcher()
    {
        return mSearcher;
    }
    
    /**
     * Set the Visualizer panel
     * @param visualizer - JPanel for presenting a visual representation of
     * search results
     */
    public void setVisualizer(VisualPanel visualizer)
    {
    	mVisualizer = visualizer;
    }
    
    /**
     * Get a reference to the Visualizer
     */
    public VisualPanel getVisualizer()
    {
    	return mVisualizer;
    }
    
    /**
     * Set the List panel for a list of search results.
     * @param listPanel - JPanel for containing a list of search results
     */
    public void setListPanel(ListPanel listPanel)
    {
    	mList = listPanel;
    }
    
    /**
     * Returns a reference to panel with a list of results
     * @return panel containing a graphical list of search results
     */
    public ListPanel getListPanel()
    {
    	return mList;
    }

    /**
     * Sets the current UI config to a list format
     */
    public void setListConfiguration()
    {
    	if (mFrame != null)
    	{
	        mFrame.setSplitterPosition(dividerPosition);
	        mFrame.setConfiguration(mSearcher, mList);
    	}
    }

    /**
     * Sets the current UI config to a visual format
     */
    public void setVisualConfiguration()
    {
    	if (mFrame != null)
    	{
	        mFrame.setSplitterPosition(dividerPosition);
	        mFrame.setConfiguration(mSearcher, mVisualizer);
    	}
    }

    /**
     * Gets the directory containing the text files to be indexed.
     * Disables any ability to launch a query if no directory was selected.
     */
    public void getMainDirectory()
    {
        String message = "Please select working directory for searching";

        JFileChooser getDirectory = new JFileChooser();
        getDirectory.setToolTipText(message);
        getDirectory.setDialogTitle(message);
        getDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (mFrame != null)
        {
	        int value = getDirectory.showOpenDialog(mFrame);
	
	        if (value == JFileChooser.APPROVE_OPTION)
	        {
	            enableSearch(true);
	            DataController.getInstance().setSearchDirectory(getDirectory.getSelectedFile());
	        }
	        else if (DataController.getInstance().getSearchDirectory() == null)
	        {
	            enableSearch(false);
	        }
        }
    }
    
    /**
     * Call this to display a new list of results to the user
     * @param documents - <code>ArrayList</code> of <code>Document</code> 
     * to be displayed to the user.
     */
    public void addDocuments(ArrayList<Document> documents)
    {
    	if (mVisualizer != null && mList != null && documents != null)
    	{
    		mList.clear();
    		mVisualizer.clear();
    		
    		mVisualizer.set(documents);
    		
    		mList.addDocuments(documents);
    	}
    }
    
    /**
     * Sets the splitter bar to a preset location
     */
    public void defaultSplitterPosition()
    {
    	if (mFrame != null)
    	{
    		mFrame.setSplitterPosition(dividerPosition);
    	}
    }

    // Tells the resident QueryPanel to disable search components.
    private void enableSearch(boolean isEnabled)
    {
        mSearcher.setEnabled(isEnabled);
    }
    
    // Members
    private final double dividerPosition = 0.38;

    private MainFrame mFrame;
    private QueryPanel mSearcher;
    private ListPanel mList;
    private VisualPanel mVisualizer;
}
