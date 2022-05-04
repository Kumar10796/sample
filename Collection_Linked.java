package training;

import java.util.*;

public class Collection_Linked {

	public static void main(String[] args) {

		LinkedList<String> al = new LinkedList<String>();
		al.add("SRI");
		al.add("KUMAR");
		al.add("KUMARAN");
		
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}