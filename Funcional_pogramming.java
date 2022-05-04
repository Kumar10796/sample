package training;

import java.util.Arrays;
import java.util.List;

public class Funcional_pogramming {
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Running in Runnable thread");
			}
		};

		r.run();
		System.out.println("Running in main thread");

		List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100);

		for (Integer n : numbers) {
			System.out.print(n);
		}

	}
}
