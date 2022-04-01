package ejemplo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);
			System.out.println("Aceptando conexiones");

			Socket newSocket = serverSocket.accept();
			
			System.out.println("Conexión recibida. \nPuerto local: "
			+newSocket.getLocalPort()+"\nPuerto remoto: "+newSocket.getPort());
			
			serverSocket.accept();
			System.out.println("Aceptando conexiones");

			System.out.println("Conexión recibida. \nPuerto local: "
					+newSocket.getLocalPort()+"\nPuerto remoto: "+newSocket.getPort());
			
			
			
			System.out.println("*************************************");

			System.out.println("Cerrando el nuevo socket");

			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
