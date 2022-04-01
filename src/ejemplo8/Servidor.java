package ejemplo8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);

		int flag = 1;
		Socket cliente = servidor.accept();
		ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
		
		
		while (flag > 0) {
	
			Numeros numero = (Numeros) entrada.readObject();
			flag = numero.getNumero();
			numero.setCuadrado();
			numero.setCubo();			
			salida.reset();
			salida.writeObject(numero);
		}
		
		
		entrada.close();
		salida.close();
		cliente.close();
		servidor.close();
	}

}
