package ProducerConsumer;

public class Producer implements Runnable{

    Counter counter;

    public Producer(Counter counter)
    {
        this.counter = counter;
        Thread thread = new Thread(this,"Producer");
        thread.start();
    }

    @Override
    public void run() {
        int i=0;
        while(true)
        {
            counter.put(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
