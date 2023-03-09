package adddersubtractorlock;

import java.util.concurrent.Semaphore;

public class Subtractor implements Runnable{

    Counter counter;
    Semaphore semaphore;
    Subtractor(Counter counter, Semaphore semaphore)
    {
        this.counter=counter;
         this.semaphore=semaphore;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++)
        {
            try
            {
                semaphore.acquire();
                int currVal = this.counter.getValue();
                int newVal = currVal-i;
                this.counter.setValue(newVal);
                semaphore.release();
            }
            catch(Exception e)
            {
                System.out.println("Issue acquiring lock");
            }
        }
    }
}
