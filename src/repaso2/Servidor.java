package repaso2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6000;
		ServerSocket servidor = null;

		servidor = new ServerSocket(numeroPuerto);

		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();

		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);

		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);

			

		int recibido = 1;
		while (recibido!=0) {
			recibido = flujoEntrada.read();
			int respuesta=recibido*recibido;
			flujoSalida.write(respuesta);
		}

		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();

	}
}

