package test;

import com.preda.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void mergeSortTest() {
        Assert.assertArrayEquals(new int[] {1,2,3,5}, MergeSort.mergeSort(new int[] {5,2,3,1}));
        Assert.assertArrayEquals(new int[] {0,0,1,1,2,5}, MergeSort.mergeSort(new int[] {5,1,1,2,0,0}));
    }
}
