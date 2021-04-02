		CN EXPERIMENT NO-04

Aim: Implementation of Bit Stuffing

import java.util.*;
class bit_stuffing {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the binary message");
		String data=sc.nextLine();
		String res=new String();
		String out=new String();
		int count=0;
		
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)!='0' && data.charAt(i)!='1') {
				System.out.println("Enter only Binary number");
				return;
			}
		}
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)=='1') {
				count++;
				res = res + data.charAt(i);
			}
			else {
				count=0;
				res= res + data.charAt(i);
			}
			if(count==5) {
				res = res + '0';
				count=0;
			}
		}
		
		String trans="01111110"+res+"01111110";
		System.out.println("The message to be transfered : "+trans);
		System.out.println("Sending message....");
		count=0;
		for(int i=0;i<res.length();i++) {
			if(res.charAt(i)=='1') {
				count++;
				out = out + res.charAt(i);
			}
			else {
				out = out + res.charAt(i);
				count=0;
			}
			if(count==5) {
				i++;
                                count=0;
			}
		}
		System.out.println("Message Received... Successfully");
		System.out.println("The Destuffed message is : "+out);
	}
}
output:
C:\Users\student\Desktop>javac bitstuffing.java
C:\Users\student\Desktop>java bit_stuffing
Enter the binary message
11111111111
The message to be transfered : 01111110111110111110101111110
Sending message....
Message Received... Successfully
The Destuffed message is : 11111111111
