package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {

    List<Integer> list;
    MergeSort(List<Integer> list)
    {
        this.list=list;
    }
    @Override
    public List<Integer> call() throws Exception {

        if(this.list.size()==0) return new ArrayList<>();
        if(this.list.size()==1) return this.list;

        int n=this.list.size();
        int mid=n/2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        for(int i=0;i<mid;i++)
        {
            leftArray.add(this.list.get(i));
        }
        for(int i=mid;i<n;i++)
        {
            rightArray .add(this.list.get(i));
        }

        MergeSort leftMergeSort = new MergeSort(leftArray);
        MergeSort rightMergeSort = new MergeSort(rightArray);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        Future<List<Integer>> leftSortedFuture = executorService.submit(leftMergeSort);
        Future<List<Integer>> rightSortedFuture = executorService.submit(rightMergeSort);

        List<Integer> mergedArray = new ArrayList<>();

        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        int i=0;
        int j=0;

        while(i<leftSorted.size() && j<rightSorted.size())
        {
            if(leftSorted.get(i)<rightSorted.get(j))
            {
                mergedArray.add(leftSorted.get(i));
                i++;
            }
            else
            {
                mergedArray.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<leftSorted.size())
        {
            mergedArray.add(leftSorted.get(i));
            i++;
        }
        while(j<rightSorted.size())
        {
            mergedArray.add(rightSorted.get(j));
            j++;
        }

        return mergedArray;
    }
}
