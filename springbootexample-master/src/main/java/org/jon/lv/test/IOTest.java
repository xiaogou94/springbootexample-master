package org.jon.lv.test;

import java.io.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/11 12:51
 * @Description:
 */
public class IOTest {
    public static void main(String[] args) {

        char b[] = {0,1,2,3};
        int len = b.length - 1;
        String string = new String(b,0,len);
    }

    public static void count() throws IOException {
        File file = new File("C:\\User\\test.txt");
        InputStream is = null;
        is = new FileInputStream(file);
        byte[] b = new byte[1024];
        int a = 0;
        a = is.read(b);
        String[] str = new String(b,0,a).split("");
        int count = 0;
        for (int i = 0; i < str.length ; i++) {
            if ("a".equals(str[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
