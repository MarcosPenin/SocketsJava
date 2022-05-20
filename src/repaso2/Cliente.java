package repaso2;

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

		int mensaje = 1;
		int respuesta;
		
		while (mensaje!=0) {
			System.out.println("Introduce un número");
			mensaje = sc.nextInt();
			flujoSalida.write(mensaje);
			respuesta = flujoEntrada.read();
			System.out.println("Número: "+mensaje);
			System.out.println("Doble: " + respuesta);
			
		}
	
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}
}

