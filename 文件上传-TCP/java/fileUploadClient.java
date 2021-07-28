import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class fileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("127.0.0.1",8888);
        //get the fileinputsteam by the file path
        FileInputStream fis = new FileInputStream("./java.jpg");
        //convert fis to bytes[]
        byte[] bytes = utils.inputStreamToByteArray(fis);
        //send the bytes to outputstream
        OutputStream outputStream = sock.getOutputStream();
        outputStream.write(bytes);
        sock.shutdownOutput();

        InputStream sockIS = sock.getInputStream();
        byte[] buffer = new byte[1000];
        int readCount = 0;

        while ((readCount = sockIS.read(buffer)) != -1) {   //
            System.out.println(new String(buffer, 0, readCount));
        }


        outputStream.close();
        fis.close();
        sock.close();
    }

}
