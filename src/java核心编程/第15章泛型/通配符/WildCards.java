package java核心编程.第15章泛型.通配符;

/**
 * 日期 : 2020/12/7.
 * 创建 : xin.li
 * 描述 :
 */
class WildCards {
    public static void rawArgs(Holder holder , Object tag) {
        holder.setT(tag);
        Object t = holder.getT();
    }

    public static void unbondedArgs(Holder<?> holder , Object tag) {
        //只能set 某种特定的类型,但是编译器不知道该类型是什么, 因此不能调用holder.setT(tag);
        //error
//        holder.setT(tag);
        Object t = holder.getT();
    }

    public static <T> T exact1(Holder<T> holder){
        T t = holder.getT();
        return t;
    }
    public static <T> T exact2(Holder<T> holder , T tag){
        holder.setT(tag);
        T t = holder.getT();
        return t;
    }

    public static <T> T wildSub(Holder<? extends T> holder , T tag){
        //假设T是Number, 那么holder的参数传递进入的对象可以是Holder<Integer>, tag可以是Integer,也可以是Long,因此此处调用add方法是不合理的
        //error
        //holder.setT(tag);
        T t = holder.getT();
        return t;
    }

    public static <T> void wildSup(Holder<? super T> holder , T tag){
        holder.setT(tag);
        //子类 A4 -> A3 -> A2 -> A 父类
        //假如T是A3, 传递给holder的类型是逆变的, 就可以是Holder<A> , tag则是A3本身或他的子类, 因此set是安全的,
        //此处调用getT, 获取类型却是A, 但是A不具备A3(本身和它的子类)的方法,
        Object t = holder.getT();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();

        Holder<Long> qualified = new Holder<>();
        Holder<?> unbonded = new Holder<Long>();
        Holder<? extends Long> bonded = new Holder<Long>();

        Long lan = 1L;

        rawArgs(raw , lan);
        rawArgs(qualified , lan);
        rawArgs(unbonded , lan);
        rawArgs(bonded , lan);

        unbondedArgs(raw , lan);
        unbondedArgs(qualified , lan);
        unbondedArgs(unbonded , lan);
        unbondedArgs(bonded , lan);

        Object r1 = exact1(raw);
        Long aLong = exact1(qualified);
        Object o = exact1(unbonded);
        Long aLong1 = exact1(bonded);

        Long aLong2 = exact2(raw, lan);
        Long aLong3 = exact2(qualified, lan);
        //期望得到一个具体类型,而不是一个 无边界类型? 或者一个不确定类型 (? extends)
        //error
        //exact2(unbonded , lan);
        //exact2(bonded , lan);

        Long wild = wildSub(raw, lan);
        Long wild1 = wildSub(qualified, lan);
        Object wild2 = wildSub(unbonded, lan);
        Long wild3 = wildSub(bonded, lan);

        //wildSub(new Holder<Number>() , 1);
        //wildSub(new Holder<Number>() , 1L);
        //wildSub(new Holder<Number>() , 1.1);

        wildSup(raw, lan);
        wildSup(qualified, lan);
        //期望得到一个具体类型,而不是一个 无边界类型? 或者一个不确定类型 (? extends)
        //error
        //wildSup(unbonded, lan);
        //wildSup(bonded, lan);

    }


    static class AAA<E>{
        private E wildSub(Holder<? extends E> holder , E tag){
            //假设T是Number, 那么holder的参数传递进入的对象可以是Holder<Integer>, tag可以是Integer,也可以是Long,因此此处调用add方法是不合理的
            //error
            //holder.setT(tag);
            E t = holder.getT();
            return t;
        }

        public static void main(String[] args) {
            AAA<Number> numberAAA = new AAA<>();
            numberAAA.wildSub(new Holder<Integer>() , 1.1);
            numberAAA.wildSub(new Holder<Integer>() , 1);
        }
    }

    static class AAASuper<E>{
        private void wildSup(Holder<? super E> holder , E tag){
            holder.setT(tag);
            //子类 A5 -> A3 -> A2 -> A 父类
            //假如T是A3, 传递给holder的类型是逆变的, 就可以是Holder<A> , tag则是A3本身或他的子类, 因此set是安全的,此处调用getT, 获取到的是E的任一一个父类型,但是又不知道到底是哪一个父类型 , 因此如果转换为某个类型是不安全的 , 唯一的安全类型就是Object
            E t = (E) holder.getT();
            System.out.println(t);

//            System.out.println(t instanceof CovariantArray.A);
//            System.out.println(t instanceof CovariantArray.A2);
//            System.out.println(t instanceof CovariantArray.A3);
        }

        public static void main(String[] args) {
            AAASuper<CovariantArray.A3> numberAAASuper = new AAASuper<>();
            numberAAASuper.wildSup(new Holder<CovariantArray.A>() , new CovariantArray.A3());
            numberAAASuper.wildSup(new Holder<CovariantArray.A2>() , new CovariantArray.A3());
            numberAAASuper.wildSup(new Holder<CovariantArray.A2>() , new CovariantArray.A5());

        }
    }
}
