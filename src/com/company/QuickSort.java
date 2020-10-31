package com.company;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
//        int[] arr = {5,1,1,2,0,0};

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("####Sorted array");
        printArray(arr);
    }

    public void sort(int[] arr, int indexStart, int indexEnd) {
        if (indexStart < indexEnd) { //Caso base
            int partitionIndex = partition(arr, indexStart, indexEnd);
            sort(arr, indexStart, partitionIndex - 1);
            sort(arr, partitionIndex, indexEnd);
        }
    }
    /*
    Metodo de particion seleccionando como pivote el último elemento del array
     */
    private int partition(int[] arr, int indexStart, int indexEnd) {
        int pivot = arr[indexEnd];
        int partitionIndex = indexStart;
        for (int i = indexStart; i < indexEnd; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, indexEnd);
        return partitionIndex;
    }

    private static void swap(int[] arr, int indexA, int indexB) {
        int valueA = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = valueA;
    }

    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}

