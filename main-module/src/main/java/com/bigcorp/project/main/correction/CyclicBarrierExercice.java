package com.bigcorp.project.main.correction;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Créer une implémentation de Runnable, dont run() affiche une ligne sur la
 * console. run() prend un nombre aléatoire de secondes pour s’exécuter (entre 0
 * et 10). Utiliser une CyclicBarrier, à injecter dans l’implémentation de
 * Runnable, pour s’assurer que tous les Runnable se lancent en même temps. Dans
 * le main(), lancer assez de Runnable pour déclencher l’ouverture de la
 * barrière.
 */
public class CyclicBarrierExercice {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Démarrage Thread principal");
		//Bonus : lancer un autre Runnable quand la barrière s’ouvre (il affiche une ligne)
		//Le constructeur avec deux arguments permet de spécifier un runnable à 
		//exécuter quand la barrière s'abaisse.
		CyclicBarrier cyclicBarrier = new CyclicBarrier(9, new BarriereAbaisseeRunnable());
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		new Thread(new MonRunnable(cyclicBarrier)).start();
		Thread.sleep(4_200);
		new Thread(new MonRunnable(cyclicBarrier)).start();
		System.out.println("Fin Thread principal");
	}

	private static final class MonRunnable implements Runnable {

		private CyclicBarrier barrier;

		public MonRunnable(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			System.out.println("Démarrage run");
			try {
				// Le thread en cours attend tant que la valeur de la barrière n'a pas atteint
				// son seuil (défini à la construction). La valeur de la barrière est incrémentée
				this.barrier.await();
				Thread.sleep((long) (Math.random() * 10_000));
			} catch (InterruptedException | BrokenBarrierException e) {
				return;
			}
			System.out.println("Fin run");
		}
	}

	private static final class BarriereAbaisseeRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("La barrière s'est ouverte");
		}
	}

}
