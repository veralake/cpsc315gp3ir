package textProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import project3.WordTokenizer;

/**
 * <b>Tokenizer</b>
 * <p>Handles breaking the original query into a list of tokens that are void of 
 * negligible punctuation</p>
 */
public class Tokenizer implements WordTokenizer 
{
	Vector<String> Exceptions;
    /**
     * Tokenizer to split a String of words into tokens for further processing
     * Constructor creates Exception list of words that do not need to have their punctuation removed
     * 
     */
	public Tokenizer()
	{
		Exceptions = new Vector<String>(); 
		
		File file = new File("TokenizerExceptions.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext())
			{
				Exceptions.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Tokenizes a string and eliminates erroneous punctuation.
	 * @param bodyOfText - String to be tokenized
	 * @return a <code>List</code> of strings representing tokens
	 */
	@Override
	public List<String> tokenize(String bodyOfText) 
	{
		// Key feature: "" is an operator, and anything inside the quotes is unconditionally left alone
		// Here's what I want for the tokenizer:
		// Step 1:  Scan string for quotes (may want to record positions and number of)
		// Step 2:  i) if there's only one, leave it (it'll be removed later on)
		//			ii) if the count is even, pair up quotes (can do it linearly or regex, don't care)
		//				and return substrings in between quotes operators (use positions from before).
		//				keep the substring in a container on the side until the rest of the query is
		//				done being tokenized.
		//			iii) if count is odd, do what you would do in (ii) except ignore the last quotation
		// Step 3:  Run the query through the tokenizeQuery algorithm to generate an ArrayList<String>
		// Step 4:  If any substrings were generated from Step 2, add them to the ArrayList from step 3 now
		// Step 5:  Return final array list
		
		String[] words = tokenizeQuery(bodyOfText);

        //String[] trimmedWords = removePunctuation(words);
		
		return makeWordList(words);
	}

	/**
	 * Main tokenizer for the program. Splits a string up using space (" ") as a delimeter.
	 * Then removes punctuation unless it is needed i.e Mr. Ms. ... 
	 * @param query String for tokenizing (usually a line of text from a file)
	 * @return tokenized string with punctuation removed
	 * @author Andrew
	 */
	private String[] tokenizeQuery(final String query)
	{
		String[] words = query.split(" ");
		for(int i = 0; i<words.length; i++)
		{
			String s = words[i].toLowerCase();
			String newWord="";
			for(int x=0;x<s.length();x++)
			{
				if(s.charAt(x)>=97&&s.charAt(x)<=122)
				{
					newWord += s.charAt(x)+"";
				}
				else 
				{
					for(String exception: Exceptions)
					{
						if(words[i].contains(exception)){
							newWord+=s.charAt(x);
						}
					}
					
				}
			}
			words[i] = newWord;
		}
		return words;
	}
		
	/**
	 *  Puts the the words into a container that the other components of the QueryProcessor
	 * can use.
	 * @param words Array of String to be added to the WordList
	 * @return ArrayList of words
	 */
     
    private ArrayList<String> makeWordList(final String[] words)
    {
        ArrayList<String> list = new ArrayList<String>();

        for (String s : words)
        {
        	if(!s.equals("")) list.add(s);
        	
        }
        
        
        return list;
    }
}
