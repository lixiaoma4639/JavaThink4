package java核心编程.第二十章注解.apt注解处理器;

/**
 * 日期 : 2020/12/15.
 * 创建 : xin.li
 * 描述 :
 */
@ExtractPolicy("IMultiplier")
public class Multiplier {

    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
        System.out.println("11 * 20 = " + multiplier.Multiply(11 , 20));
    }

    public int Multiply(int x , int y){
        int total = 0 ;
        for (int i = 0; i < x; i++) {
            total = add(total , y);
        }
        return total;
    }

    private int add(int total, int y) {
        return total + y;
    }
}
