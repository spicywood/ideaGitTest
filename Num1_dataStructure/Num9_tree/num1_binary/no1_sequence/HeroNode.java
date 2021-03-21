package Num1_dataStructure.Num9_tree.num1_binary.no1_sequence;

public class HeroNode {
    private int id;
    private String name;

    private HeroNode left;      //默认null
    private HeroNode right;     //默认null

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        //先输出父节点
        System.out.println(this.toString());
        //递归向左子树
        if (left != null){
            left.preOrder();
        }
        //递归向右子树前序遍历
        if (right != null){
            right.preOrder();
        }

    }

    //编写中序遍历的方法
    public void infixOrder(){
        //递归向左子树
        if (left != null){
            left.infixOrder();
        }
        //输出父节点
        System.out.println(this.toString());

        //递归向右子树中序遍历
        if (right != null){
            right.infixOrder();
        }

    }

    //编写后序遍历的方法
    public void postOrder(){
        //递归向左子树
        if (left != null){
            left.postOrder();
        }
        //递归向右子树后序遍历
        if (right != null){
            right.postOrder();
        }
        //输出父节点
        System.out.println(this.toString());

    }

    public HeroNode preSearch(int id){
        if (id == this.id){
            return this;
        }

        HeroNode resNode = null;

        if (left != null){
            resNode = left.preSearch(id);
        }
        if (resNode != null){
            return resNode;
        }
        if (right != null){
            resNode = right.preSearch(id);
        }
        return resNode;
    }

    public HeroNode infixSearch(int id){
        HeroNode resNode = null;
        if (left != null){
            resNode = left.preSearch(id);
        }
        if (resNode != null){
            return resNode;
        }

        if (id == this.id){
            return this;
        }

        if (right != null){
            resNode = right.preSearch(id);
        }
        return resNode;
    }

    public HeroNode postSearch(int id){
        HeroNode resNode = null;
        if (left != null){
            resNode = left.preSearch(id);
        }
        if (resNode != null){
            return resNode;
        }
        if (right != null){
            resNode = right.preSearch(id);
        }
        if (resNode != null){
            return resNode;
        }

        if (id == this.id){
            return this;
        }
        return resNode;
    }

    //递归删除节点
    public void delete(int Fid){
        if (left != null && left.id == Fid){
            left = null;
            return;
        }
        if (right != null && right.id == Fid){
            right = null;
            return;
        }
        if (left != null){
            left.delete(Fid);
        }
        if (right != null){
            right.delete(Fid);
        }
    }
}
