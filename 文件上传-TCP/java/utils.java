import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class utils {
    public static byte[] inputStreamToByteArray(InputStream is) throws IOException {
        //why need the ByteArrayOutputStream to play a bridge role?
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int length  = 0;
        while((length = is.read(b)) != -1){
            bis.write(b);
        }
        byte[] res = bis.toByteArray();
        bis.close();
        return res;
    }
}
