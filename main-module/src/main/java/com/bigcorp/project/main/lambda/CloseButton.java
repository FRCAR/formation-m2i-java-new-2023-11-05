package com.bigcorp.project.main.lambda;

public class CloseButton implements Pushable {

	@Override
	public String push(int force) {
		return "Fermeture";
	}


}
