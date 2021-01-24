package org.indolphin.algorithm.sort;

/**
 * 快速排序
 *
 * @author hongyan
 */
public class QuickSort {

    public int[] sort(int[] data, int left, int right) {
        int l = left;
        int r = right;
        // 中轴值
        int pivot = data[(left + right) / 2];
        int temp = 0;
        // while循环的目的是让比pivot值小的放到左边，比pivot值大的放到右边
        while (l < r) {
            while (data[l] < pivot) {
                l += 1;
            }
            while (data[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                // 说明pivot左边全部小于等于pivot，pivot右边全部大于等于pivot
                break;
            }

            // 交换
            temp = data[l];
            data[l] = data[r];
            data[r] = temp;

            if (data[l] == pivot) {
                r--;
            }
            if (data[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            sort(data, left, r);
        }
        if (l < right) {
            sort(data, l, right);
        }
        return data;
    }
}
