package org.indolphin.algorithm;

/**
 * 八皇后问题
 * 递归与回溯
 *
 * @author hongyan
 */
public class QueueEight {

    private int number = 8;
    int[] array = new int[number];
    static int count = 0;

    public int getCount() {
        return count;
    }

    /**
     * 放置第n个皇后（0-7）
     * @param n 第n个皇后
     */
    public void check(int n) {
        // n=number的时候，其实都已经放置好，从0开始（0-7）
        if(n == number) {
            print();
            count++;
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for(int i=0;i<number;i++){
            // 先把当前皇后放入该行第一列
            array[n] = i;
            if(judge(n)) {
                check(n+1);
            }
            // 如果冲突，就继续执行array[n]=i;即将第n个皇后，放置在本行的后移的一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 第n个皇后
     * @return
     */
    public boolean judge(int n) {
        for(int i=0;i<n;i++) {
            // 两个皇后在同一列 或者 在 同一斜对角
             if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                 return false;
             }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("------------------------------");
    }
}
