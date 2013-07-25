import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 25.07.13
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */
public class TestByteBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(0x51e57ac400000000L);
        //buffer = ByteBuffer.allocate(16);

        byte[] b = buffer.array();

        for (byte bb : b) {
            System.out.print(String.format("%03x", bb));
        }
    }
}
