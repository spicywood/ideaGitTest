package Num6_sort.num4_shell;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class shell_Test {
    public static void main(String[] args) {
        //int[] arr = {8,9,1,7,2,3,5,4,6,0};

        // 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        //System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

    }

    //使用逐步推导的方式来编写希尔排序(交换法)
    public static void shellSort1(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2;gap > 0; gap /= 2){
            //第一轮排序，将10个数据分成5个
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共5组)，步长为5
                for (int j = i-gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            //System.out.println(Arrays.toString(arr));
        }

    }

    //交换法变为移位法
    public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while时，就给temp找到了插入位置
                    arr[j] = temp;
                }
            }
        }
    }
}
