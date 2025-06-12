package java核心编程.第其他.Socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 创建客户端连接到服务器的 Socket，连接到服务器的 IP 和端口
            socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 向服务器发送消息
            out.println("Hello from client!");

            // 读取服务器响应
            String serverMessage = in.readLine();
            System.out.println("Received from server: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有打开的资源
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
