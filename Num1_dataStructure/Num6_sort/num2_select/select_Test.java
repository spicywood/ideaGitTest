package Num6_sort.num2_select;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序（select sorting）也是一种简单的排序方法。
 * 基本思想：
 * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，
 * ......
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，
 * ......
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class select_Test {
    public static void main(String[] args) {
        //int[] arr = {101,34,119,1};
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSortMine(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);



    }

    public static void selectSortMine(int[] arr){
        int temp = arr[0];
        int index = 0;
        for (int j=0;j < arr.length - 1;j++) {
            for (int i = 1 + j; i < arr.length; i++) {
                if (temp > arr[i]){
                    index = i;
                    temp = arr[index];
                }
            }
            arr[index] = arr[j];
            arr[j] = temp;
            index = j+1;
            temp = arr[index];
            //System.out.println("第" + (j+1) + "次:");
            //System.out.println(Arrays.toString(arr));
        }
        //System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int[] arr) {


        //在推导的过程，我们发现了规律，因此，可以使用for来解决
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            //System.out.println("第"+(i+1)+"轮后~~");
            //System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }

}
