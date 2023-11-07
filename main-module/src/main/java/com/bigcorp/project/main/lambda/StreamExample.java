package com.bigcorp.project.main.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {

		List<String> strings = List.of("salut", "ça", "va");
		for (String string : strings) {
			if (string.length() > 3) {
				System.out.println(string);
			}
		}
		
		// Le code ci-dessus est équivalent à celui ci-dessous
		strings.stream()
				.filter(s -> s.length() > 3)
				.forEach(System.out::println);

		// Utilisation de filter et map
		strings.stream()
				.filter(s -> s.length() > 3)
				.filter(s -> s.length() < 10)
				.map(s -> new Matiere(s, 0, 0))
				.forEach(System.out::println);

		// Reconstruction d'une collection
		List<String> listeFiltree = strings.stream()
				.filter(s -> s.length() > 3)
				.collect(Collectors.toList());

	}

}
