
public class CreateExample implements Runnable {

/*	public static void main(String[] args) {
		
		Thread t1 = new Thread(new CreateExample(), "Thread1");  // Runnable is must be implemented
		Thread t2 = new Thread(new CreateExample());  			 // Thread-0 is automatically given
		
		t1.start();
		t2.start();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	} */
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new CreateExample(1000)); 
		Thread t2 = new Thread(new CreateExample(2000));  			 
		
		t1.start();
		t2.start();
	}
	
	
	int time;
	public CreateExample(int time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
