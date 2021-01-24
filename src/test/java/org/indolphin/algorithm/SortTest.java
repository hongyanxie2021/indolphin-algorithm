package org.indolphin.algorithm;

import org.indolphin.algorithm.sort.QuickSort;
import org.indolphin.algorithm.sort.SelectionSort;
import org.indolphin.algorithm.sort.ShellSort;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void selectionSortTest() {
        SelectionSort selectionSort = new SelectionSort();
        int[] data = { 1, -2, 9, 10, 5};
        int[] sortData = selectionSort.sort(data);
        System.out.println(Arrays.toString(sortData));
    }

    @Test
    public void insertSortTest() {
        SelectionSort selectionSort = new SelectionSort();
        int[] data = { 1, -2, 9, 10, 5};
        int[] sortData = selectionSort.sort(data);
        System.out.println(Arrays.toString(sortData));
    }

    @Test
    public void shellSortTest() {
        ShellSort shellSort = new ShellSort();
        int[] data = { 1, -2, 9, 10, 5};
        int[] data1 = shellSort.sortBySwaping(data);
        System.out.println(Arrays.toString(data1));
        int[] data2 = shellSort.sortByMoving(data);
        System.out.println(Arrays.toString(data2));
    }

    @Test
    public void quickSortTest() {
        QuickSort quickSort = new QuickSort();
        int[] data = { 1, -2, 9, 10, 5};
        int[] data1 = quickSort.sort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data1));
    }
}
