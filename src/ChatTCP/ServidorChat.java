package ChatTCP;

import java.io.*;
import java.net.*;

public class ServidorChat {
	static final int MAXIMO = 5;// MAXIMO DE CONEXIONES PERMITIDAS

	public static void main(String args[]) throws IOException {
		int PUERTO = 44444;

		ServerSocket servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");

		Socket tabla[] = new Socket[MAXIMO];// para controlar las conexiones
		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);

		/*
		 * El cambio fundamental es usar como referencia para aceptar conexiones el
		 * número actual de conexiones en vez del total
		 */

		while (comun.getACTUALES() <= MAXIMO) {
			if (comun.getACTUALES() < MAXIMO) {
				Socket socket = new Socket();
				socket = servidor.accept();// esperando cliente

				comun.addTabla(socket, comun.getACTUALES());

				comun.setACTUALES(comun.getACTUALES() + 1);

				comun.setCONEXIONES(comun.getCONEXIONES() + 1);

				HiloServidorChat hilo = new HiloServidorChat(socket, comun);
				hilo.start();
			}
		}
		servidor.close();
	}// main
}// ServidorChat..
