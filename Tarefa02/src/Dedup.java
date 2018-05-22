import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.SET;

public class Dedup {
	

	public static int adiciona(int[] lista){
		SET<Integer> set = new SET<>();
		int res = 0;
		for (int i : lista) {
			 if (!set.contains(i)) {
	                set.add(i);
			 }else{
				 //incrementa se o elemento for repetido
				 res++;
			 }
		}
		return res;
	}
}
