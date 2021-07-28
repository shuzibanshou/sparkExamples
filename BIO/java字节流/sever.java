import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sever {
    public static void main(String[] args) throws IOException {
        ServerSocket sersock = new ServerSocket(8888);
        /*while (true) {*/
            Socket socket = sersock.accept();
            //System.out.println("服务端sock" + socket.getClass());
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1000];  //准备一个瓢
            int readCount = 0;

            while ((readCount = inputStream.read(buffer)) != -1) {   //一直舀
                //byteArrayOutputStream.write(buffer, 0, readCount);
                System.out.println(new String(buffer, 0, readCount));
            }

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello client".getBytes());
            //socket.shutdownOutput();

            outputStream.close();
            inputStream.close();
            socket.close();
        /*}*/
        //sersock.close();
    }
}
