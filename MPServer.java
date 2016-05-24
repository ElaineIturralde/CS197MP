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
			Object[] algos = { "FLAMES", "TRUE LOVE", "CAN'T DECIDE" };
			Object selected_algo = JOptionPane.showInputDialog(null, "Choose an algorithm", "Input", JOptionPane.INFORMATION_MESSAGE, null, algos, algos[0]);

			while(true){
				socket = ssocket.accept();
				socket_thread = new ThreadSocket(socket, selected_algo);
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
		Object selected_algo;

		public ThreadSocket(Socket socket, Object selected_algo){
			this.socket = socket;
			this.connect = new MPConnection(socket);
			this.selected_algo = selected_algo;
		}

		public void run(){
		
			while(true){ 
				
				String msg = connect.getMessage();
				if(msg != null){
					if(selected_algo.equals("TRUE LOVE")){
						truelove(msg);
					}
					else{
						flames(msg);
					}
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
				System.out.println("Flames");
				connect.sendMessage("Flames");
			}
		}

		public void truelove(String msg){

			if(msg.equals("DONE")){
				connect.sendMessage("DONE");
			}
			else{
				//insert flames algo here
				System.out.println("True Love");
				connect.sendMessage("True Love");
			}
		}
   }
}