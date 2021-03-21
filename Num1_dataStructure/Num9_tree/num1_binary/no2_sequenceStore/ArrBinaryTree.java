package Num1_dataStructure.Num9_tree.num1_binary.no2_sequenceStore;

public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }
    /**
     * 二叉树的前序存储
     * @param index 数组的下标
     */
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序方式遍历");
            return;
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if ((2 * index + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }
}
