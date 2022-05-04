package training;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 1, j = 15;

		//for loop
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Java is fun");
		}

		//while loop
		
		while (n <= j) {
			System.out.println(n);
			n++;
		}

		//do-while loop
		do {
			System.out.println("Java is a good tech");
			n++;
		} while (n <= 10);

		
		//if-else statement
		if (j < 10) {
			System.out.println("The number is positive");
		} else {
			System.out.println("The number is negative");
		}

		System.out.println("Outside the block");

		
		//Switch statement
		
		int i = 5;
		switch (i) {
		case 0:
			System.out.println("AAAAA");
			break;
		case 1:
			System.out.println("BBBBB");
			break;

		case 3:
			System.out.println("CCCCC");
			break;
		case 4:
			System.out.println("SSSSS");
			break;
		case 5:
			System.out.println("XXXXX");
			break;
		case 6:
			System.out.println("ZZZZZ");
			break;
		case 7:
			System.out.println("YYYYY");
			break;
		case 10:
			System.out.println("DDDDD");
			break;
		default:
			System.out.println("ABCDXYZ");
		}

		//multiplication table
		//int a=2;
		 for(i=1; i<=10;i++)
		 {
			 System.out.printf("%d * %d = %d", 7,i, 7*i).println();
		 }
		
	
	}
}