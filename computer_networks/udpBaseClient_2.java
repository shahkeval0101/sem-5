// Java program to illustrate Client side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class udpBaseClient_2 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		Scanner sc = new Scanner(System.in); 

		// Step 1:Create the socket object for 
		// carrying the data. 
		DatagramSocket ds = new DatagramSocket(); 

		InetAddress ip = InetAddress.getLocalHost(); //static InetAddress InetAddress getLocalHost():Returns the local host.
		
		byte buf[] = null; 

		// loop while user not enters "bye" 
		while (true) 
		{ 
			String inp = sc.nextLine(); 

			// convert the String input into the byte array. 
			buf = inp.getBytes();
/*
The getBytes() method encodes a given String into a sequence of bytes and returns an array of bytes. The method can be used in below two ways: public byte[] getBytes(String charsetName) : It encodes the String into sequence of bytes using the specified charset and return the array of those bytes.
*/			

			// Step 2 : Create the datagramPacket for sending 
			// the data. 
			DatagramPacket DpSend = 
				new DatagramPacket(buf, buf.length, ip, 1234); 

			// Step 3 : invoke the send call to actually send 
			// the data. 
			ds.send(DpSend); 

			// break the loop if user enters "bye" 
			if (inp.equals("bye")) 
				break; 
		} 
	} 
} 
