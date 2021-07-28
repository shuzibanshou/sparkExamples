import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes_unit = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes_unit, bytes_unit.length);
        socket.receive(datagramPacket);
        //取出数据包中的数据
        int length = datagramPacket.getLength();
        //byte[] data = datagramPacket.getData();
        String s = new String(bytes_unit,0,length);
        System.out.println(s);


        datagramPacket = new DatagramPacket("hello,client".getBytes(), "hello,client".getBytes().length, InetAddress.getByName("127.0.0.1"), 8889);
        socket.send(datagramPacket);
        socket.close();
    }
}
