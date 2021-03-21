package Num6_sort.num1_bubble;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class bubble_Test {
    public static void main(String[] args) {
        /*  进行80000的时间测试
        //测试冒泡排序速度O(n^2)，给80000数据测试
        int[] arrTest = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arrTest[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String start = format.format(date1);
        System.out.println(start);

        bubbleSort(arrTest);

        Date date2 = new Date();
        String end = format.format(date2);
        System.out.println(end);

         */

        int[] arr = {3,9,-1,10,20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void bubbleSort(int[] arr){
        //第一趟排序，将最大的数排在最后
        int temp = 0;   //临时变量
        boolean flag = false;
        for (int j=0;j<arr.length-1;j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            //System.out.printf("第%d次排序后的数组：",j+1);
            //System.out.println(Arrays.toString(arr));

            if (!flag){     //无位置交换，已经排好序，直接退出
                break;
            } else {
                flag = false;
            }
        }
    }
}
