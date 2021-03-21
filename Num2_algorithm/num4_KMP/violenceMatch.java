package Num2_algorithm.num4_KMP;

public class violenceMatch {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";

        int index = violenceMatch(str1, str2);
        System.out.println(index);
    }

    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int strLen1 = s1.length;
        int strLen2 = s2.length;

        int i = 0;      //i索引指向s1
        int j = 0;      //i索引指向s2

        while (i < strLen1 && j < strLen2){     //保证匹配时不越界
            if (s1[i] == s2[j]){
                i++;
                j++;
            } else {    //如果没有成功
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == strLen2){
            return i - j;
        } else {
            return -1;
        }
    }
}
