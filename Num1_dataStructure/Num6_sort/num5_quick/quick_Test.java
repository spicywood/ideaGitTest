package Num6_sort.num5_quick;

import java.util.Arrays;

public class quick_Test {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};

        quickSort(arr,0,arr.length-1);

        System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int indexL = left;
        int indexR = right;
        //pivot中轴
        int pivot = arr[(indexL + indexR)/2];

        int temp = 0;
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (indexL < indexR){
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[indexL] < pivot){
                indexL += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[indexR] > pivot){
                indexR -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (indexL >= indexR){
                break;
            }

            temp = arr[indexL];
            arr[indexL] = arr[indexR];
            arr[indexR] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[indexL] == pivot){
                indexR--;
            }

            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[indexR] == pivot){
                indexL++;
            }
        }
        if (indexL == indexR){
            indexL++;
            indexR--;
        }

        //向左递归
        if(left < indexR) {
            quickSort(arr, left, indexR);
        }
        //向右递归
        if(right > indexL) {
            quickSort(arr, indexL, right);
        }
    }
}
