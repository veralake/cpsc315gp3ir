/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import project3.StemInfo;

import textProcessing.QueryProcessor;

/**
 * <b>IndexBuilder</b>
 * 
 * <p>Builds an <code>IndexMap</code> given a working directory. This class will
 * contain the inverted index algorithm</p>
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
		// Is the file a directory
		if(!mMainDirectory.isDirectory()){
			System.err.println("Input file is not a directory");
			return null;
		}
		File files[] = mMainDirectory.listFiles();
		//Are there files in the directory
		if(files.length==0)
			{
			System.err.println("directory is empty ");
			return null;
			}
		
		for(File f: files)
		{
			//For each file process tokenize the text and add it to the IndexMap
			if(!f.isDirectory()){
				Scanner scanner;
				try {
					scanner = new Scanner(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}
				int lineNum = 1;
				while(scanner.hasNext())
				{
					String line = scanner.nextLine();
					ArrayList<String> wordsInLine = mLineProcessor.tokenize(line,false);
					int startNum = 0;
					for(String word: wordsInLine)
					{
						String stemmedWord = mLineProcessor.stem(word);
						
						if(im.hasStemInfo(stemmedWord))//Word is already in Map, add another instance
						{
							im.getStemInfo(stemmedWord).addInstance(f, lineNum, startNum, word);
						}
						else
						{ // word is not in Map create a StemInfo for it
							StemInfo si = new StemInfo(stemmedWord);
							si.addInstance(f, lineNum, startNum, word);	
							im.addStemInfo(stemmedWord, si);
						}
						startNum+=word.length()+1;
					}
					lineNum++;

				}
			}
		}
		
		return im;
	}

	private File mMainDirectory;
	private QueryProcessor mLineProcessor;
}
