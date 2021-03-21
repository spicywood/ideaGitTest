package Num1_dataStructure.Num2_Queue;

/**
 * 队列介绍：
 *      队列是一个有序列表，可以用数组（顺序存储）或是链表（链式存储）来实现。
 *      遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出
 *
 * 数组模拟队列：
 *      队列本身是有序列表，若使用数组的结构来存储队列的数据，则队列数组的声明如下图, 其中 maxSize 是该队列的最大容量。
 *      因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front及 rear分别记录队列前后端的下标，front 会随着数据输出而改变，而 rear则是随着数据输入而改变
 */

import java.util.Scanner;

/**
 * 当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：思路分析
 *      将尾指针往后移：rear+1 , 当front == rear 【空】
 *      若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。 rear  == maxSize - 1[队列满]
 *
 *
 */
public class queue_Test {
    public static void main(String[] args) {
        //创建一个对象
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头数据");

            key = sc.next().charAt(0);

            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n",res);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;        //表示数组最大容量
    private int front;          //队列头
    private int rear;           //队列尾
    private int[] arr;          //该数据用于存放数据，模拟队列

    //创建队列的模拟器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;     //指向队列头部,分析出front是指向队列头的前一个位置（还没有数据）
        rear = -1;      //指向队列尾部,指向队列尾的数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;    //rear后移，并添加数据n
    }

    //获取队列数据，出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }

        return arr[front+1];
    }
}