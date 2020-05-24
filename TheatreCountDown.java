import java.util.concurrent.CountDownLatch;
class CustomerTask implements Runnable {

	private CountDownLatch latch;
	
	private String name;
	
	private int delay;
	
	public CustomerTask(CountDownLatch latch, String name , int delay) {
		
		this.latch = latch;
		this.name = name;
		this.delay = delay;
	}
	
	@Override
	public void run() {

		System.out.println("Customer " + name + " has watching the show");
		try {
			Thread.sleep(delay);
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		finally {
			latch.countDown();
			System.out.println("customer " + name + " has finished  watching the show in " + this.delay + " milliseconds");
		}
		
	}
	
	
}


public class TheatreCountDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Show Thread has started ");
		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new CustomerTask(latch, "Rishabh" , 10000 )).start();
		new Thread(new CustomerTask(latch, "Sudhir" , 12000 )).start();
		new Thread(new CustomerTask(latch, "Ankit" , 5000 )).start();
		
		
		System.out.println("Owner is waiting to end the show");
		latch.await();
		
		System.out.println("Show is ended");
		

	}

}
