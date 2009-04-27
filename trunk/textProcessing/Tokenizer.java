package textProcessing;

import java.util.ArrayList;
import java.util.List;

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
		String[] words = tokenizeQuery(bodyOfText);

        String[] trimmedWords = removePunctuation(words);
		
		return makeWordList(trimmedWords);
	}

	// Splits the original query into whole-grain, bite-sized tokens covered in frosting
	private String[] tokenizeQuery(final String query)
	{
		String[] words = null;
		
		 if (hasQuotesOperator(query)){
                    words = query.split("\"");
                 }
        
                 else{
                    words = query.split("\\s");
                 }
        //     call split on spaces (default), set equal to words
		
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
            list.add(s);
        }

        return list;
    }
}
