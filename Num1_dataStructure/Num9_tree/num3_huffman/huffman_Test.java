package Num1_dataStructure.Num9_tree.num3_huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree), 还有的书翻译为霍夫曼树。
 *
 * 赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近
 */
public class huffman_Test {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        createHuffmanTree(arr);
    }

    public static Node createHuffmanTree(int[] arr){
        //遍历arr数组
        //将arr的每个元素构成一个Node
        //将Node放入ArrayList中
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            list.add(node);
        }
        Collections.sort(list);

        while (list.size() != 1){
            System.out.println(list.toString());
            //取出根节点权值最小的两颗二叉树
            Node left = list.get(0);
            Node right = list.get(1);

            Node parent = new Node(left.value + right.value);
            parent.leftNode = left;
            parent.rightNode = right;

            list.remove(left);
            list.remove(right);

            list.add(parent);
            Collections.sort(list);
        }
        System.out.println(list);
        return list.get(0);
    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        } else {
            System.out.println("空树，无法遍历");
        }
    }
}

//创建节点类
//为了使Node对象持续排序Collections几个排序
//让Node实现Comparable接口
class Node implements Comparable<Node>{
    int value;      //节点权值
    char chr;       //字符
    Node leftNode;  //左子节点
    Node rightNode;  //右子节点

    //写一个前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode != null){
            this.leftNode.preOrder();
        }

        if (this.rightNode != null){
            this.rightNode.preOrder();
        }
    }

    public Node(int value){
        this.value = value;
    }

    @Override
    public String  toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    //compareTo就是比较两个值，如果前者大于后者，返回1，等于返回0，小于返回-1
    /*
    注意事项：

        1模型必须实现Comparable<T>接口

        2Collections.sort(list);会自动调用compareTo，如果没有这句，list是不会排序的，也不会调用compareTo方法

        3如果是数组则用的是Arrays.sort(a)方法
     */
    public int compareTo(Node node) {
        //从小到大进行排序
        return this.value - node.value;
    }
}
