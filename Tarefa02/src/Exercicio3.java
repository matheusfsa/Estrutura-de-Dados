import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Exercicio3 {
	public static void main(String[] args) {
		In in = new In("ip.csv");
	    int keyField = 1;
	    int valField = 0;

	    ST<String,String> st = new ST<String,String>();
	    //leitura da tabela
	    while (in.hasNextLine()) {
	        String line = in.readLine();
	        String[] tokens = line.split(",");
	        String key = tokens[keyField];
	        String val = tokens[valField];
	        st.put(key, val);
	        
	        
	     }
	    for(int i = 0; i<20000000;i++){	
	    	int n = ThreadLocalRandom.current().nextInt(1, 10);
			StringBuilder sb = new StringBuilder();
			//66.135.192.87
			//Geração dos IPs
			sb.append(ThreadLocalRandom.current().nextInt(127,239)+"."+ThreadLocalRandom.current().nextInt(0,255)+"."+ThreadLocalRandom.current().nextInt(0,255)+"."+ThreadLocalRandom.current().nextInt(0,255));
			
			
	        String query = new String(sb);
	       //Verificação se o ip pertence a lista
	        if (st.contains(query)){
	           StdOut.println(st.get(query));
	        }
	    }
		
		
	}
}
