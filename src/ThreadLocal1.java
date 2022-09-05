
/*
 * Datalara yalnızca özel thread ler tarafından erişmemize imkan sağlar.
 * Thread-safety i sağlamak için immutable class lar oluşturmaktan daha kolaydır.
 * get(), set(), remove(), initialValue() metodları vardır.  
 * ThreadPool ile beraber ThreadLocal beraber kullanılırsa pool dan alınan thread in kullanılması ve verinin birden fazla defa kullanılması ihtimali olabilir. 
 */
 

public class ThreadLocal1 {
	
	public static class MyRunnable implements Runnable   
    {  
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();  
       
        @Override  
        public void run() {  
            threadLocal.set( (int) (Math.random() * 50D) );  
            try   
            {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
            }  
            System.out.println(threadLocal.get());  
        }  
    }  
    public static void main(String[] args)   
    {  
        MyRunnable runnableInstance = new MyRunnable();  
          
        Thread t1 = new Thread(runnableInstance);  
        Thread t2 = new Thread(runnableInstance);  
        // this will call run() method   
        t1.start();  
        t2.start();  
    }
}
