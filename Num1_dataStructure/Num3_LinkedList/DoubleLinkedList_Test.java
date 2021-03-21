package Num1_dataStructure.Num3_LinkedList;

/**
 * 使用带head头的双向链表实现 –水浒英雄排行榜
 * 管理单向链表的缺点分析:
 * 单向链表，查找的方向只能是一个方向，而双向链表可以向前或者向后查找。
 * 单向链表不能自我删除，需要靠辅助节点 ，而双向 链表，则可以自我删除，所以前面我们单链表删除时节点，总是找到temp,temp是待删除节点的前一 个节点(认真体会).
 */

/**
 * 分析 双向链表的遍历，添加，修改，删除的操作思路===》代码实现
 * 1) 遍历 方和 单链表一样，只是可以向前，也可以向后查找
 * 2) 添加 (默认添加到双向链表的最后)
 *      (1) 先找到双向链表的最后这个节点
 *      (2) temp.next = newHeroNode
 *      (3) newHeroNode.pre = temp;
 * 3) 修改 思路和 原来的单向链表一样.
 * 4) 删除
 *      (1) 因为是双向链表，因此，我们可以实现自我删除某个节点
 *      (2) 直接找到要删除的这个节点，比如temp
 *      (3)  temp.pre.next = temp.next
 *      (4) temp.next.pre = temp.pre;
 */
public class DoubleLinkedList_Test {

    public static void main(String[] args) {
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        System.out.println("双向链表的测试：");

        DoubleLinkedList dl = new DoubleLinkedList();

        dl.add(hero1);
        dl.add(hero2);
        dl.add(hero3);
        dl.add(hero4);

        dl.list();
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");

        dl.update(newHeroNode);
        System.out.println("修改后：");
        dl.list();

        dl.delete(3);
        System.out.println("删除后：");
        dl.list();
    }




}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }


    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp = head;

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
        //形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;

    }

    //遍历双向链表的方法，显示链表
    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head;
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next= temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在该节点");
        }
    }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;       //指向下一个节点，默认为null
    public HeroNode2 pre;        //指向前一个节点，默认为null

    public HeroNode2(int hNo,String name,String nickname){
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