package Num1_dataStructure.Num8_table.num1_hash;

//表示一条链表
public class EmployeeLinkedList {
    //头指针，执行第一个，因此我们这个链表的第一个head是直接指向第一个emp
    private Employee head;      //默认为null
    //添加雇员到链表
    //说明
    //1.假定添加雇员时，id是自增长，即id的分配总是从小到大
    public void add(Employee emp){
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个，就是用一个辅助指针，帮助定位到最后
        Employee curEmp = head;
        while(true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int num){
        if (head == null){
            //说明链表为空
            System.out.println("第" + (num+1) + "条链表为空");
            return;
        }
        System.out.println("第" + (num+1) + "条链表的信息为：");
        Employee curEmp = head;
        while (true){
            System.out.println(curEmp.toString());
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public Employee findById(int Fid){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Employee curEmp = head;
        while (true){
            if (curEmp.id == Fid){
                break;
            }
            if (curEmp.next == null){
                return null;
            }
        }
        return curEmp;
    }
}
