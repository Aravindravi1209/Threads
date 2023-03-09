package ProducerConsumer;

public class InterThread {
    public static void main(String[] args) {
        Counter c = new Counter();
        new Producer(c);
        new Consumer(c);
    }
}
