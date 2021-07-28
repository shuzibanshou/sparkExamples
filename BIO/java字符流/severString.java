import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class severString {
    public static void main(String[] args) throws IOException {
        ServerSocket sersock = new ServerSocket(8888);
        /*while (true) {*/
            Socket socket = sersock.accept();
            //System.out.println("服务端sock" + socket.getClass());
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println(s);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello client".getBytes());
            //socket.shutdownOutput();

            outputStream.close();
            bufferedReader.close();
            socket.close();
        /*}*/
        //sersock.close();
    }
}
