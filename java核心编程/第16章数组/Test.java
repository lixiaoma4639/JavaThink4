package java核心编程.第16章数组;

import java.util.Arrays;
import java.util.List;

/**
 * 日期 : 2020/12/13.
 * 创建 : xin.li
 * 描述 :
 */
class Test {
    public static void main(String[] args) {
        f(new int[]{2 , 3});
        int[][] aa = {
                {1 , 2 ,3},
                {5 , 6}
        };
        System.out.println(Arrays.deepToString(aa));

        int[][][] ccc = new int[2][3][4];
        System.out.println(Arrays.deepToString(ccc));

        List<String>[] lists = new List[3];
        List<String>[] lists2 = (List<String>[]) new Object[3];
    }
    private static void f(int[] aa){

    }
}
