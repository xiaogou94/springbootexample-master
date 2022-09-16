package org.jon.lv.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Test {

    private static Map<Integer, Function<List<User>, String>> actionMappings = new HashMap<>();

    static {
        actionMappings.put(1,(User) -> test1(User));
        actionMappings.put(2,(User) -> test2(User));
        actionMappings.put(3,(User) -> test3(User));
    }

    private static String test1(List<User> user) {
        System.out.println("test1");
        return "test1";
    }
    private static String test2(List<User> user) {
        return "test2";
    }
    private static String test3(List<User> user) {
        return "test3";
    }


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setAccount("1");
        user.setAccountType("1");
        users.add(user);
        actionMappings.get(1).apply(users);
    }

}

