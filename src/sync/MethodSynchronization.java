package sync;

/*
 * Paylaşılan bir kaynağın bir thread tarafından kilitli olması anlamına gelir.
 */
class Table {
	synchronized void printTable(int n) {   // synchronized method
//	void printTable(int n) {				// not synchronize method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

/* class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
} */

public class MethodSynchronization {
	
	public static void main(String args[]) {
		
		Table obj = new Table();// only one object

		//
/*		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);  */
		
	    // Thread with anonymous class
		Thread t1 = new Thread() {
			public void run() {
				obj.printTable(5);
		}};
		Thread t2 = new Thread() {
			public void run() {
				obj.printTable(100);
		}};
		
		t1.start();
		t2.start();
	}
}
