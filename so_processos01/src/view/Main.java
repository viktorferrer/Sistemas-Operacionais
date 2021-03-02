package view;

import java.util.Scanner;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		RedesController redesController = new RedesController();

		int opc = 0;

		String oS = redesController.verificaOs();

		System.out.println("Bem vindo.\n\n Identicamos que o sistema operacional é: " + oS);

		while (opc != 9) {
			System.out.println("Selecione uma das opções:\n  1 - Nome e IPV4" + "\n  2 - Média de PING\n  9 - Finalizar programa");

			opc = sc.nextInt();

			switch (opc) {
			case 1:
				System.out.println(redesController.ip(oS));
				cleaner();
				break;

			case 2:
				redesController.ping(oS);
				cleaner();
				break;

			case 9:
				System.out.println("O programa foi finalizado.");
				break;

			default:
				System.out.println("Opção inválida. Por favor, selecione outra opção.");
				cleaner();
				break;
			}
		}
		sc.close();
	}

	private static void cleaner() {
		System.out.println("\n-----------------\n");
	}
}