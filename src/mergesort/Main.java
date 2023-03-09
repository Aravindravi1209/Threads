package mergesort;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(31,21,19,-1,15,45);
        MergeSort mergeSort = new MergeSort(list);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try
        {
            Future<List<Integer>> sortedList = executorService.submit(mergeSort);
            List<Integer> sorted = sortedList.get();
            System.out.println(sorted);
        }
        catch(Exception e)
        {
            System.out.println("Warning!!");
        }
    }
}
