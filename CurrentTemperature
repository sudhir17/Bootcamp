import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;	
class CurrentWeather implements Runnable
{
 public void run()
 {
    Random rand = new Random();  
   int n=rand.nextInt(40);
  System.out.println(Thread.currentThread().getName()+" "+" current temperature "+n);
 }
}
class ScheduleAtFixedRate
{
 public static void main(String[] args)
 {
  ScheduledExecutorService s=Executors.newSingleThreadScheduledExecutor();
  s.scheduleWithFixedDelay(new CurrentWeather(),5,3,TimeUnit.SECONDS);
 } 
}
