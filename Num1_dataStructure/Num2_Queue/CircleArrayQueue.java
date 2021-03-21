package Num1_dataStructure.Num2_Queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //创建一个对象
        CircleArray queue = new CircleArray(3);
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

/**
 * 问题分析并优化
 * 对前面的数组模拟队列的优化，充分利用数组.
 * 因此将数组看做是一个环形的。(通过取模的方式来实现即可)
 *
 * 分析说明：
 * 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的时候需要注意 (rear + 1) % maxSize == front 满]
 * rear == front [空]
 */
class CircleArray{

    private int maxSize;    //表示数组的最大容量

    //front就指向队列的第一个元素，也就是说front=0
    private int front;

    //rear指向最后一个元素的后一个位置，因为希望空出一位
    //rear初始值位0
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;

        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1) % maxSize == front;
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
        arr[rear] = n;    //rear后移，并添加数据n
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //先把front对应的值保留到一个临时变量
        //将front后移
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //求出当前队列有效数据个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空，没有数据");
        }

        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i]);
        }
    }

    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }

        return arr[front];
    }
}