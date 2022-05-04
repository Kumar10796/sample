package training;
import java.util.*;
public class Collection_Queue {

	public static void main(String[] args) {
	
		        PriorityQueue<String> queue=new PriorityQueue<String>();
		       
		        queue.add("12345"); 	         
		        queue.add("ABCDE");
		        queue.add("XYZ"); 
		        System.out.println("QUEUE 1: "+queue.element()); 
		        System.out.println("QUEUE 1: "+queue.peek()); 
		        System.out.println("Queue elements:"); 
		        
		        Iterator itr=queue.iterator(); 
		        while(itr.hasNext()){ 
		            System.out.println(itr.next()); 
		        } 
		        queue.remove(); 
		        queue.poll(); 
		        System.out.println("Removing second elements:"); 
		        Iterator<String> itr2=queue.iterator(); 
		        while(itr2.hasNext()){
		            System.out.println(itr2.next());
		        }
		    }
}