import java.util.concurrent.ThreadLocalRandom;

import edu.princeton.cs.algs4.DeDup;
import edu.princeton.cs.algs4.StdOut;

public class AleatoriosRepetidos {
	private int m,n,t;
	public AleatoriosRepetidos(int m,int n, int t) {
		this.m = m;
		this.n = n;
		this.t = t;
	}
	public int[] geraAleatorios(){
		int[] res = new int[n];
		for(int i = 0;i<n;i++){
			res[i] = ThreadLocalRandom.current().nextInt(0, m - 1);
			//StdOut.println(res[i]);
		}
		return res;
	}
	public int repetidos(){
		int repetidos = 0;
		for(int i = 0; i < t; i++){
			repetidos += Dedup.adiciona(geraAleatorios());
		}
		
		
		
		return repetidos;
	}
}
