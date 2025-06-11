package java核心编程.第12章异常.构造器异常;

/**
 * 日期 : 2020/11/20.
 * 创建 : xin.li
 * 描述 :
 */
class Cleanup {

    static class NeedsCleanup{
        private static long count = 1;
        private final long id = count++;
        public void dispose(){
            System.out.println("NeedsCleanup id = " + id);
        }
    }

    static class ConstructionException extends Exception{
    }

    static class NeedsCleanup2 extends NeedsCleanup{
        public NeedsCleanup2() throws ConstructionException{
            throw new ConstructionException();
        }
    }

    public static void main(String[] args) {
        NeedsCleanup needsCleanup1 = new NeedsCleanup();
        try {
            System.out.println("A");
        } finally {
            needsCleanup1.dispose();
        }

        NeedsCleanup needsCleanup2 = new NeedsCleanup();
        NeedsCleanup needsCleanup3 = new NeedsCleanup();
        try {
            System.out.println("B");
        } finally {
            needsCleanup2.dispose();
            needsCleanup3.dispose();
        }

        NeedsCleanup2 needsCleanup4 = null;
        try {
            needsCleanup4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 needsCleanup5 = new NeedsCleanup2();
                try {
                    System.out.println("C");
                } finally {
                    //needsCleanup5的构造没有出现异常,则在此处释放资源
                    needsCleanup5.dispose();
                }
            } catch (ConstructionException e) {
                //needsCleanup5的构造出现异常了, 对象未创建成功, 不需要释放资源
                System.out.println(e);
            } finally {
                //needsCleanup4的构造没有出现异常,则在此处释放资源
                needsCleanup4.dispose();
            }
        } catch (ConstructionException e) {
            //needsCleanup4的构造出现异常了, 对象未创建成功, 不需要释放资源
            System.out.println(e);
        }
//        finally {
//            //needsCleanup4的构造出有可能出现异常, 则初始化失败,会出现空指针,不建议这么释放资源
//            needsCleanup4.dispose();
//        }


        try {
            NeedsCleanup2 needsCleanup6 = new NeedsCleanup2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //这样写会报错
//        catch (ConstructionException e) {
//            e.printStackTrace();
//        }


        //运行时异常不是 被检查异常,即使生命了也可以不用try检查
//        Cleanup cleanup = new Cleanup();
//        cleanup.f();


    }

    void f() throws RuntimeException {
        throw new RuntimeException();
    }
}
