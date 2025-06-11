package java核心编程.第30章设计模式.责任链模式2;

public class _01责任链模式 {

    // 审批者抽象类
    static abstract class Approver {
        protected Approver nextApprover;
        protected String name;
        protected double approvalLimit;

        public Approver(String name, double approvalLimit) {
            this.name = name;
            this.approvalLimit = approvalLimit;
        }

        public void setNextApprover(Approver nextApprover) {
            this.nextApprover = nextApprover;
        }

        public void processRequest(PurchaseRequest request) {
            if (request.getAmount() <= approvalLimit) {
                System.out.println(name + " 审批了金额为 " + request.getAmount() + " 的采购请求");
            } else if (nextApprover != null) {
                nextApprover.processRequest(request);
            } else {
                System.out.println("金额 " + request.getAmount() + " 过大，无人能审批");
            }
        }
    }

    // 具体审批者
    static class Manager extends Approver {
        public Manager(String name) {
            super(name, 5000);
        }
    }

    static class Director extends Approver {
        public Director(String name) {
            super(name, 10000);
        }
    }

    static class VicePresident extends Approver {
        public VicePresident(String name) {
            super(name, 20000);
        }
    }

    // 采购请求类
    static class PurchaseRequest {
        private double amount;
        private String purpose;

        public PurchaseRequest(double amount, String purpose) {
            this.amount = amount;
            this.purpose = purpose;
        }

        public double getAmount() {
            return amount;
        }
    }

    // 客户端使用
    public static void main(String[] args) {
        // 创建审批链
        Approver manager = new Manager("张经理");
        Approver director = new Director("王总监");
        Approver vp = new VicePresident("李EEO");

        manager.setNextApprover(director);
        director.setNextApprover(vp);

        // 创建采购请求
        PurchaseRequest request1 = new PurchaseRequest(4000, "购买办公用品");
        PurchaseRequest request2 = new PurchaseRequest(8000, "团队建设活动");
        PurchaseRequest request3 = new PurchaseRequest(15000, "购买服务器");
        PurchaseRequest request4 = new PurchaseRequest(30000, "办公室装修");

        // 处理请求
        manager.processRequest(request4);
//        manager.processRequest(request2);
//        manager.processRequest(request3);
//        manager.processRequest(request4);
    }
}
