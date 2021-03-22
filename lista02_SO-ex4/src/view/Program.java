package view;

import controller.ThreadCorrida;

public class Program {

	public static void main(String[] args) {

		for (int id = 1; id < 6; id++) {
			Thread threadCorrida = new ThreadCorrida(20, 10, id);
			threadCorrida.start();
		}
	}
}
