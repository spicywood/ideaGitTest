package Num2_algorithm.num5_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/*
    贪心算法介绍

        贪婪算法(贪心算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的算法

        贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果

 */
public class greedy_Test {
    public static void main(String[] args) {
        //以广播电台为例
        HashMap<String, HashSet> broadcasts = new HashMap<>();

        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadcasts.put("K1",set1);
        broadcasts.put("K2",set2);
        broadcasts.put("K3",set3);
        broadcasts.put("K4",set4);
        broadcasts.put("K5",set5);

        //存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("广州");
        allAreas.add("大连");
        allAreas.add("杭州");
        allAreas.add("深圳");

        //创建ArrayList，存放选择的集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<String>();

        //定义一个maxKey，保存在一次遍历过程中能够覆盖最大未覆盖地区对应的电台的key
        //如果maxKey不为null，则会加入到selects
        String maxKey;
        while (allAreas.size() != 0){
            //每进行一次while，需要maxKey置空
            maxKey = null;
            //遍历broadcast
            for (String key:broadcasts.keySet()){
                tempSet.clear();
                //当前key所覆盖的地区
                HashSet areas = broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);        //取出两个tempSet和allAreas的交集赋给tempSet
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }

            }
            if (maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas清除掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是" + selects);
    }
}
