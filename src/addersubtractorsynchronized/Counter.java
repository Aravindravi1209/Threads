package addersubtractorsynchronized;

public class Counter {
    private int value;
    public Counter()
    {
        this.value=0;
    }

    public int getValue() {
        return value;
    }

    public synchronized void addValue(int i)
    {
        this.value+=i;
    }

    public synchronized void subValue(int i)
    {
        this.value-=i;
    }
}
