import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercicio2 {
	public static void main(String[] args) {
		AleatoriosRepetidos ar = null;
		StdOut.println("Numero de experimentos:");
		int n_exp = StdIn.readInt();
		StdOut.println("Escreva os valores na ordem: m n t");
		Stopwatch sw = null;
		int[] valores;
		for(int i = 0;i<n_exp;i++){
			StdIn.readLine();
			String[] valores_str = StdIn.readLine().split(" ");
			//StdIn.readLine();
			valores = new int[3];
			for (int j = 0; j<3;j++) {
				valores[j] = Integer.parseInt(valores_str[j]);
				StdOut.print(valores[j]);
			}
			StdOut.print("Quantidade de numeros repetidos: ");
			ar = new AleatoriosRepetidos(valores[0], valores[1], valores[2]);
			sw = new Stopwatch();
			StdOut.println(ar.repetidos());
			double tempo = sw.elapsedTime();
			StdOut.println("\nTempo: "+ tempo);
		}
	}
}
