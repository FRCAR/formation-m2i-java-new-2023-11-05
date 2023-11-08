package com.bigcorp.project.graphics2.other;

import com.bigcorp.project.data.model.User;
import com.bigcorp.project.data.repository.UserRepositoryImpl;

/**
 * Simule une fenêtre de démarrage. Nécessite
 * UserRepository.
 */
public class StartWindow {

	private UserRepositoryImpl userRepository = new UserRepositoryImpl();

	public User displayHelloMessage() {
		User currentlyLoggedUser = userRepository.getCurrentlyLoggedUser();
		System.out.println("Hello, " + currentlyLoggedUser.getFirstName());
		return currentlyLoggedUser;
	}

	public static void main(String[] args) throws Exception{
		StartWindow startWindow = new StartWindow();
		startWindow.displayHelloMessage();
	}

}
