
class ABCD extends Thread {
	Thread threadToInterrupt;

	public void run() {
		threadToInterrupt.interrupt();
	}
}

public class ThreadJoin3 {
  
	public static void main(String[] argvs) {
		try {
			ABCD th1 = new ABCD();

			th1.threadToInterrupt = Thread.currentThread();
			th1.start();

// invoking the join() method leads to the generation of InterruptedException  
			th1.join();
		} catch (InterruptedException ex) {
			System.out.println("The exception has been caught. " + ex);
		}
	}
}
