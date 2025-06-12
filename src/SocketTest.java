import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        String host = "10.8.0.211";
//        host = "104.238.184.237";
        int port = 4000;
//        port = 8080;

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(host, port));

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);

        // 控制台输入线程
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    String line = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(line)) {
                        socketChannel.close();
                        break;
                    }
                    ByteBuffer buffer = ByteBuffer.wrap(joinByte(line.getBytes()));
                    socketChannel.write(buffer);
                }
            } catch (IOException e) {
                // 连接关闭时会抛异常，忽略即可
            }
        }).start();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            if (selector.select() == 0) continue;
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();

                if (key.isConnectable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    if (sc.isConnectionPending()) {
                        sc.finishConnect();
                        System.out.println("已连接到服务端，输入exit退出。");
                    }
                }
                if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    buffer.clear();
                    int len = sc.read(buffer);
                    if (len > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        System.out.println("服务端返回: " + new String(bytes));
                    } else if (len == -1) {
                        sc.close();
                        System.out.println("连接已关闭。");
                        return;
                    }
                }
            }
        }
    }


    public static byte[] joinByte(byte[] b2) {
        byte b1[] = { 0x0d }; //字符的 ASCII 码，通常用于回车（CR，Carriage Return）。
        byte b3[] = { 0x0a }; //字符的 ASCII 码，通常用于换行（LF，Line Feed）。
        byte[] middle = new byte[b1.length + b2.length];
        System.arraycopy(b2, 0, middle, 0, b2.length);
        System.arraycopy(b1, 0, middle, b2.length, b1.length);
        byte[] result = new byte[middle.length + b3.length];
        System.arraycopy(middle, 0, result, 0, middle.length);
        System.arraycopy(b3, 0, result, middle.length, b3.length);
        return result;
    }
}
