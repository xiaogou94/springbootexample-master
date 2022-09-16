package org.jon.lv.test;

import java.util.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/26 10:05
 * @Description:
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("X");

        Collection<String> clist = Collections.unmodifiableList(list);

        clist.add("y");

        System.out.println(list.size());

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            it.remove();
        }
    }
}
