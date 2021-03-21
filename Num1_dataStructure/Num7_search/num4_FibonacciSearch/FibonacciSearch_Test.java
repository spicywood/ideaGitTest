package Num1_dataStructure.Num7_search.num4_FibonacciSearch;

import java.util.Arrays;

/**
 * 斐波那契查找原理与前两种相似，仅仅改变了中间结点（mid）的位置，mid不再是中间或插值得到，而是位于黄金分割点附近，即mid=low+F(k-1)-1
 *
 * 对F(k-1)-1的理解：
 * 由斐波那契数列 F[k]=F[k-1]+F[k-2] 的性质，可以得到 （F[k]-1）=（F[k-1]-1）+（F[k-2]-1）+1 。
 * 该式说明：只要顺序表的长度为F[k]-1，则可以将该表分成长度为F[k-1]-1和F[k-2]-1的两段，即如上图所示。从而中间位置为mid=low+F(k-1)-1
 *
 * 类似的，每一子段也可以用相同的方式分割
 * 但顺序表长度n不一定刚好等于F[k]-1，所以需要将原来的顺序表长度n增加至F[k]-1。
 * 这里的k值只要能使得F[k]-1恰好大于或等于n即可，由以下代码得到,顺序表长度增加后，新增的位置（从n+1到F[k]-1位置），都赋为n位置的值即可。
 */
public class FibonacciSearch_Test {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int index = fibSearch(arr, 1234);
        System.out.println(index);
    }

    public static int[] fibArr(){
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2;i < maxSize;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        //System.out.println(Arrays.toString(fib));
        return fib;
    }

    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;      //表示斐波那契分割数值的下标
        int mid = 0;    //存放mid值
        int[] fibArr = fibArr();
        //获取到fib分割数值的下标
        while(high > fibArr[k] - 1){
            k++;
        }
        //因为fib[k]的值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr,fibArr[k]);
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //找到key
        while (low <= high) { // 只要这个条件满足，就可以找
            mid = low + fibArr[k - 1] - 1;
            if(key < temp[mid]) { //我们应该继续向数组的前面查找(左边)
                high = mid - 1;
                //k--
                //说明
                //1.全部元素 = 前面的元素 + 后边元素
                //2.f[k] = f[k-1] + f[k-2]
                //因为前边有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                //即在f[k-1]的前面继续查找 k--
                //即下次循环mid = f[k-1-1] - 1
                k--;
            } else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high){
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
