import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

public class MPServer{
	
	static ThreadSocket socket_thread;
	static ServerSocket ssocket;
	static Socket socket;

	public static void main(String args[]) {
   
		try {

			String port = JOptionPane.showInputDialog("Input Port");
			ssocket = new ServerSocket(Integer.parseInt(port));
			System.out.println ("Server is ready.");

			while(true){
				socket = ssocket.accept();
				socket_thread = new ThreadSocket(socket);
				System.out.println ("A client has connected");
				socket_thread.start();
			}

		} catch (Exception e) {
			System.out.println("An error was encountered.");
			e.printStackTrace();
		}
   }

    private static class ThreadSocket extends Thread{

   		Socket socket;
		MPConnection connect;

		public ThreadSocket(Socket socket){
			this.socket = socket;
			this.connect = new MPConnection(socket);
		}

		public void run(){
		
			while(true){ 
				String msg = connect.getMessage();
				if(msg != null){
					flames(msg);
				}
				else{
					break;
				}
			}
		}

		public void flames(String msg){

			if(msg.equals("DONE")){
				connect.sendMessage("DONE");
			}
			else{
				//insert flames algo here
				System.out.println("Love");
				connect.sendMessage("Love");
			}
		}
   }
}