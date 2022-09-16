package org.jon.lv.test;

import java.util.*;
import java.util.function.Function;

public class FunctionUtil {

    private static Map<String, Function<List<Integer>, Integer>> functionMap = new HashMap<>();

    // 静态代码块，初始化MAP结构，定义所需要的计算方式
    static {
        functionMap.put("SUM",list -> list.stream().reduce(0,Integer::sum));
        functionMap.put("MIN",data -> data.stream().min(Comparator.comparingInt(o->o)).orElse(null));
        functionMap.put("MAX",data -> data.stream().max(Comparator.comparingInt(o->o)).orElse(null));
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer min = functionMap.get("MIN").apply(list);
        Integer max = functionMap.get("MAX").apply(list);
        Integer sum = functionMap.get("SUM").apply(list);

        System.out.println("min =" + min + "," + "max =" + max + "," + "sum =" + sum);
    }

}
