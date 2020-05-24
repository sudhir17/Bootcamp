import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class TheatreThread implements Runnable {
	
	private CyclicBarrier barrier;
	
	private String name;
	
	public TheatreThread(String name , CyclicBarrier barrier) {
		this.barrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " is travelling to theatre. It will take 20 seconds to reach");
		try {
			Thread.sleep(20000);
			System.out.println(name + " reaches and waits for other");
			barrier.await();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (BrokenBarrierException e){
			System.out.println(e.getMessage());
		}

		
	}
	
	
	
	
}

public class TheatreCyclicBarrier {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		System.out.println(Thread.currentThread().getName() + " travels at Theatre. It will take 30 seconds to reach");
		Runnable completion = () -> System.out.println("All the guys have reached the theatre.Now Showman can start the show ");
		CyclicBarrier barrier  = new CyclicBarrier(3, completion);
		
		
		new Thread(new TheatreThread("Sudhir", barrier)).start();
		new Thread(new TheatreThread("Rishabh", barrier)).start();
		
		Thread.sleep(30000);
		System.out.println(Thread.currentThread().getName() + " reaches ");
		barrier.await();
		
	}
	
	
}
