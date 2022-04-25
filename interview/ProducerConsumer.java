import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
	
	public static void main(String[] args)throws InterruptedException {
		
		PC pc=new PC();
		
		Thread t1= new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
Thread t2= new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

     t1.start();
     t2.start();
     t1.join();
     t2.join();
		
	}
	
	
	
	

}

class PC
{
	List<Integer> list = new LinkedList<>();
	int capacity=3;
	
	public void produce() throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				if(list.size()==capacity)
					wait();
				int item=(int)(Math.random()*10);
				System.out.println("Produced :"+item);
				list.add(item);
				
				notify();
				
				Thread.sleep(1000);
			}
		}
		
	}
	
	public void consume() throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				if(list.size()==0)
					wait();
				
				System.out.println("Consumed :"+list.remove(0));
				
				notify();
				
				Thread.sleep(1000);
			}
		}
		
	}
	
}
