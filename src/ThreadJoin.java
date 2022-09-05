
class ThreadJoinExample extends Thread {
	
	public void run() {
		for (int j = 0; j < 2; j++) {
			try {
				Thread.sleep(300);
				System.out.println("The current thread name is: " + Thread.currentThread().getName());
			}
			catch (Exception e) {
				System.out.println("The exception has been caught: " + e);
			}
			System.out.println(j);
		}
	}
}

public class ThreadJoin { 
	public static void main(String argvs[]) {

		ThreadJoinExample th1 = new ThreadJoinExample();
		ThreadJoinExample th2 = new ThreadJoinExample();
		ThreadJoinExample th3 = new ThreadJoinExample();

		th1.start();
		
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			th1.join();
		}
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		th2.start();
		
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			th2.join();
		}
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		th3.start();
	}
}
