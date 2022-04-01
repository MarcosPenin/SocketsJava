package ejemplo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static Scanner sc=new Scanner(System.in);
	
	 public static void main(String[] args) {
		 try {
		 System.out.println("Creando socket cliente");
		 Socket clientSocket = new Socket();
		 System.out.println("Estableciendo la conexión");
		 InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
		 clientSocket.connect(addr);
		 InputStream is = clientSocket.getInputStream();
		 OutputStream os = clientSocket.getOutputStream();
		 System.out.println("Introduce la cadena para enviar");		 
		 
		 String mensaje = sc.nextLine();
		 int numero=is.read();
		 
		 System.out.println("Es usted el cliente número "+numero);
		 clientSocket.close();
		 System.out.println("Terminado");
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
}}
