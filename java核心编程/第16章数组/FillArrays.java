package java核心编程.第16章数组;

import java.util.Arrays;

/**
 * 日期 : 2020/12/13.
 * 创建 : xin.li
 * 描述 :
 */
class FillArrays {

    public static void main(String[] args) {
        int[] a1 = new int[6];
        Arrays.fill(a1 , 3);
        System.out.println(Arrays.toString(a1));

        double[] a2 = new double[6];
        Arrays.fill(a2 , 2 , 4 , 3.45);
        System.out.println(Arrays.toString(a2));
    }


}
