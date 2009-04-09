package infoRetrieval;

import controllers.UIController;
import ui.MainFrame;
import ui.VisualPanel;
import ui.SearchPanel;

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
	
	public static InfoRetrieval getInstance()
	{
		return Holder.mInstance;
	}
	
	private InfoRetrieval()
	{
		UIController.getInstance().setFrame(new MainFrame());
		UIController.getInstance().setVisualizer(new VisualPanel());
		UIController.getInstance().setSearcher(new SearchPanel());
	}
	
	public static void Run()
	{
		getInstance().myFrame.Show();
	}

    MainFrame myFrame = new MainFrame();
}
