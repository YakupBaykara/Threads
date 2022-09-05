
class CreateThread2 implements Runnable {
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		CreateThread2 m1 = new CreateThread2();
		Thread t1 = new Thread(m1); // Using the constructor Thread(Runnable r)
		t1.start();
	}
}
