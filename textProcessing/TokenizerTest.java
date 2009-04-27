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

        String query1 = "\"to be or not to be\"";
        String query2 = "to be or not to be";
        String query3 = "that is the question \"to be or not to be\"";
        String query4 = "F-22 Raptor max velocity";

        ArrayList<String> list1 = (ArrayList<String>)t.tokenize(query1);
        ArrayList<String> list2 = (ArrayList<String>)t.tokenize(query2);
        ArrayList<String> list3 = (ArrayList<String>)t.tokenize(query3);
        ArrayList<String> list4 = (ArrayList<String>)t.tokenize(query4);

        printResults("The tokens from query 1 are:  ", list1);
        printResults("The tokens from query 2 are:  ", list2);
        printResults("The tokens from query 3 are:  ", list3);
        printResults("The tokens from query 4 are:  ", list4);
    }
}
