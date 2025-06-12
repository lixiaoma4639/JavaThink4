package java核心编程.第19章枚举;

/**
 * 日期 : 2020/12/30.
 * 创建 : xin.li
 * 描述 :
 */
class EnumCLass {

    public static void main(String[] args) {
        for (Shrubbery s: Shrubbery.values()) {
            System.out.println(s + "  ordinal:  " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAW));
            System.out.println(s.equals(Shrubbery.CRAW));
            System.out.println(s == Shrubbery.CRAW);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
        }

        System.out.println("-------");
        Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, "CRAW");
        System.out.println(shrubbery);

        //Shrubbery shrubbery1 = new Shrubbery();
        //Month month = new Month();

        Month month = getMonth();
        switch (month){
            case ONE:
                System.out.println("1");
                break;
            case TWO:
                System.out.println("2");
                break;
            case THREE:
                System.out.println("3");
                break;
        }

    }

    private static Month getMonth() {
        return Enum.valueOf(Month.class , "ONE");
    }
}
