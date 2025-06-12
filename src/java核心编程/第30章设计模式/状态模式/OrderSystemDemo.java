package java核心编程.第30章设计模式.状态模式;

// 状态接口
interface OrderState {
    void pay(OrderContext context);
    void ship(OrderContext context);
    void complete(OrderContext context);
    void cancel(OrderContext context);
}

// 具体状态 - 待支付
class UnpaidState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("订单支付成功");
        context.setState(new PaidState());
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("订单未支付，不能发货");
    }

    @Override
    public void complete(OrderContext context) {
        System.out.println("订单未支付，不能完成");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("订单已取消");
        context.setState(new CanceledState());
    }
}

// 具体状态 - 已支付
class PaidState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("订单已支付，无需重复支付");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("订单已发货");
        context.setState(new ShippedState());
    }

    @Override
    public void complete(OrderContext context) {
        System.out.println("订单还未发货，不能完成");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("订单已取消，将退款");
        context.setState(new CanceledState());
    }
}

// 具体状态 - 已发货
class ShippedState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("订单已支付，无需重复支付");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("订单已发货，无需重复发货");
    }

    @Override
    public void complete(OrderContext context) {
        System.out.println("订单已完成");
        context.setState(new CompletedState());
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("订单已发货，不能取消");
    }
}

class CanceledState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("订单已取消，重新支付");
        context.setState(new UnpaidState());
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("订单已取消，无法发货");
    }

    @Override
    public void complete(OrderContext context) {
        System.out.println("订单已完成，无法取消");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("订单已取消了。。。");
    }
}


class CompletedState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("订单已完成，无需重复支付");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("订单已完成，无需重复发货");
    }

    @Override
    public void complete(OrderContext context) {
        System.out.println("订单已完成");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("订单已完成，不能取消");
    }
}

// 其他状态类类似实现...

// 上下文类
class OrderContext {
    private OrderState currentState;
    private String orderId;

    public OrderContext(String orderId) {
        this.orderId = orderId;
        this.currentState = new UnpaidState(); // 初始状态
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void pay() {
        System.out.print("订单" + orderId + ": ");
        currentState.pay(this);
    }

    public void ship() {
        System.out.print("订单" + orderId + ": ");
        currentState.ship(this);
    }

    public void complete() {
        System.out.print("订单" + orderId + ": ");
        currentState.complete(this);
    }

    public void cancel() {
        System.out.print("订单" + orderId + ": ");
        currentState.cancel(this);
    }
}

// 使用示例
public class OrderSystemDemo {
    public static void main(String[] args) {
        OrderContext order1 = new OrderContext("20230001");

        order1.ship();    // 订单未支付，不能发货
        order1.pay();     // 订单支付成功
        order1.pay();     // 订单已支付，无需重复支付
        order1.ship();    // 订单已发货
        order1.complete();// 订单已完成
        order1.cancel();  // 订单已完成，不能取消

        System.out.println("-------------------");

        OrderContext order2 = new OrderContext("20230002");
        order2.cancel();  // 订单已取消
        order2.pay();
    }
}
