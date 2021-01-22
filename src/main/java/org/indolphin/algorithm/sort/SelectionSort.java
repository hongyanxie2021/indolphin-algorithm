package org.indolphin.algorithm.sort;

/**
 * 选择排序
 * O(n^2)
 *
 * @author hongyan
 */
public class SelectionSort {

    public int[] sort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if(data[j] < data[min]) {
                    min = j;
                }
            }
            // 交换
            int temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
        return data;
    }
}
