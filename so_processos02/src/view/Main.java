package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		RedesController redesController = new RedesController();

		int opc = 0;
		String proc = "";

		String oS = redesController.verifyOS();

		System.out.println("Bem vindo.\n\n Identicamos que o sistema operacional é: " + oS);

		while (opc != 9) {
			System.out.println("Selecione a opção desejada:\n  1 - Processos ativos" + "\n  2 - Matar algum processo"
					+ "\n  9 - Finalizar programa");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				redesController.activeProc(oS);
				cleaner();
				break;

			case 2:
				System.out.print("Digite o nome ou PID");
				proc = sc.next();
				redesController.killTask(oS, proc);
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