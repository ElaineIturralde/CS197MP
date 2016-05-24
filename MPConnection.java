import java.io.*;
import java.net.*;
import javax.swing.*;

public class MPConnection {	
	Socket s;
	PrintWriter out;
	BufferedReader in;
	
	public MPConnection(Socket s) {
		try {
			this.s = s;		
			this.out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean sendMessage(String msg) {
		try {
			out.println(msg);
			out.flush();
			return true;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "An error has occurred while sending the message.", "An Error Occurred", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public String getMessage() {		
		try {
			return in.readLine();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "An error has occurred while getting the message.", "An Error Occurred", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
		
}