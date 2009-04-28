/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package textProcessing;

import java.util.ArrayList;

/**
 *
 * @author Zachary Edens
 */
public class TokenizerTest
{
    public static void printResults(String message, final ArrayList<String> list)
    {
        System.out.println(message);
        for (String s : list)
        {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Tokenizer t = new Tokenizer();

//        String query1 = "\"to be or not to be\"";
//        String query2 = "to be or not to be";
//        String query3 = "that is the question \"to be or not to be\"";
//        String query4 = "F-22 Raptor max velocity";
        String query5 = "\"to be or not to be\" that is the question";
        String query6 = "some \"stuff in\" the sentence";
        String query7 = "\"a quote at the end\" followed by \"a quote at the end\"";

//        ArrayList<String> list1 = (ArrayList<String>)t.tokenize(query1);
//        ArrayList<String> list2 = (ArrayList<String>)t.tokenize(query2);
//        ArrayList<String> list3 = (ArrayList<String>)t.tokenize(query3);
//        ArrayList<String> list4 = (ArrayList<String>)t.tokenize(query4);
        ArrayList<String> list5 = (ArrayList<String>)t.tokenize(query5);
        ArrayList<String> list6 = (ArrayList<String>)t.tokenize(query6);
        ArrayList<String> list7 = (ArrayList<String>)t.tokenize(query7);


//        printResults("The tokens from query 1 are:  ", list1);
//        printResults("The tokens from query 2 are:  ", list2);
//        printResults("The tokens from query 3 are:  ", list3);
//        printResults("The tokens from query 4 are:  ", list4);
        printResults("The tokens from query 5 are:  ", list5);
        printResults("The tokens from query 6 are:  ", list6);
        printResults("The tokens from query 7 are:  ", list7);

    }
}
