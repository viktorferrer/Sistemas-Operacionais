package view;

import controller.ThreadMatriz;

public class Program {

	public static void main(String[] args) {

		int matriz[][] = new int[3][5];

		System.out.println("Matriz ==>\n");
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 4; j++) {
				matriz[i][j] = (int) ((Math.random() * 9) + 1);
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n-------------------------\n");

		for (int n = 0; n <= 2; n++) {
			Thread threadMat = new ThreadMatriz(n, matriz);
			threadMat.start();
		}
	}
}
