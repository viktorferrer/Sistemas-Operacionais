package controller;

public class ThreadMatriz extends Thread {

	private int n;
	private int matriz[][] = new int[3][5];

	public ThreadMatriz(int n, int[][] matriz) {
		this.n = n;
		this.matriz = matriz;
	}

	@Override
	public void run() {
		somatoria();
	}

	private void somatoria() {
		int res = 0;
		for (int i = 0; i < 5; i++) {
			res += matriz[n][i];
		}
		System.out.println("\nSomatória ==> \nLinha #" + (n + 1) + " = " + res);
	}
}
