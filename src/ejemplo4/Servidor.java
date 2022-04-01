package ejemplo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		
		int numero=1;
		 try {
		 System.out.println("Creando socket servidor");
		 ServerSocket serverSocket = new ServerSocket();
		 System.out.println("Realizando el bind");
		 InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
		 serverSocket.bind(addr);
		 System.out.println("Aceptando conexiones");

		 Socket newSocket = serverSocket.accept();
		 System.out.println("Conexión recibida");
		 InputStream is = newSocket.getInputStream();
		 OutputStream os = newSocket.getOutputStream();

		 os.write(numero);
		 numero++;
		 
		 serverSocket.accept();
		 System.out.println("Conexión recibida");
		 os.write(numero);
		 numero++;
		 
		 serverSocket.accept();
		 System.out.println("Conexión recibida");
		 os.write(numero);



		 System.out.println("Cerrando el nuevo socket");

		 newSocket.close();

		 System.out.println("Cerrando el socket servidor");

		 serverSocket.close();
} catch (IOException e) {
	 e.printStackTrace();
	 }}}
