import java.io.*;
class ham
{
	public static void main(String args[])
	{
		Console c = System.console();	
		int i, j=0, c1=0, c2=0, c4=0, c8=0;
		int data[] = new int[7];
		System.out.println("Data bits: ");
		for(i=0; i<7; i++)
		{
			data[i] = Integer.parseInt(c.readLine());
		}
		int hc[] = new int[11];
		for(i=10;i>=0;i--)
		{
			if(i!=7 && i!=3 && i!=1 && i!=0)
				hc[i] = data[j++];	
		}
		for(i=0;i<11;i++)
		{
			if(i%2 == 0)
			{		//for r1
				if(hc[i]==1)	c1++;
			}
			if(i==1 || i==2 || i==5 || i==6 || i==9 || i==10)
			{		//for r2
				if(hc[i]==1)	c2++;
			}
			if(i>=3 && i<=6)
			{		//for r4
				if(hc[i]==1)	c4++;
			}
			if(i>=7 && i<=10)
			{		//for r8
				if(hc[i]==1)	c8++;
			}
		}
		hc[0] = setBit(c1);
		hc[1] = setBit(c2);
		hc[3] = setBit(c4);
		hc[7] = setBit(c8);
		
		System.out.format("Parity 1 :- %d",hc[0]);
		System.out.format("\nParity 2 :- %d",hc[1]);
		System.out.format("\nParity 4 :- %d",hc[3]);
		System.out.format("\nParity 8 :- %d",hc[7]);
		
		System.out.println("\nHamming code:");
		for(i=10;i>=0;i--)
			System.out.print(hc[i]+" ");
		System.out.println();
		
		int rd[] = new int[11];
		
		System.out.println("Enter the received data:");
		for(i=0;i<11;i++)
			rd[i] = Integer.parseInt(c.readLine());
		i=10;
		for(j=0;j<11;j++){
			if(rd[j] != hc[i--]){
				System.out.println("Error is at position "+(i+2));
				if(rd[j] == 0)	rd[j]=1;
				else if(rd[j] == 1)	rd[j]=0;
				break;
			}
		}
		System.out.println("Correct code:");
		for(i=0;i<11;i++)
			System.out.print(rd[i]+" ");
		System.out.println();
	}
		
		public static int setBit(int c)
		{
			if(c%2 == 0)	return 0;
			else	return 1;
		}
}



Output:
Data bits:
1
0
0
1
1
0
1
Parity 1 :- 1
Parity 2 :- 0
Parity 4 :- 0
Parity 8 :- 1
Hamming code:
1 0 0 1 1 1 0 0 1 0 1
Enter the received data:
1
0
0
1
0
1
0
0
1
0

1
Error is at position 7
Correct code:
1 0 0 1 1 1 0 0 1 0 1
