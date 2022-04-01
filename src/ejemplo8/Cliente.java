package ejemplo8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;

		System.out.println("Programa iniciado");

		Socket cliente = null;

		try {
			cliente = new Socket(host, puerto);

			int numero = 1;

			ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			while (numero > 0) {

				System.out.println("Introduzca un número");
				numero = sc.nextInt();

				Numeros x = new Numeros();
				x.setNumero(numero);

				salida.reset();
				salida.writeObject(x);

				x = (Numeros) entrada.readObject();

				if (x.numero != 0) {
					System.out.println(
							"El cuadrado de " + numero + " es " + x.getCuadrado() + ", su cubo es " + x.getCubo());
				}

			}
			entrada.close();
			salida.close();
			cliente.close();
		} catch (ConnectException e) {
			System.out.println("Lo siento, el servidor no está disponible");
		}
		
	}

}
