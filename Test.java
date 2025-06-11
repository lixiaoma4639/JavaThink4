public class Test {
    public static void main(String[] args) {

//        System.out.println(String.valueOf(0x41));
//        double aaa = 111111112.03;
//        System.out.println(aaa);
//        System.out.println(String.valueOf(aaa));
//        String format = String.format("%.0f", aaa);
//        System.out.println(format);
//        System.out.println(Double.toString(aaa));
//        BigDecimal bd = new BigDecimal(Double.toString(aaa));
//        String str = bd.toPlainString();
//        System.out.println(str);
//
//        double bbb = 0.0;
//        System.out.println(bbb == 0.0);

//        Map<String , Integer> aaa = new HashMap<>();
//        aaa.put("a", 2);
//        aaa.put("b", 1);
//        aaa.put("c", 1);
//
//        System.out.println(11 == aaa.put("d", 2));

//        byte a = 0x31;
//        int b = a;
//        System.out.println(b);
//        System.out.println(0x30);

        String aaa = "http://sl.beta.shangri-la.com/cn/landing/test/?source=APP&source=APP";

        System.out.println(getOriginalUrl(aaa));
    }
    private static String getOriginalUrl(String url){
        if (url == null) return "";
        url= url.replaceAll("(?i)(source=app&)+", "");
        url = url.replaceAll("(?i)(&source=app)+", "");
        url = url.replaceAll("(?i)source=app", "");
        if (url.endsWith("?")) {
            url = url.replace("?", "");
        }
        return url;
    }
}
