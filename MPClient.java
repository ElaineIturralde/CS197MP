import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class MPClient{
	static ThreadGet get_msg;
	static ThreadSend send_msg;
	static Boolean msg_ready = false;
	static MPConnection connect;
	static String msg = "";

	public static void main(String args[]) {
		
		try {

			System.out.println("Client tries to connect to server...");
			String address = JOptionPane.showInputDialog("Input IP Address");
			String port = JOptionPane.showInputDialog("Input Port");

			Socket s = new Socket(address, Integer.parseInt(port));
			connect = new MPConnection(s);
			get_msg = new ThreadGet(connect);
			
			get_msg.start();

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try{
						msg = "Client has connected!";
						System.out.println(msg);
						msg_ready = true;
						send_msg = new ThreadSend(connect);
						send_msg.start();
					}catch(Exception e){}
				}
			});

		} catch (Exception e) {
			System.out.println("An error was encountered.");
			e.printStackTrace();
		}
   }

   private static class ThreadGet extends Thread{

		MPConnection connect;
	
		public ThreadGet(MPConnection connect){
			this.connect = connect;
		}
	
		public void run(){
			while(true){
				msg = connect.getMessage();
				if(msg != null || msg != ""){
					if(msg.equals("DONE")){
						break;
					}
					System.out.println (msg);
				}
			}
		}
	}

	private static class ThreadSend extends Thread{
	
		MPConnection connect;
	
		public ThreadSend(MPConnection connect){
			this.connect = connect;
		}		
		
		public void run(){
			while(true){
				msg = JOptionPane.showInputDialog("Input the names.");
				if((msg != null) && msg_ready){
					connect.sendMessage(msg);
				}
				else{
					connect.sendMessage("DONE");
					msg_ready = false;
					break;
				}
			}
		}
	}
}