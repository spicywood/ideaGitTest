package Num1_dataStructure.Num9_tree.num4_bianrySort;

/*
    二叉排序树：BST: (Binary Sort(Search) Tree), 对于二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大。
    特别说明：如果有相同的值，可以将该节点放在左子节点或右子节点
 */
public class binarySort_Test {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        tree.infixOrder();
        tree.delNode(1);
        System.out.println();
        tree.infixOrder();
    }
}

class BinarySortTree{
    private Node root;
    public void add(Node node){
        if (root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉排序树BTS为空，无法遍历");
        }
    }

    public Node search(int value){
        if (root == null){
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root == null){
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            Node parentNode = searchParent(value);
            if (targetNode.left == null && targetNode.right == null){
                if (parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value){
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                if (targetNode.left != null){
                    if (parentNode.left.value == value){
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else{
                    if (parentNode.left.value == value){
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }
}


class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    //递归形式添加节点
    public void add(Node node){
        if (node == null){
            return;
        }
        else {
            if (node.value < this.value){
                if (left == null){
                    left = node;
                } else {
                    left.add(node);
                }
            } else {
                if (right == null){
                    right = node;
                } else {
                    right.add(node);
                }
            }
        }
    }

    public Node search(int value){
        if (value == this.value){
            return this;
        } else if (value < this.value){
            if (left == null){
                return null;
            } else {
                return left.search(value);
            }
        } else{
            if (right == null){
                return null;
            } else {
                return right.search(value);
            }
        }

    }

    public Node searchParent(int value){
        if ((this.left != null && left.value == value)||(this.right != null && right.value == value)){
            return this;
        } else {
            if (value < this.value && left != null){
                return left.searchParent(value);
            } else if (value >= this.value && right != null){
                return right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (left != null){
            left.infixOrder();
        }
        System.out.println(this.toString());
        if (right != null){
            right.infixOrder();
        }
    }
}