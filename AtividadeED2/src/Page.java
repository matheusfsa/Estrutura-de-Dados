import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.SET;

/*1.(SW 6.15) Escreva uma implementação da classe Page que represente cada 
 *página como um objeto BinarySearchST.
 *Suponha que as páginas são arquivos no seu disco rígido. 
 *Repita o exercício supondo que as páginas são arquivos na teia WWW.
 */
public class Page<Key extends Comparable<Key>> {
	private BinarySearchST<Key, Page> ts_aux;
	private BinarySearchST<Key, Key> ts;
	private boolean is_external;
	private int menor_valor;
	private int m;
	/**
	 * Cria e abre uma página (externa ou interna)
	 * @param is_external
	 */
	public Page(boolean is_external, int m) {
		this.is_external = is_external;
		this.m = m;
		if(this.is_external)
			this.ts = new BinarySearchST<>();
		else
			this.ts_aux = new BinarySearchST<>();
	}
	
	/**
	 * Fecha esta página
	 */
	public void close(){
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Insere a chave key nesta página (externa)
	 * @param key
	 */
	public void insert(Key key){
		
		if(is_external)
			ts.put(key, key);
		else
			System.err.println("Esta página não é externa");
	}
	
	/**
	 * Esta página é externa?
	 * @return is_external
	 */
	public boolean isExternal(){
		return is_external;
	}
	
	/**
	 * insere nesta página (interna) um par que
     * associa a menor chave de p com p
	 * @param p
	 */
	@SuppressWarnings("unchecked")
	public void enter(Page<Key> p){
		if(is_external)
			System.err.println("Esta página não é interna");
		else
			ts_aux.put((Key) p.getTs().min(), p);
	}
	
	@SuppressWarnings("rawtypes")
	public BinarySearchST getTs(){
		if(is_external)
			return ts;
		else
			return ts_aux;
	}
	
	/**
	 * a chave key está nesta página?
	 * @return boolean
	 */
	public boolean holds(Key key){
		if(is_external)
			return ts.contains(key);
		else
			return false;	
	}
	/**
	 * a subárvore que poderia conter key
	 * @param key
	 * @return page
	 */
	@SuppressWarnings("unchecked")
	public Page<Key> next(Key key){
		if(is_external)
			return null;
		else
			return ts_aux.get(ts_aux.floor(key));
		
	}
	/**
	 * esta página transbordou (já tem M chaves)?
	 * @return boolean
	 */
	public boolean hasOverflowed(){
		return getTs().size()==m;
	}
	/**
	 * transfere as maiores M/2 chaves desta página
     * para uma nova página
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public Page split(){
		Page<Key> new_page = new Page<>(is_external, m);
		while(getTs().size()>(m/2)){
			Key key = (Key) getTs().max();
			new_page.getTs().put(key,getTs().get(key));
			getTs().deleteMax();
		}
		return new_page;
		
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Key> keys(){
		return getTs().keys();
	}
	public void print(){
		for (Object object : getTs().keys()){
			   System.out.println((Key) object);
		   }
	}
	public int rank(Key k){
			//System.out.println("----");
			//print();
		   if(isExternal()){
			   //return getTs().s
			   return getTs().size(getTs().min(),k);
			}else{
			   int res = 0;
			   for (Object object : getTs().keys(getTs().min(),k)){
				   Key key = (Key) object;
				   if(!key.equals(k)){
					   Page p =(Page)getTs().get((Key) object);
					   res += p.rank(k);
				   }else{
					   res ++;
					   break;
				   }
			   }
			   return res;
		   }   
	   }
	/*
	public static void main(String[] args) {
		Page<String> p = new Page<>(true,4);
		p.insert("A");
		p.insert("C");
		p.insert("B");
		p.insert("1");
		Page<String> p2 = p.split();
		for (Object o : p.getTs().keys()) {
			System.out.println((String)o);
		}
		p.close();
	}
	*/
	
	
	
	
	
	
}
