import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import edu.princeton.cs.algs4.BTree;

public class Exec2item1 {
	public static void main(String[] args) {
		BTreeSET<Character> bts = new BTreeSET<Character>('*',6);
		BTree<Character, Character> b = new BTree<>();
		bts.add('a');
		bts.add('b');
		bts.add('c');
		bts.add('d');
		bts.add('e');
		bts.add('f');
		bts.add('g');
		bts.add('h');
		bts.add('i');
		bts.add('j');
		bts.add('k');
		bts.add('l');
		bts.add('m');
		bts.add('n');
		bts.add('o');
		bts.add('p');
		//bts.print();
		System.out.println(bts.rank('e'));
		System.out.println(bts.rank('e'));
		System.out.println(bts.rank('c'));
		System.out.println(bts.size('c', 'e'));
		System.out.println(bts.get('x'));
	}

}
