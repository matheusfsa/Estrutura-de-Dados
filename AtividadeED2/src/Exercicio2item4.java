
public class Exercicio2item4 {
	public static void main(String[] args) {
		BTreeSET<Integer> bts;
		double media = 0;
		int n = 1000;
		int m = 1000;
		for(int i= 0; i<n; i++){
			bts = new BTreeSET<>(-1,10);
			for(int j = 0; j<3000;j++){
				int a =Math.toIntExact(Math.round(Math.random()*1000));
				bts.add(a);
			}
			media+=(bts.getExternas()/(n*1.0));
		}
		System.out.println(media);
	}
	
}
