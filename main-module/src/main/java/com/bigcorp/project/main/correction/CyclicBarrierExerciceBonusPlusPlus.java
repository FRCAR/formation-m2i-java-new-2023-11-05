package com.bigcorp.project.main.correction;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Bonus de : {@link CyclicBarrier} avec deux barrières (une de démarrage, une
 * de fin), tenter de mettre ces Threads dans une boucle, pour qu’ils se lancent
 * continûment, mais de façon synchronisée.
 */
public class CyclicBarrierExerciceBonusPlusPlus {

	private static final int VALEUR_BARRIERE = 6;

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		System.out.println("Démarrage Thread principal");
		CyclicBarrier startCyclicBarrier = new CyclicBarrier(VALEUR_BARRIERE,
				new StartBarriereAbaisseeRunnable());
		CyclicBarrier endCyclicBarrier = new CyclicBarrier(VALEUR_BARRIERE, new EndBarriereAbaisseeRunnable());
		while (true) {
			new Thread(new MonRunnable(startCyclicBarrier, endCyclicBarrier)).start();
			new Thread(new MonRunnable(startCyclicBarrier, endCyclicBarrier)).start();
			new Thread(new MonRunnable(startCyclicBarrier, endCyclicBarrier)).start();
			new Thread(new MonRunnable(startCyclicBarrier, endCyclicBarrier)).start();
			Thread.sleep(4_200);
			new Thread(new MonRunnable(startCyclicBarrier, endCyclicBarrier)).start();
			startCyclicBarrier.await();
			startCyclicBarrier.reset();
			endCyclicBarrier.await();
			endCyclicBarrier.reset();
		}
	}

	private static final class MonRunnable implements Runnable {

		private CyclicBarrier startBarrier;
		private CyclicBarrier endBarrier;

		public MonRunnable(CyclicBarrier startBarrier,
				CyclicBarrier endBarrier) {
			this.startBarrier = startBarrier;
			this.endBarrier = endBarrier;
		}

		@Override
		public void run() {
			System.out.println("Démarrage run");
			try {
				// Le thread en cours attend tant que la valeur de la barrière n'a pas atteint
				// son seuil (défini à la construction). La valeur de la barrière est
				// incrémentée
				this.startBarrier.await();
				Thread.sleep((long) (Math.random() * 10_000));
				System.out.println("Opération terminée, j'attends.");
				this.endBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				return;
			}
			System.out.println("Fin run");
		}
	}

	private static final class StartBarriereAbaisseeRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("La barrière de démarrage s'est ouverte");
		}
	}

	private static final class EndBarriereAbaisseeRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("La barrière de fin s'est ouverte");
		}
	}

}
