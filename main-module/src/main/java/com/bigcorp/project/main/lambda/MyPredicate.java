package com.bigcorp.project.main.lambda;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return t.length() > 2;
	}

}
