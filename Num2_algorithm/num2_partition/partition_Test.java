package Num2_algorithm.num2_partition;

/*
    分治算法(Divide-and-Conquer)的基本思想是将一个规模为N的问题分解为K个规模较小的子问题，
    这些子问题相互独立且与原问题性质相同。求出子问题的解，就可得到原问题的解。
    即一种分目标完成程序算法，简单问题可用二分法完成。
 */
public class partition_Test {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    //汉诺塔移动方案
    //使用分治算法
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的盘 2. 上面的盘
            //1.先把最上面的所有盘A->B，移动过程会使用到C
            hanoiTower(num - 1,a,c,b);
            //2.把最下边的盘 A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3.把B塔的所有盘从 B->C,移动过程用到a塔
            hanoiTower(num - 1,b,a,c);
        }
    }
}
