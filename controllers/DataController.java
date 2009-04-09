package controllers;

/**
 * 
 * @author zedens
 *
 */
public class DataController 
{
	private static class Holder
	{
		private static DataController mInstance = new DataController();
	}
	
	private DataController()
	{
	}
	
	public static DataController getInstance()
	{
		return Holder.mInstance;
	}
}
