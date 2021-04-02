// A TCP Java program for a Client 
import java.net.*; 
import java.io.*; 

public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; //datainputstream is used to take take from keyboard and its in java.io 	read and readLine methods are there and return type is string 
	private DataOutputStream out	 = null; //same for dataoutputstream

	// constructor to put ip address and port 
	public Client(String address, int port) //parameterized constructor will be invoke during the obj defn.
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); //making of socket obj if server is in accept state it will be connected
			System.out.println("Connected"); 

			// takes input from terminal 
			input = new DataInputStream(System.in);//takes from standard input device

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); //returns the output stream of the socket. The output stream is connected to the input stream of the remote socket.
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 

		// keep reading until "Over" is input 
		while (!line.equals("Over")) 
		{ 
			try
			{ 
				line = input.readLine();
				//System.out.println("Taken from input stream");
				out.writeUTF(line);//since its the outputstream obj it will send to the server 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

/*
A socket connection means the two machines have information about each other’s network location (IP Address) and TCP port.The java.net.Socket class represents a Socket. To open a socket:
*/
	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 5000); //port number and Ip address
	} 
} 
