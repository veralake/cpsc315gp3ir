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
	/**
	 * Finds the stem for a single word.
	 * @param word - String containing the word for analyzing.
	 * @return - the stem of <code>word</code>
	 */
	int vowels(String s)
	{
		int result = 0; 
		for(int x = 0; x<s.length();x++)
		{
			char c= s.charAt(x);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y') result++;
		}
		return result;
	}
	public String stem(String word) 
	{
		word = word.toLowerCase();
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
		if(word.endsWith("ed"))
		{
			word = replaceEnd(word,"ed","");
			if(word.endsWith("at"))word = replaceEnd(word,"at","ate");
			else if(word.endsWith("bl"))word = replaceEnd(word,"bl","ble");
			else if(word.endsWith("iz"))word = replaceEnd(word,"iz","ize");
		}
		if(word.endsWith("y")&&vowels(word)>1) word= replaceEnd(word,"y","i");
		if(word.charAt(word.length()-2)=='a')
		{
			if(word.endsWith("ational")) word = replaceEnd(word,"ational","ate");
			if(word.endsWith("tional")) word = replaceEnd(word,"tional","tion");
		}
		if(word.charAt(word.length()-2)=='c')
		{
			if(word.endsWith("enci")) word = replaceEnd(word,"enci","ence");
			if(word.endsWith("anci")) word = replaceEnd(word,"tional","tion");
		}
		if(word.charAt(word.length()-2)=='e')if(word.endsWith("izer")) word = replaceEnd(word,"izer","ize");
		if(word.charAt(word.length()-2)=='l')
		{
			if(word.endsWith("bli")) word = replaceEnd(word,"bli","ble");
			if(word.endsWith("alli")) word = replaceEnd(word,"alli","al");
			if(word.endsWith("ently")) word = replaceEnd(word,"entli","ent");
			if(word.endsWith("eli")) word = replaceEnd(word,"eli","e");
			if(word.endsWith("ousli")) word = replaceEnd(word,"ousli","ous");
		}	
		if(word.charAt(word.length()-2)=='o')
		{
			if(word.endsWith("ization")) word = replaceEnd(word,"ization","ize");
			if(word.endsWith("ation")) word = replaceEnd(word,"ation","ate");
			if(word.endsWith("ator")) word = replaceEnd(word,"ator","ate");
			
		}
		if(word.charAt(word.length()-2)=='s')
		{
			if(word.endsWith("alism")) word = replaceEnd(word,"alism","al");
			if(word.endsWith("iveness")) word = replaceEnd(word,"iveness","ive");
			if(word.endsWith("fullness")) word = replaceEnd(word,"fulness","ful");
			if(word.endsWith("ousness")) word = replaceEnd(word,"ousness","ous");
		}
		if(word.charAt(word.length()-2)=='t')
		{
			if(word.endsWith("aliti")) word = replaceEnd(word,"aliti","al");
			if(word.endsWith("iviti")) word = replaceEnd(word,"iviti","ive");
			if(word.endsWith("biliti")) word = replaceEnd(word,"biliti","ble");
		}
		if(word.charAt(word.length()-2)=='g')word = replaceEnd(word,"logi","log");
    	
    
    
    
    


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
