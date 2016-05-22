//ELAINE C. ITURRALDE 201235499
//java version "1.8.0_25"

import java.io.*;
import java.net.*;

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
			e.printStackTrace();
			return false;
		}
	}
	
	public String getMessage() {		
		try {
			return in.readLine();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
}