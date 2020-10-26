package test;

import com.company.DivideAndConquer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DivideAndConquerTest {

    @Test
    public void mergeSortTest() {
        Assert.assertArrayEquals(new int[] {1,2,3,5}, DivideAndConquer.mergeSort(new int[] {5,2,3,1}));
        Assert.assertArrayEquals(new int[] {0,0,1,1,2,5}, DivideAndConquer.mergeSort(new int[] {5,1,1,2,0,0}));
    }
}
