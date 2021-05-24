import java.util.Scanner;

class Report {

	private long factorial;
	private String threadName;
	private int activeThreads;

	public Report(long factorial, String threadName, int activeThreads) {
		this.factorial = factorial;
		this.threadName = threadName;
		this.activeThreads = activeThreads;
	}

	public long getFactorial() {
		return factorial;
	}

	public String getThreadName() {
		return threadName;
	}

	public int getActiveThreads() {
		return activeThreads;
	}

	public void setActiveThreads(int activeThreads) {
		this.activeThreads = activeThreads;
	}

}

public class Factorial implements Runnable {

	private static int count,factorial=1;
    static int check=1,n;

	public static void main(String[] args) throws InterruptedException {

		Scanner in = new Scanner(System.in);

		System.out.print("N: ");
		n = in.nextInt();
		
		System.out.println();
		
		count = n;
		
		Factorial f = new Factorial();
		
		// Creating n threads
		for(int i=0;i<n;i++) {
			Thread t = new Thread(f);
			t.start();
		}
		
		synchronized(f) {
			f.wait();
		}
		
		
		synchronized(f) {
			f.notifyAll();
		}
		
		System.out.println();
		
		System.out.println("Factorial: " + factorial);
		
		System.out.println();
		
		in.close();
	}
	
	public synchronized void generate() throws InterruptedException {
		factorial *= count;
		System.out.println(count-- + " " + Thread.currentThread().getName());
        if(check>=n){
		    notifyAll();
        }
        else{
            check++;
        }
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				generate();
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Factorial.count = count;
	}

}