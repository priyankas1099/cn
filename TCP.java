import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TCP
{
    public static void main(String[] args) throws IOException
 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the Hex Dump:");
        String input = br.readLine();
        String SPort = input.substring(0,4);
        System.out.println("Source Port: " + Integer.parseInt(SPort, 16));
        String DPort = input.substring(4,8);
        System.out.println("Destination Port: " + Integer.parseInt(DPort, 16));
       String Seq_No = input.substring(8,16);
        System.out.println("Sequence Number: " + Integer.parseInt(Seq_No, 16));
        String Ack_No = input.substring(16,24);
        System.out.println("Acknowledgement Number: " + Integer.parseInt(Ack_No, 16));
       String h_len = input.substring(24,25);
        System.out.println("Header Length: " + (4 * Integer.parseInt(h_len,16)) + " Bytes");
        String flags = input.substring(26, 28);
        String flags_bin = Integer.toBinaryString(Integer.parseInt(flags,16));
        while(flags_bin.length() < 8)
        	flags_bin = "0" + flags_bin;
        flags_bin = flags_bin.substring(2, 8);
        if(flags_bin.charAt(0) == '1')
            System.out.println("Urgent Pointer is valid");
        if(flags_bin.charAt(1) == '1')
            System.out.println("Acknowledgement Number is valid");
        if(flags_bin.charAt(2) == '1')
            System.out.println("Packet needs to be delivered to the receiving application as soon as possible");
        if(flags_bin.charAt(3) == '1')
            System.out.println("Sender is aborting the connection");
        if(flags_bin.charAt(4) == '1')
            System.out.println("Sender is attempting to Synchronize Sequence Numbers");
        if(flags_bin.charAt(5) == '1')
            System.out.println("No more Data from Sender");
        String Win_Size = input.substring(28,32);
        System.out.println("Window Size: " + Integer.parseInt(Win_Size, 16) + " Bytes");
        String checksum = input.substring(32,36);
        System.out.println("Header Checksum: " + Integer.parseInt(checksum,16));
       String Urg_Ptr = input.substring(36,40);
        System.out.println("Urgent Pointer: " + Integer.parseInt(Urg_Ptr, 16));
    }
}