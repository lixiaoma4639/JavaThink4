package java核心编程.第其他.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // 创建服务器端的 ServerSocket，监听端口8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started, waiting for client...");

            // 等待客户端连接，accept() 会阻塞直到有客户端连接
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 读取客户端发送的消息
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            // 对客户端进行响应
            out.println("Hello from server!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有打开的资源
            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
