package ClientPackage;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1234);
			System.out.println("je suis un client connecté");
			
			Scanner sc = new Scanner(System.in);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			System.out.println("donner les deux opérateurs : ");
			int op1 = sc.nextInt();
			int op2 = sc.nextInt();
			String oper;
			do {
				System.out.println("donner l'operation (+,-,*,/) : ");
				oper = sc.nextLine();
			} while (!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/"));
			PrintWriter pw = new PrintWriter(os,true);
			pw.println(op1);
			pw.println(op2);
			pw.println(oper);
			System.out.println(op1+" "+oper+" "+op2+" = "+new BufferedReader(new InputStreamReader(is)).readLine());
			
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
