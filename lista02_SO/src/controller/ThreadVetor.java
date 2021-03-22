package controller;

public class ThreadVetor extends Thread {

	private int n;
	private int vetor[] = new int[1000];

	public ThreadVetor(int n, int vetor[]) {
		this.n = n;
		this.vetor = vetor;
	}

	public void run() {
		timer();
		super.run();
	}

	public boolean par(int n) {
		if (n % 2 == 0) {
			return true;
		}

		return false;
	}

	public boolean impar(int n) {
		if (n % 2 != 0) {
			return true;
		}

		return false;
	}

	public void timer() {
		double tempoInicial, tempoFinal, total;
		String metodo = "";

		tempoInicial = System.nanoTime();

		if (par(n)) {
			metodo = "for";
			for (int i = 0; i < vetor.length; i++) {
			}

		} else if (impar(n)) {
			metodo = "foreach";
			for (int j : vetor) {
				j = j + 0;
			}
		}

		tempoFinal = System.nanoTime();

		total = tempoFinal - tempoInicial;
		total = total / Math.pow(10, 9);

		System.out.println("TID #" + getId() + " ==> \nMétodo usado: " + metodo + "\nTempo total: " + total + "s.\n");
	}
}
