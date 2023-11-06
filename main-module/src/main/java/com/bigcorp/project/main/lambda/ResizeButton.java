package com.bigcorp.project.main.lambda;

public class ResizeButton implements Pushable {

	@Override
	public String push(int force) {
		return "Je retaille avec une valeur de : " + force;
	}

}
