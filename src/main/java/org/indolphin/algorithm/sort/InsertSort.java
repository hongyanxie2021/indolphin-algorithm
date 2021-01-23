package org.indolphin.algorithm.sort;

/**
 * 插入排序
 * 将数组分为 [有序部分] 和 [无序部分]
 * 将无序部分的数据取出放到有序部分的合适位置
 * @author hongyan
 */
public class InsertSort {

    public int[] sort(int[] data) {
        for(int i=1;i<data.length;i++) {
            int j = i;
            while (j> 0 && data[j] < data[j-1]) {
                int temp = data[j];
                data[j] = data[j-1];
                data[j] = temp;
                j--;
            }
        }
        return data;
    }
}
