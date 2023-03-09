package adddersubtractorlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        Semaphore semaphore = new Semaphore(1);
        Adder adder = new Adder(counter, semaphore);
        Subtractor subtractor = new Subtractor(counter, semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Future adderReturn = executorService.submit(adder);
        Future subReturn = executorService.submit(subtractor);

        try{
            adderReturn.get();
            subReturn.get();
        }
        catch (Exception e)
        {
            System.out.println("Warning!!");
        }
        System.out.println(counter.getValue());
    }
}
