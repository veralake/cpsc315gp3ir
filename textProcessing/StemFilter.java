package textProcessing;

import java.util.ArrayList;
import java.util.List;

import project3.WordStemmer;

/**
 * <b>StemFilter</b>
 * <p>This class encapsulates an algorithm for analyzing words for root words or stems
 * Example:  The stem for connects and connection is connect.</p>
 */
public class StemFilter implements WordStemmer 
{

	// To the implementer of this class:  You may try going out on wikipedia because they list
	// a lot of different types of Stemming algorithms.  There's also Porter's Stemming Algorithm,
	// which is supposedly very popular amongst IR people.

	/**
	 * Finds the stem for a single word.
	 * @param word - String containing the word for analyzing.
	 * @return - the stem of <code>word</code>
	 */
	@Override
	public String stem(String word) 
	{
		if(word.endsWith("s"))
		{
		if(word.endsWith("sses")||word.endsWith("ies"))word = replaceEnd(word,"es","");
		else word = replaceEnd(word,"s","");
		}
		if(word.endsWith("ing"))
		{
			word = replaceEnd(word,"ing","");
			if(word.endsWith("at"))word = replaceEnd(word,"at","ate");
			else if(word.endsWith("bl"))word = replaceEnd(word,"bl","ble");
			else if(word.endsWith("iz"))word = replaceEnd(word,"iz","ize");

		}

		return word;
	}
	/**
	 * replaces the ending of a word. If the replaceValue is greater than the original then it will return the original
	 * @param original
	 * @param replaceValue
	 * @param newValue
	 * @return
	 */
	String replaceEnd(String original, String replaceValue, String newValue  )
	{

		if(original.length()>replaceValue.length())
		{
			String base = original.substring(0,original.length()-replaceValue.length());
			return base + newValue;
			
		}
		
		return original; 
	}
	/**
	 * Finds the stems of multiple words
	 * @param words - Strings of words for analyzing.
	 * @return <code>List</code> of <code>String</code> containing the stems of
	 * each word
	 */
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
