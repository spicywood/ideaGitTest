package Num1_dataStructure.Num9_tree.num1_binary.no1_sequence;

public class binaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public HeroNode preSearch(int id){
        if (this.root != null){
            return this.root.preSearch(id);
        } else {
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }
    //中序遍历
    public HeroNode infixSearch(int id){
        if (this.root != null){
            return this.root.infixSearch(id);
        } else {
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }
    //后序遍历
    public HeroNode postSearch(int id){
        if (this.root != null){
            return this.root.postSearch(id);
        } else {
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }

    public void delete(int id){
        if (root != null){
            if (root.getId() == id){
                root = null;
            } else {
                root.delete(id);
            }
        }
        else {
            System.out.println("树为空，无法删除");
        }
    }

}
