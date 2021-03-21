package Num1_dataStructure.Num8_table.num1_hash;

public class HashTable {
    private int size;
    private EmployeeLinkedList[] empLinkedListArray;

    //构造器
    public HashTable(int size){
        this.size = size;

        //初始化
        empLinkedListArray = new EmployeeLinkedList[size];

        //不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee emp){
        //根据员工的id得到该员工应当添加到那条链表
        int index = hashFun(emp.id);
        empLinkedListArray[index].add(emp);
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }

    //遍历所有的链表，遍历HashTable
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    
    public Employee findById(int id){
        int index = hashFun(id);
        //使用散列函数确定链表
        Employee employee = empLinkedListArray[index].findById(id);
        if (employee == null){
            System.out.println("未找到目标值");
            return null;
        }
        System.out.println(employee.toString());
        return employee;
    }
}
