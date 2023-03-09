package ProducerConsumer;

public class Counter {
    int num;

    boolean valueSet = false;

    public synchronized void put(int num)
    {
        while(valueSet)
        {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Produced: "+num);
        this.num = num;
        valueSet=true;
        notify();
    }

    public synchronized void get()
    {
        while(!valueSet)
        {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Consumed: "+num);
        valueSet=false;
        notify();
    }
}
