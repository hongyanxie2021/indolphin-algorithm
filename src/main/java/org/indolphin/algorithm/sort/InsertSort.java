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
            int num = data[i];
            int index = i;
            while (index > 0 && num < data[index-1]) {
                data[index] = data[index-1];
                index--;
            }
            if(index != i) {
                data[index] = num;
            }
        }
        return data;
    }
}
