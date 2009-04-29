package textProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import project3.WordTokenizer;

/**
 * <b>Tokenizer</b>
 * <p>Handles breaking the original query into a list of tokens that are void of 
 * negligible punctuation</p>
 */
public class Tokenizer implements WordTokenizer 
{
    /**
     * Default constructor
     */
	public Tokenizer()
	{
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
		// Step 3:  Run the query through the tokenizeAndrew algorithm to generate an ArrayList<String>
		// Step 4:  If any substrings were generated from Step 2, add them to the ArrayList from step 3 now
		// Step 5:  Return final array list
		
		// Note:  After a concatenated sequence from Step 4, the next word you check should be the string
		// in the splitted array after the last concatenated string.
		
		String[] words = tokenizeAndrew(bodyOfText);

        //String[] trimmedWords = removePunctuation(words);
		
		return makeWordList(words);
	}

	
	private String[] tokenizeAndrew(final String query)
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
					if(words[i].contains("Dr.")||words[i].contains("Mr.")||words[i].contains("Mrs."))
					{
					newWord+= s.charAt(x)+"";	
					
					}
				}
			}
			words[i] = newWord;
		}
		return words;
	}
	// Splits the original query into whole-grain, bite-sized tokens covered in frosting
	private String[] tokenizeQuery(final String query)
	{
		String[] words = null;
		
		 if (hasQuotesOperator(query)){
			 String trimmedQuery = query.trim();
			 Vector<String> processedStrings = new Vector();
			 String[] splitString;
			 String[] individualWords;
			
			 //if the first char is a quote, then all of the odd numbered
			 //strings returned by split("\"") will need to be split further.
			 if(query.charAt(0) == '"'){
				 splitString = query.split("\"");
				 for(int i = 0; i < splitString.length; i++){
					 if(i%2 == 0){
						 processedStrings.add(splitString[i]);
					 }
					 else{
						 individualWords = tokenizeQuery(splitString[i]);
						 for (int j = 0; j < individualWords.length; j++)
							 processedStrings.add(individualWords[j]);
					 }
				 }
			 }
			 //if the first char is not a quote, then all of the even numbered
			 //strings returned by split("\"") will need to be split further.
			 else{
				 splitString = query.split("\"");
				 for(int i = 0; i < splitString.length; i++){
					 if(i%2 != 0){
						 processedStrings.add(splitString[i]);
					 }
					 else{
						 individualWords = tokenizeQuery(splitString[i]);
						 for (int j = 0; j < individualWords.length; j++)
							 processedStrings.add(individualWords[j]);
					 }
				 }
				 
			 }
			// words = (String[]) processedStrings.toArray(); Illegal cast
			 words = new String[processedStrings.size()];
			 for( int x = 0; x<processedStrings.size();x++) words[x] = processedStrings.get(x);
		
		
		 }
        
		 else{
			 words = query.split("\\s");
		}
        
		
		return words;
	}

    private String[] removePunctuation(final String[] words)
    {
        for(int i = 0; i < words.length; i++){
            String currentWord = words[i];
            StringBuffer finishedWord = new StringBuffer();
            for(int j = 0; j < currentWord.length(); j++){
                char currentChar = currentWord.charAt(j);
                
                
                switch (currentChar){
                    case '"': break;
                    case '\'': break;
                    case '.': break;
                    case '?': break;
                    case '!': break;
                    case ',': break;
                    case ':': break;
                    case ';': break;
                    
                    default: finishedWord.append(currentChar);break;
                }
            }
            
            words[i] = finishedWord.toString();                
            
        }
        return words;
    }

    private boolean hasQuotesOperator(final String query)
    {
        // Any query that contains a chunk of text surrounded by
        // double quotes should be treated unconditionally as a
        // single token.

        // if contains "...stuff..."
        //     split on quotes
        // else
        //     call split on spaces
        
        for(int i = 0; i < query.length(); i++){
            if (query.charAt(i) == '"')
                for (int j = i; j < query.length(); j++)
                    if(query.charAt(j) == '"')
                        return true;
        }

        return false;
    }

    // Puts the the words into a container that the other components of the QueryProcessor
    // can use.
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
