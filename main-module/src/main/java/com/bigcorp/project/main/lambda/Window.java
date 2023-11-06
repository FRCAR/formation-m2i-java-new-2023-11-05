package com.bigcorp.project.main.lambda;

import java.util.function.Consumer;

/**
 * Une fenêtre : utilise des lambdas
 */
public class Window {

	private Pushable button;
	
	private Consumer<String> stringConsumer;
	
	public void click(int force) {
		String result = button.push(force);
		System.out.println(result);
	}

	public void setButton(Pushable button) {
		this.button = button;
	}

	public static void main(String[] args) {
		Window window = new Window();
		
		//Affectation du bouton via une classe implémentant l'interface
		window.setButton(new ResizeButton());
		window.click(7);

		//Affectation du bouton via une classe définie en ligne
		Pushable displayButton = new Pushable() {
			@Override
			public String push(int force) {
				return "affiche message avec la force : " + force;
			}
		};
		window.setButton(displayButton);
		window.click(Integer.MIN_VALUE);
		
		//Création d'une instance de Pushable directement via une lambda
		Pushable deleteButton = (int force) -> {return  "suppression effectuée";};
		
		// La même avec la syntaxe raccourcie
		Pushable deleteButtonRaccourci = force -> "suppression effectuée";
		
		//Affectation du bouton via set
		window.setButton(deleteButton);

		//Affectation du bouton directement via une lambda et la syntaxe raccourcie
		window.setButton(force -> "suppression effectuée");
		
		//Utilisation d'une autre lambda
		window.setButton(
				(int force) -> {return "Bouton cliqué via une lambda avec la force : " + force;});
		
		window.setStringConsumer(System.out::println);
		window.setStringConsumer(s -> System.out.println(s));
		
	}

	public void setStringConsumer(Consumer<String> stringConsumer) {
		this.stringConsumer = stringConsumer;
	}

}
