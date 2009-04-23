package infoRetrieval;

import controllers.UIController;
import ui.ListPanel;
import ui.MainFrame;
import ui.QueryPanel;
import ui.VisualPanel;

/**
 * <b>Application</b>
 * <p>The class that binds the other components together.  It instantiates the primary
 * UI layer and the business logic layer.</p>
 */
public final class InfoRetrieval 
{
	private static class Holder
	{
		private static final InfoRetrieval mInstance = new InfoRetrieval();
	}
	
	private static InfoRetrieval getInstance()
	{
		return Holder.mInstance;
	}
	
	private InfoRetrieval()
	{
		UIController.getInstance().setFrame(new MainFrame());
                //I rewrote the constructor for vizual panel to take an array of
                //documents. We could initialy set it up to show all documents.
                //If you are unable to get all the documents in an array and then 
                //pass them in here, then let me know and I'll write an initalizer
                //function that takes in an array of documents
                //-Justin
		UIController.getInstance().setVisualizer(new VisualPanel());
        UIController.getInstance().setListPanel(new ListPanel());
		UIController.getInstance().setSearcher(new QueryPanel());
        UIController.getInstance().setListConfiguration();
	}

    private void Show()
    {
        UIController.getInstance().getFrame().Show();
    }

    /**
     * Call to begin execution of the InfoRetrieval application.
     */
	public static void Run()
	{
        getInstance().Show();
    }
}
