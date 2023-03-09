package ThreadForLoop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)
    {
        for(int i=1;i<=100;i++)
        {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(numberPrinter);
        }
    }
}