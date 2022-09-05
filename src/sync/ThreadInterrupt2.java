package sync;

/*
 * Bir thread sleep veya wait durumunda değilken interrupt edilirse thread durmaz fakat "interrupt flag" true olarak işaretlenir.
 */
public class ThreadInterrupt2 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++)
			System.out.println(i);
	}

	public static void main(String args[]) {
		ThreadInterrupt2 t1 = new ThreadInterrupt2();
		t1.start();

		t1.interrupt();

	}
}
