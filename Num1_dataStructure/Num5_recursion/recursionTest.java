package Num5_recursion;

/**
 * 递归演示
 * 递归就是方法自己调用自己,每次调用时传入不同的变量.递归有助于编程者解决复杂的问题,同时可以让代码变得简洁
 *
 * 递归需要遵守的重要规则
 * 执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
 * 方法的局部变量是独立的，不会相互影响, 比如n变量
 * 如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
 * 递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死龟了:)
 * 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
 *
 * 递归调用规则：
 * 1. 当程序执行到一个方法时，就会开辟一个独立的空间(栈)
 * 2. 每个空间的数据(局部变量)，是独立的.
 */
public class recursionTest {
    public static void main(String[] args) {

        //test(10);

        int res = factorial(3);
        System.out.println("res = " + res);
    }

    //打印问题
    public static void test(int n){
        if (n > 2){
            test(n-1);
        }
        System.out.println("n=" + n);
    }

    //阶乘问题
    public static int factorial(int n){
        if (n==1){
            return 1;
        } else{
            return factorial(n - 1) * n;
        }
    }
}
