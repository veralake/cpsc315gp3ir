package textProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StopWordTest 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
		throws IOException
	{
		StopWordFilter filter = new StopWordFilter();
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader("stop_word_test.txt"));
			String word = null;
			
			while((word = reader.readLine()) != null)
			{
				list.add(word.trim());
			}

			list = filter.filterWords(list);
			
			for (String s : list)
			{
				System.out.println(s);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if (reader != null)
			{
				reader.close();
			}
		}
	}
}
