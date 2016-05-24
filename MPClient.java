import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class MPClient{
	static ClientThread get_msg;
	static Socket s;
	static Boolean msg_ready = false;
	static MPConnection connect;
	static String msg = "";

	public static void main(String args[]) {
		
		Boolean repeat = true;
		Boolean connected = true;
		
		while(repeat){
			
			System.out.println("Client tries to connect to server...");
			String address = JOptionPane.showInputDialog("Input IP Address");
			String port = JOptionPane.showInputDialog("Input Port");
			
			try{
				s = new Socket(address, Integer.parseInt(port));
				repeat = false;
			} catch (Exception e) {
				if(address == null && port == null){
					JOptionPane.showMessageDialog(null, "You have cancelled.", "Cancelled", JOptionPane.ERROR_MESSAGE);
					connected = false;
					break;
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid IP Address/Port. Try again.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	
		if(connected){
			System.out.println("Client has connected!");
			connect = new MPConnection(s);
			get_msg = new ClientThread(connect);
			
			try{
				get_msg.start();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An error has occurred. Client thread has stopped.", "An Error Occurred", JOptionPane.ERROR_MESSAGE);
			}
		}
   }

   private static class ClientThread extends Thread{

		MPConnection connect;
	
		public ClientThread(MPConnection connect){
			this.connect = connect;
		}
	
		public void run(){
			while(true){
				
				msg = JOptionPane.showInputDialog("Input the names.");
				if(msg != null){
					connect.sendMessage(msg);
				}
				else{
					connect.sendMessage("@DONE");
					System.out.println("Client has disconnected.");
					break;
				}
				
				msg = connect.getMessage();
				if(msg == null){
					JOptionPane.showMessageDialog(null, "An error has occurred. Client thread has stopped.", "An Error Occurred", JOptionPane.ERROR_MESSAGE);
					break;
				}
				else{
					System.out.println (msg);
				}
			}
		}
	}
}