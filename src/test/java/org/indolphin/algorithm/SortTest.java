package org.indolphin.algorithm;

import org.indolphin.algorithm.sort.SelectionSort;
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
}
