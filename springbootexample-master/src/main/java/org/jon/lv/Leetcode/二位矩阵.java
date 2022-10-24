package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/23 15:23
 * @Description:
 * 1,3,5,7
 * 10,11,16,20
 * 23,30,34,60
 */
public class 二位矩阵 {
    public static void main(String[] args) {
       int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
       System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix,int target) {
        int rows = matrix.length;
        int columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            }
            else if (num > target) {
                rows--;
            }else {
                columns++;
            }
        }
        return false;
    }
}
