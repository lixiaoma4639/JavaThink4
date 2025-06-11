package java核心编程.第30章设计模式.装饰器模式DeepSeek;

public class Decorator {
    // 1. 组件接口 - 饮料
    public interface Beverage {
        String getDescription();
        double cost();
    }

    // 2. 具体组件 - 基础咖啡
    public static class XingBaKeCoffee implements Beverage {
        @Override
        public String getDescription() {
            return "星巴克咖啡";
        }

        @Override
        public double cost() {
            return 2.99;
        }
    }

    public static class RuiXingCoffee implements Beverage {
        @Override
        public String getDescription() {
            return "瑞幸咖啡";
        }

        @Override
        public double cost() {
            return 2.79;
        }
    }

    // 3. 抽象装饰器
    public static abstract class CondimentDecorator implements Beverage {
        protected Beverage beverage;

        public CondimentDecorator(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public abstract String getDescription();
    }

    // 4. 具体装饰器 - 各种调料
    public static class Milk extends CondimentDecorator {
        public Milk(Beverage beverage) {
            super(beverage);
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", 添加牛奶";
        }

        @Override
        public double cost() {
            return beverage.cost() + 0.50;
        }
    }

    public static class Sugar extends CondimentDecorator {
        public Sugar(Beverage beverage) {
            super(beverage);
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", 加糖";
        }

        @Override
        public double cost() {
            return beverage.cost() + 0.70;
        }
    }

    public static class Cappuccino extends CondimentDecorator {
        public Cappuccino(Beverage beverage) {
            super(beverage);
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", 加卡布奇诺";
        }

        @Override
        public double cost() {
            return beverage.cost() + 0.60;
        }
    }

    // 5. 客户端使用
    public static void main(String[] args) {
        // 点一杯House Blend咖啡，加双份Mocha和Whip
        Beverage beverage1 = new XingBaKeCoffee();
        beverage1 = new Milk(beverage1);
        beverage1 = new Sugar(beverage1);
        beverage1 = new Cappuccino(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        // 点一杯Dark Roast咖啡，加Milk和Whip
        Beverage beverage2 = new RuiXingCoffee();
        beverage2 = new Milk(beverage2);
        beverage2 = new Sugar(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
