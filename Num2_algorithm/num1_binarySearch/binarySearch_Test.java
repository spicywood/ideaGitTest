package Num2_algorithm.num1_binarySearch;

/*
    二分查找算法(非递归)介绍

    前面我们讲过了二分查找算法，是使用递归的方式，下面我们讲解二分查找算法的非递归方式
    二分查找法只适用于从有序的数列中进行查找(比如数字和字母等)，将数列排序后再进行查找
    二分查找法的运行时间为对数时间O(㏒₂n) ，即查找到需要的目标位置最多只需要㏒₂n步，
    假设从[0,99]的队列(100个数，即n=100)中寻到目标数30，则需要查找步数为㏒₂100 , 即最多需要查找7次( 2^6 < 100 < 2^7)

 */
public class binarySearch_Test {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = bianrySearch(arr, 10);
        System.out.println("index = " + index);
    }

    /**
     *
     * @param arr   待查找的数组
     * @param target    需要查找的数
     */
    public static int bianrySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
