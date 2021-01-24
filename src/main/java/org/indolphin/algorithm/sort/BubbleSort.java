package org.indolphin.algorithm.sort;

/**
 * 冒泡排序
 * 时间复杂度O(n^2)
 * @author hongyan
 */
public class BubbleSort {

    public int[] sort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if(data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                // 排序好提前结束循环，优化
                break;
            }
        }
        return data;
    }
}
