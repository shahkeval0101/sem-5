// A Java program for a Server 
//Initially 
import java.net.*; //to do all netoworking related work
import java.io.*; //for InputStreamReader and BufferedReader

public class Server 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; //This is for client
	private ServerSocket server = null; //This is for server
	private DataInputStream in	 = null; 

	// constructor with port 
	public Server(int port) 
	{ 
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept();//will hold until a client connects 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = ""; 

			// reads message from client until "Over" is sent 
			while (!line.equals("Over")) 
			{ 
				try
				{ 
					line = in.readUTF(); //server initially recieves messages inputstream displays it to the outputstream i.e console as "in" is the obj of the datainputstream 
					//System.out.println("taken from the inputstream");
					System.out.println("Message from the Client  "+line); 

				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Server server = new Server(5000); 
	} 
} 





/*
private Socket
private ServerSocket
private DataInputStream

public Server(port)
try 
server =new ServerSocket(port)
socket=server.accept()
in=new DataInputStream(new BufferedInputStream(socket.getInputStream()))

*/
