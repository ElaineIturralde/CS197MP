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

		Object[] algos = { "FLAMES", "TRUE LOVE", "CAN'T DECIDE" };
		Object selected_algo = "FLAMES";
		Boolean repeat = true;
		Boolean connected = true;

		selected_algo = JOptionPane.showInputDialog(null, "Input", "Choose an algorithm", JOptionPane.INFORMATION_MESSAGE, null, algos, algos[0]);

		while(repeat){
				
			String port = JOptionPane.showInputDialog("Input Port");

			try {				
				ssocket = new ServerSocket(Integer.parseInt(port));
				repeat = false;
			} catch (Exception e) {
				if(port == null){
					JOptionPane.showMessageDialog(null, "You have cancelled.", "Cancelled", JOptionPane.ERROR_MESSAGE);
					connected = false;
					break;
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Port. Try again.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		while(connected){	
			try{
				socket = ssocket.accept();
				System.out.println ("A client has connected");
				socket_thread = new ThreadSocket(socket, selected_algo);
				socket_thread.start();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An error has occurred. Server thread has stopped.", "An Error Occurred", JOptionPane.ERROR_MESSAGE);
			}
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
				if(msg == null || msg.equals("@DONE")){
					System.out.println ("A client has disconnected.");
					break;
				}
				else if(msg != null){
					if(selected_algo.equals("TRUE LOVE")){
						truelove(msg);
					}
					else{
						flames(msg);
					}
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