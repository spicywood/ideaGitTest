package Num1_dataStructure.Num7_search.num2_binarySearch;

import java.util.ArrayList;
import java.util.List;

public class binarySearch_Test {
    public static void main(String[] args) {
        int[] arr1 = {1,8,10,89,1000,1234};
        int result1 = binarySearch(arr1, 0, arr1.length - 1, 88);
        System.out.println("result = " + result1);

        int[] arr2 = {1,8,10,89,1000,1000,1000,1234};
        List<Integer> list = binarySearchMore(arr2, 0, arr2.length - 1, 1000);
        System.out.println("list = " + list);


    }

    /**
     * 二分查找算法
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //逐一该语句要放在前面
        if (left > right){
            return -1;
        }

        if (findVal > midValue) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midValue){
            return binarySearch(arr,left,mid - 1,findVal);
        } else{
            return mid;
        }
    }

    public static List<Integer> binarySearchMore(int[] arr, int left, int right, int findVal){
        //逐一该语句要放在前面
        if (left > right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];


        if (findVal > midValue) {
            return binarySearchMore(arr, mid + 1, right, findVal);
        } else if (findVal < midValue){
            return binarySearchMore(arr,left,mid - 1,findVal);
        } else{
            List<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;
            while(true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid + 1;

            while (true){
                if (temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
