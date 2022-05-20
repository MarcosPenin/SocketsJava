package repaso1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String Host = "localhost";
		int Puerto = 6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

	
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

		String mensaje = "";
		int respuesta;
		
		while (!mensaje.equals("*")) {
			System.out.println("Introduce un mensaje");
			mensaje = sc.nextLine();
			flujoSalida.writeUTF(mensaje);
			respuesta = flujoEntrada.read();
			System.out.println("Tamaño: " + respuesta);
			
		}
	
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}
}

