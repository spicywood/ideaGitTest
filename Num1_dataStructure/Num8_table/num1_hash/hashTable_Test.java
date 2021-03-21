package Num1_dataStructure.Num8_table.num1_hash;

import java.util.Scanner;

public class hashTable_Test {
    //哈希表
    public static void main(String[] args) {
        //创建哈希表
        HashTable HashTab = new HashTable(7);
        //简单的菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = sc.next();
            switch (key){
                case "add":{
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    //创建雇员
                    Employee emp = new Employee(id,name);
                    HashTab.add(emp);
                    System.out.println("====================");
                    break;
                }
                case "list":{
                    HashTab.list();
                    System.out.println("====================");
                    break;
                }
                case "find":{
                    int id = sc.nextInt();
                    HashTab.findById(id);
                    System.out.println("====================");
                    break;
                }
                case "exit":{
                    sc.close();
                    /*
                        java的System.exit(0)和System.exit(1)区别。
                        System.exit(int  status)这个方法是用来结束当前正在运行中的java虚拟机。
                        status是非零参数，那么表示是非正常退出。
                        System.exit(0)是正常退出程序，而System.exit(1)或者说非0表示非正常退出程序。
                        在一个if-else判断中，如果我们程序是按照我们预想的执行，到最后我们需要停止程序，那么我们使用System.exit(0).
                        而System.exit(1)一般放在catch块中，当捕获到异常，需要停止程序，我们使用System.exit(1)。这个status=1是用来表示这个程序是非正常退出
                     */
                    System.exit(0);
                }
                default:
                    break;
            }
        }


    }
}
