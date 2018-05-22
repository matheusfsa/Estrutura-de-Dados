import java.util.ArrayList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Concordancia {
	public static void verifica_concordancia(){
		//contexto é 4
		int contexto = 4;
		In in = new In("tale.txt"); // banco de dados
		//ler todo o texto
	    String[] text = in.readAllStrings();
	    //a st vai armazenar a palavra e as posições da palavra no texto
	    ST<String, ArrayList<Integer>> st = new ST<String, ArrayList<Integer>>();
	    
	    for (int i = 0; i < text.length; i++) {
            String s = text[i];
            if (!st.contains(s)) {
            	//adiciona a palavra e  cria uma lista
                st.put(s, new ArrayList<>());
            }
            //adiciona posição na lista da letra
            ArrayList<Integer> list = st.get(s);
            list.add(i);
        }
	    int len = text.length;
	    while (!StdIn.isEmpty()) {
	    	String palavra = StdIn.readString();
	    	//pega todas as posições da palavra no texto
		    ArrayList<Integer> lista = st.get(palavra);
		    if(lista!=null){
			    for(Integer e:lista){
			    	StringBuilder sb = new StringBuilder();
			    	int i =0;
		    		int j = 0;
		    		//se a palavra não tiver no começo do texto
			    	if(e>0){
			    		i = e-1;
			    		j = 0;
			    		//adicionando palavras anteriores a palavra
			    		while(j!=contexto){
			    			//nao adiciona as palavras vazias
			    			if(!text[i].startsWith(" ")){
			    				sb.append(text[i] + " ");
			    				j++;
			    			}
			    			i--;
			    		}
			    	}
			    	sb.append("*"+palavra +"*" + " ");
			    	if(e<len-1){
				    	i = e+1;
				    	j = 0;
				    	//adicionando palavras posteriores a palavra
				    	while(j!=contexto){
				    		if(!text[i].startsWith(" ")){
				    			sb.append(text[i] + " ");
				    			j++;
				    		}
				    		i++;
				    	}
				    	
			    	}
			    	StdOut.println(sb);
			    }
		    }else{
		    	StdOut.println("sem ocorrencias");
		    }
		    
	    }
	    
	    
	     
	     
	     
	}
}
