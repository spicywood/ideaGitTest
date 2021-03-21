package Num3_LinkedList;

import java.util.Stack;

//演示栈Stack的基本使用
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //出栈
        while (stack.size() > 0){
            String str = stack.pop();
            System.out.println(str);
        }

    }
}
