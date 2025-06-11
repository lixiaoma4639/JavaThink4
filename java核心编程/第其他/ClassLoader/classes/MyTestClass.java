package java核心编程.第其他.ClassLoader.classes;

public class MyTestClass {
    private String message;

    public MyTestClass() {
        this.message = "Hello from MyTestClass!";
    }

    public void printMessage() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MyTestClass [message=" + message + "]";
    }
}
