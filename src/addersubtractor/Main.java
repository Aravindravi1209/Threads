package addersubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Future adderReturn = executorService.submit(adder);
        Future subReturn = executorService.submit(subtractor);

        try{
            adderReturn.wait();
            subReturn.wait();
        }
        catch (Exception e)
        {
            System.out.println("Warning!!");
        }
        System.out.println(counter.value);
    }
}
