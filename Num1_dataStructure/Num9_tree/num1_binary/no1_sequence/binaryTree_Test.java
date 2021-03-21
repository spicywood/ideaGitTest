package Num1_dataStructure.Num9_tree.num1_binary.no1_sequence;

public class binaryTree_Test {
    /*
        前序遍历: 先输出父节点，再遍历左子树和右子树
        中序遍历: 先遍历左子树，再输出父节点，再遍历右子树
        后序遍历: 先遍历左子树，再遍历右子树，最后输出父节点

        小结: 看输出父节点的顺序，就确定是前序，中序还是后序
     */

    public static void main(String[] args) {
        binaryTree tree = new binaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "公孙胜");
        HeroNode node5 = new HeroNode(5, "关胜");

        tree.setRoot(root);

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //测试，前序遍历
        tree.preOrder();
        System.out.println("===================================");
        //测试，中序遍历
        tree.infixOrder();
        System.out.println("===================================");
        //测试，后序遍历
        tree.postOrder();


        System.out.println("===================================");

        //测试，前序查找
        System.out.println(tree.preSearch(3));
        System.out.println("===================================");

        //测试，中序查找
        System.out.println(tree.infixSearch(4));
        System.out.println("===================================");
        //测试，后序查找
        System.out.println(tree.postSearch(6));
        System.out.println("===================================");

        tree.delete(5);
        tree.preOrder();
    }


}

