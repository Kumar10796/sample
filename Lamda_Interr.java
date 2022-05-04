package training;

import training.Lamda_Inter.MyInterface;

public class Lamda_Interr {

	public static void main(String[] args) {

		MyInterface ref = (str) -> {

			String result = "";
			for (int i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};

		System.out.println("Lambda reversed = " + ref.reverse("Kumar"));
	}

}
