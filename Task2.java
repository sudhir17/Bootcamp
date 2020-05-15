import java.util.concurrent.*;
import java.io.*;
class Demo implements Callable<String>{
 //static int i=0;
 public String fname;
 public Demo(String fname)
 {
   this.fname=fname;
 }
 public String call() throws InterruptedException, IOException{
  int n=(int)(Math.random()*1000);
  File f=new File(fname);
  File f1=null;
  f.mkdir();
   for(int i=0;i<n;i++)
   {
    String filename=""+i+".txt";
    f1=new File(fname,filename);
    f1.createNewFile();     
   }
  Thread.sleep(1000);
  return fname+"and"+n;
 }
}

 class Sample {
	public static void main(String []Rishabh)throws Exception {        
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future[]=new Future[5];
        for(int i=0;i<5;i++)
        {
         String fname="folder"+i;
         future[i]=executorService.submit(new Demo(fname));
        } 
        executorService.shutdown();
        for(int i=0;i<5;i++)
         System.out.println("Folder name and total files are:"+future[i].get());
      }     
}
