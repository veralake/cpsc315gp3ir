package infoRetrieval;

import ui.MainFrame;

/**
 * Application class (singleton)
 *
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
		
	}
	
	public static void Run()
	{
		Holder.mInstance.myFrame.Show();
	}

    MainFrame myFrame = new MainFrame();
}
