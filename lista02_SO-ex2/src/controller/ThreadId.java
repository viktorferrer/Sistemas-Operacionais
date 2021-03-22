package controller;

public class ThreadId extends Thread {

	private long id;

	public ThreadId() {

	}

	public ThreadId(long id) {
		this.id = id;
	}

	@Override
	public void run() {
		numberThreadId();
		super.run();
	}

	public void numberThreadId() {
		id = getId();
		System.out.println("TID #" + id);
	}

}
