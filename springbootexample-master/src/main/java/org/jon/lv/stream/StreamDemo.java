package org.jon.lv.stream;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/16 15:09
 * @Description:
 */
public class StreamDemo {
    public static void main(String[] args) {
        mockException();
//        List<Integer> list = Stream.of(1,2,3,4,5).filter(integer -> integer > 3).collect(Collectors.toList());
//        System.out.println(list);
    }

    public static String mockException() {
        try {
            System.out.println("aaa");
        } catch (Exception e) {
            System.out.println("bbb");
            e.printStackTrace();
        }
        return "ok";
    }
}
