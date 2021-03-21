package Num1_dataStructure.Num9_tree.num2_heap;

import java.util.Arrays;

/*
    堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。
    堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆, 注意 : 没有要求结点的左孩子的值和右孩子的值的大小关系。
    每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
*/
public class heap_Test {
    public static void main(String[] args) {
        //要求将数组进行升序排列
        int arr[] = {4,6,8,5,9,10,20};
        heapSort(arr);

    }

    public static void heapSort(int[] arr){
        int temp;
        System.out.println("堆排序操作");
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组调整成大顶堆

    /**
     * 完成将以i对应的非叶子节点的树调整成大顶堆
     * @param arr       待调整的数组
     * @param i         表示非叶子节点在数组中索引
     * @param length    表示对多少个元素继续调整
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = i*2+1;k<length;k=k*2+1){
            if (k+1 < length && arr[k] < arr[k+1]){     //说明左子节点小于右子节点
                k++;
            }
            if (arr[k] > temp){     //如果子节点大于父节点
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //for循环结束后，以i为父节点的树的最大值，放在了最顶（局部大顶堆）
        arr[i] = temp;
    }
}
