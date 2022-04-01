package ejemplo6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(1234);

		String mensaje = "";
		while (!mensaje.equals("*")) {
			System.out.println("Servidor esperando Datagrama");
			DatagramPacket recibo;
			byte[] bufer = new byte[1024];
			recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo);
			mensaje = new String(recibo.getData()).trim();
			System.out.println("Se ha recibido " + mensaje);

			String mensajeMayusculas = mensaje.toUpperCase();

			InetAddress IPOrigen = recibo.getAddress();
			int puerto = recibo.getPort();
			byte[] enviados = new byte[1024];
			enviados = mensajeMayusculas.getBytes();

			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			socket.send(envio);
		}
		System.out.println("Cerrando servidor");
		
		socket.close();

	}

}
