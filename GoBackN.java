import java.lang.*;
import java.util.*;
class GoBackN
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println(&quot;\nImplementing Sliding Window Protocol using GoBackN apporach\n&quot;);
System.out.println(&quot;\nEnter the Max.Window Size:\n&quot;);
int n = sc.nextInt();
int frame = (int)Math.pow(2,n);
int transmit[] = new int[frame];
int transmit_flag[] = new int[frame];
int receive[] = new int[frame-1];
int index=0; //To keep track of Window
int count1=0;
int count2=0;
for(int c=0;c&lt;n;c++)
{
transmit[c] = c;
transmit_flag[c] = 0; //Indication of the bit to be sent
}
int inp = 1;
do
{
System.out.println(&quot;\n1.Execute 2.Exit\n&quot;);
inp = sc.nextInt();
switch(inp)
{
case 1:
{
count1 = 0;
count2 = 0;
System.out.println(&quot;\nFrame Allowed:\n&quot;);
for(int c=index;c&lt;n;c++)
{
if( count1!=n-1 )
{
System.out.print(transmit[c]+&quot; &quot;);
count1+=1;
}
}
if( count1 != n-1 )
{
for(int d=0,l=1;l&lt;=n-count1;d++,l++)

{
System.out.print(transmit[d]+&quot; &quot;);
count1+=1;
}
}
System.out.println();
System.out.println(&quot;\nEnter the Transmitting Frame\n&quot;);
for(int c=0;c&lt;n-1;c++)
{
receive[c] = sc.nextInt();
}
System.out.println(&quot;\nMax. Window Size Reached\n&quot;+index+&quot;\n&quot;);
for(int c=0;c&lt;n-1;c++)
{
if ( receive[c] == transmit[index] )
{
transmit_flag[index] = 1;
System.out.println(receive[c]+&quot; is acknowledged\n&quot;);
if( index == n-1 )
{
index=0;
}
else
{
index+=1;
}
}
else
{
System.out.println(receive[c]+ &quot; is not acknowledged)
break;
}
}
for(int c=index;c&lt;n;c++)
{
transmit_flag[c] = 0;
count2+=1;
}
if( count2 != n )
{
for(int d=0,l=1;l&lt;=n-count2;l++,d++)
{
transmit_flag[d] = 0;
}
}
break;
}
case 2:

{
System.out.println(&quot;\nExit!!\n&quot;);
break;
}
default:
{
System.out.println(&quot;\nInvalid input\n&quot;);
break;
}
}
}while(inp!=2);}}


OUTPUT :
Implementing Sliding Window Protocol using GoBackN apporach
Enter the Max.Window Size:
8
1.Execute 2.Exit
1
Frame Allowed:
0 1 2 3 4 5 6
Enter the Transmitting Frame
0
1
2
3
4
5
6
Max. Window Size Reached
0
0 is acknowledged
1 is acknowledged
2 is acknowledged
3 is acknowledged
4 is acknowledged
5 is acknowledged
6 is acknowledged