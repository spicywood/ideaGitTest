package Num1_dataStructure.Num3_LinkedList;

public class Josephus {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
        list.countBoy(1,2,5);
    }
}

//创建一个环形的单项链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建一个环形列表
    public void addBoy(int nums){
        //nums 做一个数据校验
        if (nums < 1){
            System.out.println("nums的值不正确");
        }

        Boy curBoy = null;      //辅助指针帮助构建环形链表

        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() == first){
                //已经遍历结束
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param startNo   从第几个小孩开始数数
     * @param countNum  数几下
     * @param nums      最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有问题，请重新输入");
            return;
        }
        //创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                //说明指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j=0;j<startNo-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时的移动m-1次，然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first){
                break;
            }
            //让first和helper指针同时的移动countNum-1次，然后出圈
            for (int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个小孩的编号是：%d\n",first.getNo());
    }
}


//创建一个Boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no){
        this.no = no;
    }
}