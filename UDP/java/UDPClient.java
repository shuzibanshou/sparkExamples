import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);
        //发送
        byte[] bytes = "四大名著".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 8888);
        socket.send(datagramPacket);
        //接收
        byte[] bytes_unit = new byte[1024];
        datagramPacket = new DatagramPacket(bytes_unit, bytes_unit.length);
        socket.receive(datagramPacket);
        //取出数据包中的数据
        int length = datagramPacket.getLength();
        //byte[] data = datagramPacket.getData();
        String s = new String(bytes_unit,0,length);
        System.out.println(s);

        socket.close();
    }
}
