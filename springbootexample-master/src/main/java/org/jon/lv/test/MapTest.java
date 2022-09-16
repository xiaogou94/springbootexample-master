package org.jon.lv.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/10 14:34
 * @Description: 遍历Map
 */
public class MapTest {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");

        // 获取所有键的集合map.keySet()
        Set<String> mapkeys = map.keySet();
        for (String key: mapkeys) {
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }


        // 获取所有键值对对象
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey() + "------" + entry.getValue());
        }
    }


}
