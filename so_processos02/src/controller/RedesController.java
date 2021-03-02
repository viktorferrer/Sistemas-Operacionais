package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	public String verifyOS() {
		String os = System.getProperty("os.name");

		return os;
	}

	public void activeProc(String oS) {
		String proc = "";

		try {
			if (oS.contains("Windows")) {
				proc = "TASKLIST /FO TABLE";
			} else if (oS.contains("Linux")) {
				proc = "ps -ef";
			}

			Process p = Runtime.getRuntime().exec(proc);
			InputStream fluxo = p.getInputStream();

			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

	public void killTask(String oS, String proc) {
		String killPID = "";
		String killName = "";

		if (oS.contains("Windows")) {
			killPID = "TASKKILL /PID";
			killName = "TASKKILL /IM";
		} else if (oS.contains("Linux")) {
			killPID = "kill -9";
			killName = "pkill -f";
		}
		try {
			Runtime.getRuntime().exec(matarProcessos(killPID, killName, proc));
			System.out.println("O processo " + proc + " finalizado com sucesso.");
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

	public String matarProcessos(String killPID, String killName, String proc) {
		StringBuffer buffer = new StringBuffer();
		int PID = 0;

		try {
			PID = Integer.parseInt(proc);
			buffer.append(killPID);
			buffer.append(" ");
			buffer.append(PID);
		} catch (NumberFormatException e) {
			buffer.append(killName);
			buffer.append(" ");
			buffer.append(proc);
		}

		return buffer.toString();
	}

}