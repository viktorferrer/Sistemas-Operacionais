package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	public String verificaOs() {
		String oS = System.getProperty("os.name");

		return oS;
	}

	public String ip(String oS) {
		String ipconfig = " ";

		if (oS.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();
				System.out.println(linha);

				while (linha != null) {
					if (linha.contains("Ethernet:") || linha.contains("VirtualBox") || linha.contains("Windows")) {
						ipconfig += linha + "\n";
					}

					if (linha.contains("IPv4")) {
						ipconfig += linha + "\n";
					}
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException err) {
				ipconfig = err.getMessage();
			}
		} else if (oS.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("flags:")) {
						ipconfig += linha + "\n";
					}

					if (linha.contains("netmask")) {
						ipconfig += linha + "\n";
					}
					System.out.println(linha);
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException err) {
				ipconfig = err.getMessage();
			}
		} else {
			ipconfig = "O sistema operacional não pôde ser identificado.";
		}

		return ipconfig;
	}

	public void ping(String oS) {
		double soma = 0;
		double media = 0f;
		int c = 0;

		if (oS.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();
				System.out.println(linha);

				System.out.println("Aguarde enquanto processamos as informações...");

				while (linha != null) {
					if (linha.contains("tempo")) {
						int vInicial = linha.indexOf("o=");
						int vFinal = linha.indexOf("ms");

						soma += Double.parseDouble(linha.substring(vInicial + 2, vFinal));
						c++;
					}

					linha = buffer.readLine();
				}

				media = soma / c;

				System.out.println("O tempo médio do PING considerando " + c + " pacotes enviados"
						+ " para www.google.com.br foi: " + media + "ms");

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException err) {

				System.out.println(err.getMessage());
			}
		}

		else if (oS.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();
				System.out.println(linha);

				System.out.println("Aguarde enquanto processamos as informações...");

				while (linha != null) {
					if (linha.contains("seq")) {
						int vInicial = linha.indexOf("e=");
						int vFinal = linha.indexOf(" ms");

						soma += Double.parseDouble(linha.substring(vInicial + 2, vFinal));
						c++;
					}

					linha = buffer.readLine();
				}

				media = soma / c;

				System.out.println(media);

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException err) {

				System.out.println(err.getMessage());
			}
		} else {
			System.out.println("OS não identificado");
		}

	}
}