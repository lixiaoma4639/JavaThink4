package java核心编程.第30章设计模式.工厂模式;

import java.math.BigDecimal;

public class _01工厂模式 {
    // 不使用工厂模式
    public void pay(String type, BigDecimal amount) {
        Payment payment;
        if ("alipay".equals(type)) {
            payment = new Alipay();
        } else if ("wechat".equals(type)) {
            payment = new WechatPay();
        } else if ("creditcard".equals(type)) {
            payment = new CreditCardPay();
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }
        payment.pay(amount);
    }

    //使用工厂模式进行优化
    // 支付接口
    interface Payment {
        void pay(BigDecimal amount);
    }

    // 工厂接口
    interface PaymentFactory {
        Payment createPayment();
    }

    // 具体支付实现
    static class Alipay implements Payment {
        public void pay(BigDecimal amount) {
            // 支付宝支付实现
            System.out.println("支付宝进行支付");
        }
    }
    static class WechatPay implements Payment {
        public void pay(BigDecimal amount) {
            // 支付宝支付实现
            System.out.println("微信进行支付");
        }
    }
    static class CreditCardPay implements Payment {
        public void pay(BigDecimal amount) {
            // 支付宝支付实现
            System.out.println("信用卡进行支付");
        }
    }

    static class AlipayFactory implements PaymentFactory {
        public Payment createPayment() {
            return new Alipay();
        }
    }
    static class WeChatFactory implements PaymentFactory {
        public Payment createPayment() {
            return new WechatPay();
        }
    }

    // 使用方
    static public class PaymentService {
        private PaymentFactory factory;

        public PaymentService(PaymentFactory factory) {
            this.factory = factory;
        }

        public void pay(BigDecimal amount) {
            Payment payment = factory.createPayment();
            payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new WeChatFactory());
        paymentService.pay(new BigDecimal(2000));
    }
}
