import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class clientString {
    public static void main(String[] args)  throws IOException{

        Socket sock = new Socket(InetAddress.getLocalHost(),8888);
        //System.out.println("客户端sock"+sock.getClass());
        OutputStream outputStream = sock.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hello server");
        bufferedWriter.newLine();
        bufferedWriter.flush();     //如果是字符流 此行必须
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
