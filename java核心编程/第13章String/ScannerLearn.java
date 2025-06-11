package java核心编程.第13章String;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 日期 : 2020/11/30.
 * 创建 : xin.li
 * 描述 :
 */
class ScannerLearn {

    public static BufferedReader bufferedReader = new BufferedReader(new StringReader("li xin \n 28 6.66"));

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(bufferedReader);
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextDouble());
//
//
//        Scanner scanner2 = new Scanner("li xin2 \n 24 6.666");
//        System.out.println(scanner2.nextLine());
//        System.out.println(scanner2.nextInt());
//        System.out.println(scanner2.nextDouble());

//        Scanner scanner2 = new Scanner("1, 2 , 3   , 4, 5 ");
//        scanner2.useDelimiter("\\s*,\\s*");
//        while (scanner2.hasNext()){
//            System.out.println("scanner2 = " + scanner2.next());
//        }

        String input = "The payments REST services allow you to initiate a payment, retrieve the payment details or perform specific actions like refunding or requesting capture of a payment. A payment is identified by its paymentId. Some payment products allow a two step approach allowing you to control when the authorization takes place separate from when the funds are actually captured.";
        StringTokenizer stringToken = new StringTokenizer(input);
        while (stringToken.hasMoreElements()){
            System.out.print(stringToken.nextToken() + " ");
        }

        Class z = stringToken.getClass();
    }
}
