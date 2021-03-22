package view;

import controller.ThreadVetor;

public class Program {

	public static void main(String[] args) {

		int n;
		int vetor[] = new int[1000];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) ((Math.random() * 99) + 1);
		}

		for (n = 1; n < 3; n++) {
			Thread threadVetor = new ThreadVetor(n, vetor);
			threadVetor.start();
		}
	}
}
