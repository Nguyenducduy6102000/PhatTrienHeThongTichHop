package ChatRoom;
import java.io.*; 
import java.util.*; 
import java.net.*; 
public class Server {
	public static void main(String[] args) throws Exception 
	{ 
	    ServerSocket server = new ServerSocket(7000); 
	    System.out.println("Server is started");     
	         
	    while(true) {   
	 		Socket socket = server.accept(); 
	 		new doRequest(socket).start();
	    } 
	    //socket.close();  
	  } 
	}
	class doRequest extends Thread{
		Socket socket;
		DataInputStream din;
		DataOutputStream dos;
		public doRequest(Socket sk){
			socket=sk;
		}
		public void run(){
		try{
		
		din=new DataInputStream(socket.getInputStream());
		dos=new DataOutputStream(socket.getOutputStream());
		Scanner kb=new Scanner(System.in);
		while(true){
			String nhan=din.readUTF();
			System.out.println(nhan);
			System.out.println("Server: ");
			String gui=kb.nextLine();
			dos.writeUTF("Server:"+gui);
			dos.flush();
			kb=kb.reset();
		}
		}catch(Exception e)
		{
			
		}
		}
}
