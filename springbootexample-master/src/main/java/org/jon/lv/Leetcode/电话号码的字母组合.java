package org.jon.lv.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/17 08:52
 * @Description:
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        电话号码的字母组合 test = new 电话号码的字母组合();
//        System.out.println(test.letterCombinations(digits));
    }

//    public List<String> letterCombinations(String digits) {
//        List<String> list = new ArrayList<>();
//        if (digits.length() == 0) {
//            return list;
//        }
//        Map<Character,String> map = new HashMap<Character, String>(){{
//           put('2',"abc");
//           put('3',"def");
//           put('4',"ghi");
//           put('5',"jkl");
//           put('6',"mno");
//           put('7',"pqrs");
//           put('8',"tuv");
//           put('9',"wxyz");
//        }};
//        backtrack(list,map,digits,0,new StringBuffer());
//        return list;
//    }

//    private void backtrack(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
//        if (index == digits.length()) {
//            list.add(stringBuffer.toString());
//        }else {
//            char digit = digits.charAt(index);
//            String letters = map.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                stringBuffer.append(letters.charAt(i));
//                backtrack(list,map,digits,index+1,stringBuffer);
//                stringBuffer.deleteCharAt(index);
//            }
//        }
//    }



    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character,String> characterStringMap = new HashMap<Character, String>() {{
           put('2',"abc");
           put('3',"def");
           put('4',"ghi");
           put('5',"jkl");
           put('6',"mno");
           put('7',"pqrs");
           put('8',"tuv");
           put('9',"wxyz");
        }};
        backtrack(list,characterStringMap,digits,0,new StringBuffer());
        return list;
    }
    // 电话号码字母组合
    private void backtrack(List<String> list, Map<Character, String> characterStringMap, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            list.add(stringBuffer.toString());
        }else {
            char str = digits.charAt(index);
            String letters = characterStringMap.get(str);
            for (int i = 0; i < letters.length(); i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(list,characterStringMap,digits,index+1,stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}
