import java.lang.instrument.Instrumentation;

import edu.princeton.cs.algs4.BTree;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.BinarySearchST;

public class Exercicio2item5{
	public static void main(String[] args) {
		BTree<Integer, Integer> b = new BTree<>();
		BinarySearchST<Integer, Integer> bst = new BinarySearchST<>();
		long inicio,fim;
		double cm =  (6*Math.pow(10, 10));
		int m = 10000;
		
		System.out.println("Árvore B");
		System.out.println("Tempo de Inserção:");
		inicio = System.nanoTime();
		for(int i = 0;i<m;i++){
			int a =Math.toIntExact(Math.round(Math.random()*m));
			b.put(a, a);
		}
		fim = System.nanoTime();
		System.out.println((fim-inicio)/cm);
		System.out.println("Tempo de Consulta:");
		inicio = System.nanoTime();
		for(int i = 0;i<m;i++){
			int a =Math.toIntExact(Math.round(Math.random()*m));
			b.get(a);
		}
		fim = System.nanoTime();
		System.out.println((fim-inicio)/cm);
		b = null;
		
		System.out.println("Árvore binária de busca");
		System.out.println("Tempo de Inserção:");
		inicio = System.nanoTime();
		for(int i = 0;i<m;i++){
			int a =Math.toIntExact(Math.round(Math.random()*m));
			bst.put(a, a);
		}
		fim = System.nanoTime();
		System.out.println((fim-inicio)/cm);
		System.out.println("Tempo de Consulta:");
		inicio = System.nanoTime();
		for(int i = 0;i<m;i++){
			int a =Math.toIntExact(Math.round(Math.random()*m));
			bst.get(a);
		}
		fim = System.nanoTime();
		System.out.println((fim-inicio)/cm);
		
		
	}
}
