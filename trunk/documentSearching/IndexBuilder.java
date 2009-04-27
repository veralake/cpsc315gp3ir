/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import project3.StemInfo;

import textProcessing.QueryProcessor;

/**
 * <b>IndexBuilder</b>
 * 
 * <p>Builds an <code>IndexMap</code> given a working directory. This class will
 * contain the inverted index algorithm</p>
 * @author Zachary Edens
 */
public class IndexBuilder
{
	/**
	 * Constructor to instantiate the IndexBuilder with a directory
	 * in which to search for files.
	 * @param directory - directory in which to search
	 * @param processor - a processor for applying the stemming algorithm to document samples
	 */
    public IndexBuilder(File directory, 
    					QueryProcessor processor)
    {
    	mMainDirectory = directory;
    	mLineProcessor = processor;
    }
    
    /**
     * Generates an data structure containing the index words for the documents in
     * <code>mMainDirectory</code>.  To be called by the DataController shortly after start-up.
     * @return - <code>IndexMap</code> of index terms
     */
    public IndexMap createIndexMap()
    {
    	IndexMap im = new IndexMap();
    	File files[] = mMainDirectory.listFiles();
    	for(File f: files)
    	{
    		Scanner scanner;
    		try {
				scanner = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			int lineNum = 1;
			while(scanner.hasNext())
			{
				String line = scanner.nextLine();
				String wordsInLine[] = line.split(" ");
				int startNum = 0;
				for(String word: wordsInLine)
				{
					if(im.containsStem(word))
					{
						im.getInfo(word).addInstance(f, lineNum, startNum, word);
					}
					else
					{
						StemInfo si = new StemInfo(word);
						si.addInstance(f, lineNum, startNum, word);	
					}
					startNum+=word.length()+1;
				}
				lineNum++;
				
			}
    	}
    	return im;
    }
//    private String searchDirectory(File directory)
//    {
//    	String output = null;
//    	File files[] = directory.listFiles();
//    	for(File f: files)
//    	{
//    		if(f.isDirectory())
//    		{
//    			output += searchDirectory(f);
//    		}
//    		else
//    		{
//    			try {
//					Scanner scanner = new Scanner(f);
//					while(scanner.hasNext())output+=" "+scanner.next();
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//    			
//    		}
//    		
//    	}
//    	return output;
//    	
//    	
//    }
    
    private File mMainDirectory;
    private QueryProcessor mLineProcessor;
}
