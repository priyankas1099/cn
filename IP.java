import java.io.*;
public class IP {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println(&quot;Please enter the Hex Dump:&quot;);
String input = br.readLine();
String IPVer = input.substring(0,1);
if(IPVer.equals(&quot;4&quot;))
System.out.println(&quot;IP Version: 4&quot;);
if(IPVer.equals(&quot;6&quot;))
System.out.println(&quot;IP Version: 6&quot;);
String h_len = input.substring(1,2);
System.out.println(&quot;Header Length: &quot; + (4 * Integer.parseInt(h_len,16)));
String s_type = input.substring(2,4);
String s_t_bin = Integer.toBinaryString(Integer.parseInt(s_type,16));
while(s_t_bin.length() &lt; 8)
s_t_bin = &quot;0&quot; + s_t_bin;
System.out.println(&quot;Service Type: &quot; + Integer.parseInt(s_t_bin.substring(0,3),2));
if(s_t_bin.charAt(3) == &#39;1&#39;)
System.out.println(&quot;Minimize Delay Requested&quot;);
if(s_t_bin.charAt(4) == &#39;1&#39;)
System.out.println(&quot;Maximize Throughput Requested&quot;);
if(s_t_bin.charAt(5) == &#39;1&#39;)
System.out.println(&quot;Maximize Reliability Requested&quot;);
if(s_t_bin.charAt(6) == &#39;1&#39;)
System.out.println(&quot;Minimize Cost Requested&quot;);
String tot_len = input.substring(4,8);
System.out.println(&quot;Total Length: &quot; + Integer.parseInt(tot_len,16) + &quot; Bytes&quot;);
String id = input.substring(8,12);
System.out.println(&quot;Identification: &quot; + Integer.parseInt(id,16));
String frag = input.substring(12,16);
String frag_bin = Integer.toBinaryString(Integer.parseInt(frag,16));
while(frag_bin.length() &lt; 16)
frag_bin = &quot;0&quot; + frag_bin;
String frag_flags = frag_bin.substring(0,3);
if(frag_flags.charAt(1) == &#39;1&#39;)
System.out.println(&quot;Do not Fragment Packet&quot;);
else
System.out.println(&quot;Can be Fragmented&quot;);
if(frag_flags.charAt(2) == &#39;1&#39;)
System.out.println(&quot;More Fragments pending&quot;);
else
System.out.println(&quot;No more Fragments pending&quot;);

System.out.println(&quot;Fragmentation Offset: &quot; + ((8 * Integer.parseInt(frag_bin.substring(3, 16),2)) - (4
*Integer.parseInt(h_len,16))));
String ttl = input.substring(16,18);
System.out.println(&quot;Time to live: &quot; + Integer.parseInt(ttl,16) + &quot; Hops&quot;);
String protocol = input.substring(18,20);
System.out.print(&quot;Protocol: &quot;);
if(Integer.parseInt(protocol,16) == 1)
System.out.println(&quot;ICMP&quot;);
if(Integer.parseInt(protocol,16) == 2)
System.out.println(&quot;IGMP&quot;);
if(Integer.parseInt(protocol,16) == 89)
System.out.println(&quot;OSPF&quot;);
if(Integer.parseInt(protocol,16) == 6)
System.out.println(&quot;TCP&quot;);
if(Integer.parseInt(protocol,16) == 17)
System.out.println(&quot;UDP&quot;);
String checksum = input.substring(20,24);
System.out.println(&quot;Header Checksum: &quot; + Integer.parseInt(checksum,16));
String s_ip = input.substring(24,32);
String s_ip_bin = Long.toBinaryString(Long.parseLong(s_ip,16));
while(s_ip_bin.length() &lt; 32)
s_ip_bin = &quot;0&quot; + s_ip_bin;
System.out.print(&quot;Source IP Address: &quot;);
System.out.print(Integer.parseInt(s_ip_bin.substring(0,8),2) + &quot;.&quot;);
System.out.print(Integer.parseInt(s_ip_bin.substring(8,16),2) + &quot;.&quot;);
System.out.print(Integer.parseInt(s_ip_bin.substring(16,24),2) + &quot;.&quot;);
System.out.println(Integer.parseInt(s_ip_bin.substring(24,32),2));
String d_ip = input.substring(32,40);
String d_ip_bin = Long.toBinaryString(Long.parseLong(d_ip,16));
while(d_ip_bin.length() &lt; 32)
d_ip_bin = &quot;0&quot; + d_ip_bin;
System.out.print(&quot;Destination IP Address: &quot;);
System.out.print(Integer.parseInt(d_ip_bin.substring(0,8),2) + &quot;.&quot;);
System.out.print(Integer.parseInt(d_ip_bin.substring(8,16),2) + &quot;.&quot;);
System.out.print(Integer.parseInt(d_ip_bin.substring(16,24),2) + &quot;.&quot;);
System.out.println(Integer.parseInt(d_ip_bin.substring(24,32),2));
}
}


OUTPUT :
Please enter the Hex Dump:
4500005400035850200600007C4E0302B40E0F02
IP Version: 4
Header Length: 20
Service Type: 0
Total Length: 84 Bytes
Identification: 3
Do not Fragment Packet
No more Fragments pending
Fragmentation Offset: 49772
Time to live: 32 Hops
Protocol: TCP
Header Checksum: 0
Source IP Address: 124.78.3.2
Destination IP Address: 180.14.15.2