package com.company;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("#####Preda#####");
        printVector(mergeSort(new int[] {5,2,3,1}));
        printVector(mergeSort(new int[] {5,1,1,2,0,0}));
    }

    /**
     * Given an array of integers nums, sort the array in ascending order.
     * Example 1:
     * Input: nums = [5,2,3,1]
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * Input: nums = [5,1,1,2,0,0]
     * Output: [0,0,1,1,2,5]
     */
    public static int[] mergeSort(int[] nums) {
        //Caso base (trivial)
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length/2;

        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        int rightElements = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                left[i] = nums[i];
            } else {
                right[rightElements++] = nums[i];
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while(leftPointer < left.length || rightPointer < right.length) {
            if(leftPointer < left.length && rightPointer < right.length) {
                if(left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            else if(leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }
            else if(rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    private static void printVector(int[] vector) {
        for (int i : vector
        ) {
            System.out.println(i);
        }

    }
}
