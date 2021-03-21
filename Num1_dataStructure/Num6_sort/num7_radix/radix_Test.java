package Num6_sort.num7_radix;

import java.util.Arrays;

public class radix_Test {
    public static void main(String[] args) {
        //基数排序、桶排序
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    /**
     * 基数排序会额外消耗内存，属于空间换时间
     * @param arr
     */
    public static void radixSort(int[] arr){
        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法

        int[][] bucket = new int[10][arr.length];
        int index = 0;

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        int max = 0;
        for (int i = 0;i < arr.length;i++){
            max = arr[0];
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int length = (max + "").length();

        for (int time = 0;time < length;time++){
            for (int j=0;j< arr.length;j++){
                int digitOfElement = (int) (arr[j] / Math.pow(10,time) % 10);
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            index = 0;
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            for (int i = 0; i < bucket.length; i++) {
                if (bucketElementCounts[i] != 0){
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                bucketElementCounts[i] = 0;
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
