package Num6_sort.num1_bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble_Sort1 {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        //第一趟排序，将最大的数排在最后
        int temp = 0;   //临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一次排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第二趟排序，将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二次排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第二趟排序，将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 1 - 1; i++) {
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第三次排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第二趟排序，将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 1 - 1 - 1; i++) {
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第四次排序后的数组：");
        System.out.println(Arrays.toString(arr));
    }
}
