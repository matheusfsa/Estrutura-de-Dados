public class BTreeSET<Key extends Comparable<Key>> {
   private Page root;
   private int externas;
   private int m;
   public BTreeSET(Key sentinel,int m) { 
	   externas = 1;
	   this.m = m;
	   root = new Page(true,m);
	   add(sentinel); 
   }

   public int getExternas() {
	return externas;
   }

   public boolean contains(Key key) { 
      return contains(root, key); 
   }

   private boolean contains(Page h, Key key) {
      if (h.isExternal()) return h.holds(key);
      return contains(h.next(key), key);
   }

   public void add(Key key) {
      add(root, key);
      if (root.hasOverflowed()) {
         Page lefthalf = root;
         Page righthalf = root.split();
         root = new Page(false,m);
         root.enter(lefthalf);
         root.enter(righthalf);
         externas+=2;
      }
   }

   public void add(Page h, Key key) {
      if (h.isExternal()) { 
         h.insert(key); 
         return; 
      }
      Page next = h.next(key);
      add(next, key);
      if (next.hasOverflowed()){
         h.enter(next.split());
         externas+=1;
      }
      next.close();
   }
   public Key min(){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().min());
	   }
	   int i = 0;
	   for(Object o:aux.getTs().keys()){
		   if(i == 1){
			   return (Key)o;
		   }
		   i++;
	   }
	   return (Key) aux.getTs().min();
   }
   public Key max(){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().max());
	   }
	   return (Key) aux.getTs().max();
   }
   public Key floor(Key key){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().floor(key));
	   }
	  
	   return (Key) aux.getTs().floor(key);
   }
   @SuppressWarnings("unchecked")
   public Key ceiling(Key key){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().ceiling(key));
	   }
	   return (Key) aux.getTs().ceiling(key);
   }
   public void deleteMin(){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().min());
	   }
	   int i = 0;
	   for(Object o:aux.getTs().keys()){
		   if(i == 1){
			   aux.getTs().delete((Key)o);
			   break;
		   }
		   i++;
	   }
	   
   }
   public void deleteMax(){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().max());
	   }
	   aux.getTs().deleteMax();
	   if(aux.getTs().size() == 0){
		   aux.close();
	   }
   }
   public Key select(int k){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.getTs().get(aux.getTs().select(k));
	   }
	   return (Key)aux.getTs().select(k);
   }
   public int rank(Key key){
	   return root.rank(key)-2;
   }
   public void print(){
	   System.out.println("Tamanho:" + root.getTs().size());
	   for (Object o : root.getTs().keys()) {
		   	System.out.println("---");
		   	if(!root.isExternal()){
			   	Page p= (Page)root.getTs().get((Key)o);
			   	p.print();
		   	}
	}
   }
   public int size(Key lo, Key hi){
	   return (rank(hi) - rank(lo))+1; 
   }
   public Key get(Key k){
	   Page aux = root;
	   while(!aux.isExternal()){
		   aux = (Page)aux.next(k);
	   }
	   if(aux.holds(k)){
		   return (Key)aux.getTs().get(k);
	   }else{
		   return null;
	   }
   }
}
