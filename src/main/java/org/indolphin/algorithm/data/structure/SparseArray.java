package org.indolphin.algorithm.data.structure;

import java.util.Arrays;

/**
 * 稀疏数组
 * @author hongyan
 */
public class SparseArray {

    private int[][] data;

    /**
     * constructor
     * @param data array data
     * @param flag whether is sparse or not
     */
    public SparseArray(int[][] data, boolean flag) {
        /**
         * 二维数组 转 稀疏数组
         * 1、遍历 原始的二维数组 得到有效数据的个数 sum
         * 2、根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
         * 3、将二维数组的有效数组数据存入到稀疏数组
         */
        if(flag) {
            this.data = data;
        } else {
            int height = data.length;
            int weight = data[0].length;
            int count = 0;
            // 获取非空值的个数
            for(int i = 0;i<height;i++) {
                for(int j=0;j<weight;j++) {
                    if(data[i][j] != 0) {
                        count++;
                    }
                }
            }

            // 创建稀疏数组
            int[][] sparseArray = new int[count+1][3];
            int index = 0;
            for(int i = 0;i<weight;i++) {
                for(int j = 0;j<height;j++) {
                    if(data[i][j] != 0) {
                        index++;
                        sparseArray[index][0] = i;
                        sparseArray[index][1] = j;
                        sparseArray[index][2] = data[i][j];
                    }
                }
            }

            this.data = sparseArray;
        }
    }

    /**
     * convert sparse array to general array
     * @return general array
     */
    public int[][] getGeneralArray() {
        /**
         * 稀疏数组转原始的二维数组的思路
         * 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         * 2、在读取稀疏数组后几行的数据，并付给
         */
        int height = this.data[0][0];
        int weight = this.data[0][1];
        int count = this.data[0][2];

        int[][] res = new int[height][weight];
        for(int i = 1;i<=count;i++) {
            res[this.data[i][0]][this.data[i][1]] = this.data[i][2];
        }
        return res;
    }

    /**
     * get sparse array data
     * @return sparse array
     */
    public int[][] getSparseArray() {
        return data;
    }
}
