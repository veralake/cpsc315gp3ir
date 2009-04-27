package documentSearching;

import java.io.File;

public class IndexTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File directory = new File("TestData");
		IndexBuilder ib = new IndexBuilder(directory,null);
		IndexMap im = ib.createIndexMap();
		

	}

}
