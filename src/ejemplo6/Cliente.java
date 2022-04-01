package ejemplo6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto = 1234;

		String mensaje = "";

		while (!mensaje.equals("*")) {
			System.out.println("Introduce mensaje: ");
			mensaje = sc.nextLine();
			byte[] enviados = new byte[1024];
			enviados = mensaje.getBytes();

			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
			clientSocket.send(envio);

			byte[] recibidos = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			clientSocket.receive(recibo);
			

			String mensajeRecibido = new String(recibo.getData()).trim();
			System.out.println(mensajeRecibido);

		}
		
		System.out.println("Cerrando cliente");
		
		clientSocket.close();

	}

}
