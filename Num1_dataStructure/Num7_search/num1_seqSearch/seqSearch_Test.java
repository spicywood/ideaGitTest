package Num1_dataStructure.Num7_search.num1_seqSearch;

public class seqSearch_Test {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr, 11);
        if (index == -1){
            System.out.println("没有找到");
        } else{
            System.out.println("找到，下标为：" + index);
        }
    }

    public static int seqSearch(int[] arr,int value){
        //线性查找是逐一排查，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
