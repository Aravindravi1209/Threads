package ProducerConsumer;

public class Consumer implements Runnable{
    Counter counter;

    public Consumer(Counter counter)
    {
        this.counter = counter;
        Thread thread = new Thread(this,"Consumer");
        thread.start();
    }

    @Override
    public void run() {
        while(true)
        {
            counter.get();
            try {
                Thread.sleep(10000);
            } catch (Exception e) {

            }
        }
    }
}
