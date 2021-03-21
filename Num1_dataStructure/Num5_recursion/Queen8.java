package Num5_recursion;

import java.util.Arrays;

/**
 * 八皇后问题：
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即：
 * 任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 */
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen = new Queen8();
        queen.check(0);
        System.out.println(count);
    }

    //放置第n个皇后
    private void check(int n){
        if (n == max){  //n=8，其实八皇后就已经放好了
            print();
            return;
        }

        //依次放入皇后
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行的后移的一个位置
        }
    }

    // 说明
    // 1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
    // 2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
    // n = 1  放置第 2列 1 n = 1 array[1] = 1
    // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
    // 3. 判断是否在同一行, 没有必要，n 每次都在递增
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //输出皇后摆放的位置
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] = %d\t",i,array[i]);
        }
        System.out.println();
    }
}
