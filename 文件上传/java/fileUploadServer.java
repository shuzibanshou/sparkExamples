import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class fileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sersock = new ServerSocket(8888);
        Socket socket = sersock.accept();

        InputStream inputStream = socket.getInputStream();      //bufferInputStream is required?
        byte[] bytes = utils.inputStreamToByteArray(inputStream);
        FileOutputStream ops = new FileOutputStream("./java2.jpg");
        ops.write(bytes);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("receive the pic".getBytes());


        ops.close();
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();
        sersock.close();
    }

}
