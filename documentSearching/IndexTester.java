package documentSearching;

import java.io.File;

import textProcessing.QueryProcessor;

public class IndexTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File directory = new File("C:\\TestData");
		QueryProcessor qp = new QueryProcessor();
		IndexBuilder ib = new IndexBuilder(directory,qp);
		IndexMap im = ib.createIndexMap();
		System.out.println(im);
		

	}

}
