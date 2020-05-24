import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
class PlayTask implements Runnable
 {
	private Semaphore semaphore;
	private String name;
 	public PlayTask(Semaphore semaphore, String name)
       {
		this.semaphore = semaphore;
		this.name = name;
	}
	
	@Override
	public void run() {

		System.out.println("Customer " + name + " is waiting for the play to start");
		try {
			semaphore.acquire();
			System.out.println("Play is in progres for Customer " + name + ", It will take 7 seconds to finish");
			Thread.sleep(7000);
			
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		finally {
			semaphore.release();
			System.out.println("Play Customer " + name + " has finished watching play");
		}
		
	}
	
	
}


public class WatchPlaySemaphore {

	public static void main(String[] args) {
		
		Semaphore semaPhore = new Semaphore(2);
		ExecutorService service  = Executors.newFixedThreadPool(2); 
		for(int i=1; i<=10;i++) {
			service.submit(new PlayTask(semaPhore, "" +i));
		}

	}

}
