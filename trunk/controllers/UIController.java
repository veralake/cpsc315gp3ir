/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import ui.MainFrame;
import ui.SearchPanel;
import ui.VisualPanel;

/**
 * <b>UIController</b> 
 * <p>Handles UI events.  The main purpose of the UIController
 * is to logically separate UI upkeep from the UI classes while providing a seamless
 * transition between visualization and traditional UI to the user.</p>
 * 
 * @author Zachary Edens
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

    // Singleton - Invoke the UIController
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
     * Set the Searcher panel for query-based searches
     * @param searcher - JPanel for finding a list of search results
     */
    public void setSearcher(SearchPanel searcher)
    {
    	mSearcher = searcher;
    }
    
    /**
     * Returns a reference to the query-based search panel
     * @return
     */
    public SearchPanel getSearcher()
    {
    	return mSearcher;
    }

    /**
     * <code>viewVisualizer</code> is called in response to a user event;
     * it sets the current display to the Visualizer
     */
    public void viewVisualizer()
    {
    	if (mFrame.hasComponent(mSearcher))
    	{
    		mFrame.remove(mSearcher);
    	}
    	
    	mFrame.add(mVisualizer);
    }
    
    /**
     * <code>viewSearcher</code> is called in response to a user event;
     * it sets the current display to the Searcher panel
     */
    public void viewSearcher()
    {
    	if (mFrame.hasComponent(mVisualizer))
    	{
    		mFrame.remove(mVisualizer);
    	}
    	
    	mFrame.add(mSearcher);
    }
    
    // Members
    private MainFrame mFrame;
    private SearchPanel mSearcher;
    private VisualPanel mVisualizer;
}
