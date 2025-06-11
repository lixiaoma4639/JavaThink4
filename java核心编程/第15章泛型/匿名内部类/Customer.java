package java核心编程.第15章泛型.匿名内部类;

import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class Customer {
    private static long count = 1;
    private final long id = count++;

    private Customer() {
    }

    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }


    static class Teller {
        private static long count = 1;
        private final long id = count++;

        private Teller() {
        }

        public static Generator<Teller> generator(){
            return new Generator<Teller>() {
                @Override
                public Teller next() {
                    return new Teller();
                }
            };
        }

        @Override
        public String toString() {
            return "Teller " + id;
        }
    }

    public static class BlankTeller{
        public static void server(Teller teller , Customer customer){
            System.out.println(teller + "给 " + customer + "提供服务....");
        }

        public static void main(String[] args) {
        }
    }
}
