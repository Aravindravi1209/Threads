package addersubtractorsynchronized;

public class Subtractor implements Runnable{

    Counter counter;
    Subtractor(Counter counter)
    {
        this.counter=counter;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++)
        {
            this.counter.subValue(i);
        }
    }
}
