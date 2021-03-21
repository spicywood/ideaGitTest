package Num1_dataStructure.Num3_LinkedList;

/**
 * 链表是有序的列表
 * 链表是以节点的方式来存储,是链式存储
 * 每个节点包含 data 域， next 域：指向下一个节点.
 * 链表的各个节点不一定是连续存储.
 * 链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定
 */

import java.util.Stack;

/**
 * 使用带head头的单向链表实现 –水浒英雄排行榜管理
 * 完成对英雄人物的增删改查操作， 注: 删除和修改,查找  可以考虑学员独立完成，也可带学员完成
 * 第一种方法在添加英雄时，直接添加到链表的尾部
 * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置 (如果有这个排名，则添加失败，并给出提示)
 */

public class SingleLinkedList_Test {
    //单链表测试
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(hero1);
        list.addByOrder(hero2);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.list();

        //测试修改
        HeroNode newHeroNode = new HeroNode(5, "晁盖", "托塔天王");
        HeroNode newHeroNode2 = new HeroNode(1, "宋江", "呼保义");
        list.update(newHeroNode);
        list.update(newHeroNode2);

        list.list();
        System.out.println(list.getLength(list.getHead()));
        HeroNode node1 = list.findNode(list.getHead(), 2);
        System.out.println(node1);
        list.delete(1);
        System.out.println("删除后：");
        System.out.println(list.getLength(list.getHead()));
        list.list();

        HeroNode node2 = list.findNode(list.getHead(), 2);
        System.out.println(node2);

        list.reverse(list.getHead());
        list.list();

    }


}

class SingleLinkedList{
    //先初始化一个头节点，头结点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 面试题1
     * 获取到单链表的节点的个数（如果是带头结点的链表，需求不统计头结点）
     */
    public int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;

            cur = cur.next;
        }
        return length;
    }

    /**
     * 面试题2
     * 查找单链表中的倒数第k个结点 【新浪面试题】
     * 思路：
     *  1.编写一个方法，接收head节点，同时接收index
     *  2.index表示倒数第index个节点
     *  3.先把链表从头到尾遍历，得到链表的总的长度
     *  4.得到size后，我们从链表的第一个开始遍历（size - index）个
     *  5.如果找到了，就返回该节点，否则返回null
     */
    public HeroNode findNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (true){
            length ++;
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        if ((length + 1 - index) < 0){
            return null;
        }else{
            int newIndex = 1;
            temp = head.next;
            while(newIndex < (length + 1 - index)){
                temp = temp.next;
                newIndex++;
            }

        }
        return temp;

    }

    /**
     * 面试题3
     * 单链表的反转【腾讯面试题，有点难度】
     * 思路：
     *  先定义一个节点reverseHead = new HeroNode();
     *  从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在原来的链表reverseHead的最前端
     *  从原来的链表head.next = reverseHead。next;
     * @param
     */
    public void reverse(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空，无法反转");
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null){
            next = cur.next;

            cur.next = reverseHead.next;

            reverseHead.next = cur;

            cur = next;
        }

        head.next = reverseHead.next;
    }

    /**
     * 面试题4
     * 从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】
     * 思路
     * 1. 上面的题的要求就是逆序打印单链表.
     * 2. 方式1：先将单链表进行反转操作，然后再遍历即可，这样的做的问题是会破坏原来的单链表的结构，不建议
     * 3. 方式2：可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果.
     */
    public void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur != null){
            stack.add(cur);

            cur = cur.next;
        }

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //添加节点到单向链表
    //当不考虑编号顺序时
    // 1.找到当前链表的最后节点
    // 2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;

        //遍历链表，找到最后
        while(true){
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;

        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true){
            //判断是否为链表最后
            if (temp == null){
                break;
            }

            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此仍然通过辅助指针来帮助找到添加的位置
        //因为单链表，因此temp是位于添加位置的前一个节点，否则添加不了
        HeroNode temp = head;
        boolean flag = false;   //标志添加的编号是否存在，默认为false
        while (true){
            if (temp.next == null){
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            } else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;       //后移
        }
        if (flag){
            System.out.printf("准备加入的英雄的编号%d已经存在，不能加入\n",heroNode.no);
        } else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else{
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newHeroNode.no);
        }

    }

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }
    }


}


//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;       //指向下一个节点

    public HeroNode(int hNo,String name,String nickname){
        this.no = hNo;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

