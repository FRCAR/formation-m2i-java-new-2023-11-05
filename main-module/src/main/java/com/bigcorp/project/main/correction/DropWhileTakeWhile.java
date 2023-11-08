package com.bigcorp.project.main.correction;

import java.util.stream.Stream;

public class DropWhileTakeWhile {

	public static void main(String[] args) {
		Stream.of("a", "b", "c", "", "e")
				.dropWhile(s -> !s.isEmpty())
				.forEach(System.out::print);

		Stream.iterate(0, i -> i + 2).takeWhile(i -> i < 40).forEach(System.out::println);
		
	}

}
