
public class ThreadMultiTask {
  
	int contr = 1;
	static int NUM;

	public void displayOddNumber() {
// note that synchronized blocks are necessary for the code for getting the desired output. If we remove the synchronized blocks, we will get an exception.  
		synchronized (this) {  
			while (contr < NUM) {
				while (contr % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				System.out.print(contr + " ");
				contr = contr + 1;
// notifying the thread which is waiting for this lock   
				notify();
				
			}
		}
	}

	public void displayEvenNumber() {
		synchronized (this) {
			while (contr < NUM) {
				while (contr % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				System.out.print(contr + " ");
				contr = contr + 1;
// Notifying to the 2nd thread  
				notify();
			}
		}
	}

	public static void main(String[] argvs) {
		
		NUM = 20;
		
		ThreadMultiTask oe = new ThreadMultiTask();
		Thread th1 = new Thread(new Runnable() {
			public void run() {
				oe.displayEvenNumber();
			}
		});
		
		Thread th2 = new Thread(new Runnable() {
			public void run() {
				oe.displayOddNumber();
			}
		});
		
		th1.start();
		th2.start();
	}
}
