
public class CreateThread4 implements Runnable {
	public void run() {
		System.out.println("Now the thread is running ...");
	}

	public static void main(String argvs[]) {

		Runnable r1 = new CreateThread4();
// creating an object of the class Thread using Thread(Runnable r, String name)  
		Thread th1 = new Thread(r1, "My new thread");

// the start() method moves the thread to the active state  
		th1.start();

// getting the thread name by invoking the getName() method  
		System.out.println(th1.getName());
	}
}
