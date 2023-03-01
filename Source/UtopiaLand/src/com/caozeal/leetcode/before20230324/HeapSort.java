package com.caozeal.leetcode.before20230324;

//I am a Java developer and I would like to implement a heap sorting function. The following code is an example of how to achieve this goal:

import com.alibaba.fastjson.JSON;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1, 0, 100};
        HeapSort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]   .   n is size of heap   .   This function basically modifies the array so that it satisfies the max-heap property. It also updates the position of nodes in the max-heap if any nodes have been moved due to insertion or deletion. It assumes that the subtrees are already heaps.   .   O(logn) time complexity.     .     .     .     .     .     .      .      .      .      .      .       .       .       .       .....    .....    .....    .....    .....     ....     ....     ....     ....     ....      ...      ...      ...      ...      ...       ..       ..       ..       ..       ..        .

    public static void heapify(int arr[], int n, int i) {

        // Find largest among root and children

        int largest = i;

        int leftChildIdx = 2*i + 1;

        int rightChildIdx = 2*i + 2;

        if (leftChildIdx < n && arr[leftChildIdx] > arr[largest])

            largest = leftChildIdx;

        if (rightChildIdx < n && arr[rightChildIdx] > arr[largest])

            largest = rightChildIdx;

        // If root is not largest, swap with largest and continue heapifying

        if (largest != i)          {

            int swap = arr[i];

            arr[i] = arr[largest];

            arr[largest] = swap;               // Recursively heapify the affected sub-tree

            heapify(arr, n, largest);          }      } }