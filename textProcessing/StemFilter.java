package textProcessing;

import java.util.ArrayList;
import java.util.List;

import project3.WordStemmer;

/**
 * Provides the root word (stem) for a search term
 */
public class StemFilter implements WordStemmer 
{
	
	// To the implementer of this class:  You may try going out on wikipedia because they list
	// a lot of different types of Stemming algorithms.  There's also Porter's Stemming Algorithm,
	// which is supposedly very popular amongst IR people.
	
	@Override
	public String stem(String word) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> stems(List<String> words)
	{
		ArrayList<String> wordStems = new ArrayList<String>();
		
		for (String s : words)
		{
			wordStems.add(stem(s));
		}
		
		return wordStems;
	}
}
