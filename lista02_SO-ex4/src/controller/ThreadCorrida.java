package controller;

import java.util.Random;

public class ThreadCorrida extends Thread {

	private int distancia, saltoMax, id;
	private static int i = 1;

	public ThreadCorrida(int distancia, int saltoMax, int id) {
		this.distancia = distancia;
		this.saltoMax = saltoMax;
		this.id = id;
	}

	@Override
	public void run() {
		saltar();
	}

	private void saltar() {

		Random random = new Random();
		int salto, pos = 0;

		while (pos < distancia) {
			salto = random.nextInt(saltoMax + 1);
			pos += salto;
			System.out.println("\nO sapo #" + id + " pulou " + salto + " metros. \nFaltam " + (distancia - pos)
					+ " metros para completar o percurso.");
		}
		System.out.println(
				"\n------------------------------------------\n" + "    O sapo #" + id + " chegou ao fim do percurso."
						+ "\n               " + i + "º lugar" + "\n------------------------------------------\n");
		i++;
	}
}
