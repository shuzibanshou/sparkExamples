import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    public static void main(String[] args)  throws IOException{

        Socket sock = new Socket(InetAddress.getLocalHost(),8888);
        //System.out.println("客户端sock"+sock.getClass());
        OutputStream outputStream = sock.getOutputStream();
        new BufferWriter(new OutputStreamWriter());

        outputStream.write("hello server".getBytes());
        sock.shutdownOutput();
        //
        InputStream inputStream = sock.getInputStream();
        byte[] buffer = new byte[1000];
        int readCount = 0;

        while ((readCount = inputStream.read(buffer)) != -1) {   //
            System.out.println(new String(buffer, 0, readCount));
        }
        outputStream.close();
        inputStream.close();
        sock.close();
    }
}
