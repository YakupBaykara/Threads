package sync;

/*
 * wait() : Thread in lock u diğer thread e vermesi ve diğer thread in notify()/notifyAll() ile lock u tekrar teslim etmesini beklemesidir.
 * notify() : Thread in bulunduğu objeyi bekleyen diğer bir thread i uyandırak için kullanılır.
 * notifyAll() : Thread in bulunduğu objeyi bekleyen diğer tüm thread leri uyandırak için kullanılır.  
 */
class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}

public class ThreadCommunication {
	
	public static void main(String args[]) {
		
		final Customer c = new Customer();
		
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}
}
