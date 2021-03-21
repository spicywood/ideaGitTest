package Num1_dataStructure.Num4_stack;

public class Calculator {
    public static void main(String[] args) {
        //表达式运算
        String expression = "3+2*6-2";
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0;      //用于扫描
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int result = 0;
        char ch = ' ';      //每次保存的char保存到ch
        String keepNum = "";
        //开始while循环的扫描
        while (true){
            //依次得到字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断
            if (ArrayStack2.isOperator(ch)){
                if (!operatorStack.isEmpty()){
                    //如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        result = numStack.cal(num1,num2,operator);
                        //再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                        numStack.push(result);
                        operatorStack.push(ch);
                    } else{

                        operatorStack.push(ch);
                    }

                } else {
                    operatorStack.push(ch);
                }
            } else{
                //numStack.push(ch - 48);
                //1.当处理多位数时，不能发现是一个数就立刻入栈，因为他可能是多位数
                //2.在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                //3.因此我们需要定义一个变量字符串，用于拼接

                //处理多位数
                keepNum += ch;

                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符则入栈
                    if (ArrayStack2.isOperator(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }


            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        while (true){
            if (operatorStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            result = numStack.cal(num1,num2,operator);

            numStack.push(result);
        }
        System.out.printf("表达式%s = %d",expression,numStack.pop());

    }
}

class ArrayStack2{
    private int maxSize;        //表示栈的大小
    private int[] stack;        //数组，数组模拟栈，数据放在该数组
    private int top = -1;       //top表示栈顶，初始化为-1

    public ArrayStack2(int maxSize){
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

    //出栈
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

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    //数字越大，则优先级就越高
    public int priority(int operator){
        if (operator == '*' || operator == '/'){
            return 1;
        }
        else if (operator == '+' || operator == '-'){
            return 0;
        }
        else{
            //假定只有+，-，*，/
            return -1;
        }
    }

    //判断是不是一个运算符
    public static boolean isOperator(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;   //注意顺序，num1先出栈，是后入栈的数字
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    public int peek(){
        return stack[top];
    }
}