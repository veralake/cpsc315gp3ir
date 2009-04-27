package textProcessing;
import java.util.*;


public class StemmerTester {

	public static void main(String[] args)
	{
		Vector<String> v = new Vector<String>();
		StemFilter sF = new StemFilter();
		v.add("messing");
		v.add("cats");
		v.add("mating");
		v.add("vectorizing");
		v.add("swimming");
		v.add("meetings");
		v.add("national");
		v.add("vacancy");
		v.add("vectorizer");
		v.add("seriously");
		v.add("nationalization");
		v.add("activity");
		v.add("swimmingly");
		v.add("finally");
		v.add("ability");
		for(String s: v)
		{
			System.out.println(s+" -> "+sF.stem(s));
		}
	}
}
