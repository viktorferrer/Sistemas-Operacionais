package view;

import controller.ThreadId;

public class Program {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Thread threadId = new ThreadId();
			threadId.start();
		}
	}

}
