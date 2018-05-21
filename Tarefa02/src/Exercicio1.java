
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import edu.princeton.cs.algs4.*;

public class Exercicio1 {
	public static double BlackfilteSCH(String dict, String entrada){
		StdOut.print("BlackFilter utilizando  o SeparateChainingHashST\n");
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
		In dicionario = new In(dict);
		double time1=0;
		Stopwatch sw = new Stopwatch();
		for (int i = 0; !dicionario.isEmpty(); i++) {
            String key = dicionario.readString();
            st.put(key, i);
        }
		time1 += sw.elapsedTime();
		In livro = new In(entrada);

		SET<String> set =new SET<>();
		sw = new Stopwatch();
	    while (!livro.isEmpty()) {
	         String palavra = livro.readString();
	         if(!st.contains(palavra))
	        	 set.add(palavra);
	         
	     }
	    time1 += sw.elapsedTime();
	    
	    for(String str: set){
	    	StdOut.print(str + " ");
	    }
	    StdOut.print("\n");
	    return time1;
	}
	
	public static double BlackfilteLPH(String dict, String entrada){
		StdOut.print("BlackFilter utilizando  o LinearProbingHashST\n");
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();
		In dicionario = new In(dict);
		double time1=0;
		Stopwatch sw = new Stopwatch();
		for (int i = 0; !dicionario.isEmpty(); i++) {
            String key = dicionario.readString();
            st.put(key, i);
        }
		time1 += sw.elapsedTime();
		In livro = new In(entrada);

		SET<String> set =new SET<>();
		sw = new Stopwatch();
	    while (!livro.isEmpty()) {
	         String palavra = livro.readString();
	         if(!st.contains(palavra))
	        	 set.add(palavra);
	         
	     }
	    time1 += sw.elapsedTime();
	    for(String str: set){
	    	StdOut.print(str + " ");
	    }
	    StdOut.print("\n");
	    return time1;
	}
	public static void main(String[] args) {
		StdOut.println(Exercicio1.BlackfilteSCH("words.utf-8.txt", "tale.txt"));
		StdOut.println(Exercicio1.BlackfilteLPH("words.utf-8.txt", "tale.txt"));
		
	    
	    //for(String str: set){
	    	//StdOut.println(str);
	    //}
	    
	}
	
}
