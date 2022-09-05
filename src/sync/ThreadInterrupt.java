package sync;

/*
 * Bir thread sleep veya wait durumunda iken interrupt edilirse hata alınır.
 */
public class ThreadInterrupt extends Thread{

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("task");
		} catch (InterruptedException e) {
//			throw new RuntimeException("Thread interrupted..." + e);
			System.out.println("Exception handled : " +e);
		}
		System.out.println("Thread is running...");
	}

	public static void main(String args[]) {
		ThreadInterrupt t1 = new ThreadInterrupt();
		t1.start();
		try {
			t1.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}

	}
}
