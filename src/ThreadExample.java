import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MessageSender implements Runnable {

	private String message;

	public MessageSender(String s) {
		this.message = s;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + this.message);
		processmessage();
		System.out.println(Thread.currentThread().getName() + " (End)");
	}

	private void processmessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int threadNumber;
		
		System.out.println("Mesaj gönderilecek kişi sayısı giriniz : ");
		int kisiNumber = sc.nextInt();
		
		System.out.println("Thread task sayisi : ");
		int threadTaskNumber = sc.nextInt();
		sc.close();
		
		if(kisiNumber/threadTaskNumber == 0)
			threadNumber = kisiNumber/threadTaskNumber;
		else	
			threadNumber = kisiNumber/threadTaskNumber +1;
			
		
		ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
		
		for (int i = 0; i < kisiNumber; i++) {
			MessageSender sender = new MessageSender("" + i);
//			Runnable worker = new WorkerThread("" + i);
			executor.execute(sender);
		}
		executor.shutdown();
		
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
