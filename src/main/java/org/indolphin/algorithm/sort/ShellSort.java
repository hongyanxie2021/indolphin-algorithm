package org.indolphin.algorithm.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    /**
     * 希尔排序，内层使用交换法
     * @param data 数据
     * @return 排序后数据
     */
    public int[] sortBySwaping(int[] data) {
        int temp = 0;
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < data.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 通过交换找到[i]的合适位置
                    if (data[j] > data[j + gap]) {
                        temp = data[j];
                        data[j] = data[j + gap];
                        data[j + gap] = temp;
                    }
                }
            }
        }
        return data;
    }

    /**
     * 希尔排序，内层使用插入排序
     * @param data 数据
     * @return 排序后数据
     */
    public int[] sortByMoving(int[] data) {
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < data.length; i++) {
                int j = i;
                int temp = data[j];
                while (j - gap > -1 && temp < data[j - gap]) {
                    data[j] = data[j - gap];
                    j -= gap;
                }
                data[j] = temp;
            }
        }
        return data;
    }
}
