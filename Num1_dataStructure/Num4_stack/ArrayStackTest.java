package Num4_stack;

import java.util.Scanner;

/**
 * 栈的英文为(stack)
 * 栈是一个先入后出(FILO-First In Last Out)的有序列表。
 * 栈(stack)是限制线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表。允许插入和删除的一端，为变化的一端，称为栈顶(Top)，另一端为固定的一端，称为栈底(Bottom)。
 * 根据栈的定义可知，最先放入栈中元素在栈底，最后放入的元素在栈顶，而删除元素刚好相反，最后放入的元素最先删除，最先放入的元素最后删除
 *
 * 名词：出栈pop  入栈push
 *
 * 栈的应用场景：
 *  子程序的调用：在跳往子程序前，会先将下个指令的地址存到堆栈中，直到子程序执行完后再将地址取出，以回到原来的程序中。
 *  处理递归调用：和子程序的调用类似，只是除了储存下一个指令的地址外，也将参数、区域变量等数据存入堆栈中。
 *  表达式的转换[中缀表达式转后缀表达式]与求值(实际解决)。
 *  二叉树的遍历。
 *  图形的深度优先(depth一first)搜索法。
 *
 *  实现栈的思路分析
 *      1. 使用数组来模拟栈
 *      2. 定义一个 top  来表示栈顶，初始化 为  -1
 *      3. 入栈的操作，当有数据加入到栈时， top++;  stack[top] = data;
 *      4. 出栈的操作，int value = stack[top]; top--, return value
 */
class ArrayStackTest{
    public static void main(String[] args) {
        ArrayStack stack  = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;        //控制是否退出菜单

        while (loop){
            System.out.println("show:显示栈");
            System.out.println("push:添加数据");
            System.out.println("pop:取出信息");
            System.out.println("exit:退出程序");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int popValue = stack.pop();
                        System.out.printf("出栈的数据为%d\n",popValue);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case "exit":
                    scanner.close();        //scanner一定要关闭
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}




//定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;        //表示栈的大小
    private int[] stack;        //数组，数组模拟栈，数据放在该数组
    private int top = -1;       //top表示栈顶，初始化为-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1 ;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //入栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况
    public void show(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

}
