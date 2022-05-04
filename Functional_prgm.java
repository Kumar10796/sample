package training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional_prgm {

	public static void main(String[] args) {
		getMyNames();
	}

	private static void getMyNames() {
		FP a1 = new FP("AAAAAAA", "QQQQQ");
		FP a2 = new FP("BBBBBB", "WWWWWW");
		FP a3 = new FP("CCCCCC", "EEEEE");

		List<FP> persons = Arrays.asList(a1, a2, a3);

		String Name = persons.stream()

				.filter(name -> "AAAA".equals(name.getName())).map(FP::getName).findAny().orElse("");

		System.out.println("Name :" + Name);

		List<String> collect = persons.stream()

				.map(FP::getName).collect(Collectors.toList());

		System.out.println("All Names");
		collect.forEach(System.out::println);
	}
}
