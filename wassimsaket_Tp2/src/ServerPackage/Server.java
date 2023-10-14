package ServerPackage;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("je suis un serveur, j'attend un client");
			
			Socket s = ss.accept();
			System.out.println("un client est connecté");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			int op1 = Integer.parseInt(br.readLine());
			int op2 = Integer.parseInt(br.readLine());
			String oper = br.readLine();
			int res = 0;
			switch (oper) {
				case "+":
					res = op1 + op2;
					break;
				case "-":
					res = op1 - op2;
					break;
				case "*":
					res = op1 * op2;
					break;
				case "/":
					res = op1 / op2;
					break;
			}
			PrintWriter pw = new PrintWriter(os,true);
			pw.println(res);
			
			s.close();
			ss.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
