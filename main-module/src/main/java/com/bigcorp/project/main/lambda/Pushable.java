package com.bigcorp.project.main.lambda;

/**
 * N'importe quel élément sur lequel on peut 
 * appuyer
 */
@FunctionalInterface
public interface Pushable {
	
	String push(int force);
	
}
